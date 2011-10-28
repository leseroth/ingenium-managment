package com.ingenium.tsp.test;

import com.ingenium.tsp.report.*;
import com.ingenium.tsp.util.Constants;
import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.*;

import junit.framework.TestCase;

/*
 *Clase usada para verificar métodos de la clase Report 
 * */
public class ReportTest extends TestCase {
    
    //Reporte usado para casos de prueba
    private Report report;
    
    private Analizer analizer;
    
    /*
     * Establece los valores de report para las pruebas.
     * */
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 3, responsible = "201110544") })
    private void setupEscene1() {
	//Cargar el analizador y el objeto report
	analizer = new Analizer();
	analizer.checkProject();
	report = analizer.getReport();		
    }
    
    /*
     * Verifica la que los registros de productividad generados sean correctos
     * Objetivo: Verificar que el ciclo, los minutos y la productividad no sean vacios
     * Resultados esperados: Ningún resultado debe tener el ciclo, los minutos o la productividad en blanco
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 5, responsible = "201110544") })
    public void testProductivityResult()
    {
	//Configura el escenario para la prueba
	setupEscene1();
	
	//recorrer los valores de la productividad y verificar cada uno de sus datos
	for (ProductivityRecord productivityRecord : report.getProductivityReport().values()) {
	    //Verificar que el ciclo exista
	    assertTrue(productivityRecord.getCycle() != "" && productivityRecord.getCycle() != null );
	    
	    //Verificar que los minutos no sean negativos
	    assertTrue(productivityRecord.getMin() >=0);
	    
	    //verificar que la productividad no sea negativa
	    assertTrue(productivityRecord.getProductivity() >=0);
        }
    }
}
