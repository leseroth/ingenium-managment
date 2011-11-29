package co.com.losalpes.marketplace.facturacion.util;

import co.com.losalpes.marketplace.facturacion.entities.Cargo;
import co.com.losalpes.marketplace.facturacion.entities.CuentaFacturacion;
import co.com.losalpes.marketplace.facturacion.entities.Factura;
import co.com.losalpes.marketplace.facturacion.exceptions.BussinessException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author marketplace
 */
public class BillGeneration {

    public static Factura generateBill(CuentaFacturacion cuenta, int plazo) throws BussinessException {
        try {
            Connection conn = darConexion();
            String path = new File(".").getCanonicalPath();
            System.setProperty("jasper.reports.compile.class.path", path + "/jasperreports-4.0.2.jar");

            Map parameters = new HashMap();
            parameters.put("numeroCuenta", cuenta.getNumeroCuenta());
            Date fechaInicio = cuenta.getFechaUltimoCorte();
            parameters.put("fechaInicio", fechaInicio);
            cuenta.setFechaUltimoCorte(new Date(System.currentTimeMillis()));
            parameters.put("fechaFin", cuenta.getFechaUltimoCorte());
            Calendar cal = Calendar.getInstance();
            cal.setTime(cuenta.getFechaUltimoCorte());
            cal.add(Calendar.DAY_OF_MONTH, plazo);
            parameters.put("plazo", cal.getTime());
            JasperReport report = JasperCompileManager.compileReport(path + "/factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);

            Factura f = new Factura();
            File ruta = new File("C:\\BillingCharges\\facturas\\" + cuenta.getCliente().getNit());
            if (!ruta.exists()) {
                ruta.mkdirs();
            }
            f.setUrl("C:\\BillingCharges\\facturas\\" + cuenta.getCliente().getNit() + "\\" + f.getNombreArchivo() + ".pdf");
            f.setFechaInicio(fechaInicio);
            f.setFechaFin(cuenta.getFechaUltimoCorte());

            Long valorPago = 0L;
            for (int i = 0; i < cuenta.getCargoList().size(); i++) {
                Cargo c = cuenta.getCargoList().get(i);
                if (c.getFecha().after(fechaInicio) && c.getFecha().before(cuenta.getFechaUltimoCorte())) {
                    valorPago += c.getValor();
                }
            }
            f.setValorPago(valorPago);

            JasperExportManager.exportReportToPdfFile(print, f.getUrl());
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BussinessException("Error generando la factura");
        }
    }

    private static Connection darConexion() throws BussinessException {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String connectString = "jdbc:mysql://portal.marketplace.losalpes.com.co:3306/billingcharges";
            String user = "jasperreports";
            String password = "marketplace";
            return DriverManager.getConnection(connectString, user, password);
        } catch (Exception ex) {
            throw new BussinessException("No se pudo realizar la conexión a la base de datos.");
        }
    }
}
