package co.com.losalpes.marketplace.pomanager.util;

/**
 *
 * @author Erik
 */
public class Constants {

    // PurchaseOrder
    public static final String NUM_SEGUIMIENTO_SEPARATOR = "-";
    // Excepciones
    public static final String EXC_ENTITY_INCOMPLETE = "Falta informacion para crear el ?";
    public static final String EXC_ENTITY_DETACHED = "No se debe enviar id para ? al momento de crearlo";
    public static final String EXC_ENTITY_TOO_MUCH_INFO = "No se esperaba el campo ?  en ?";
    public static final String EXC_COMERCIO_NO_EXISTE = "El comercio de nit ? no existe";
    public static final String EXC_FABRICANTE_NO_EXISTE = "El fabricante de nit ? no existe";

    public enum PurchaseOrderState {

        SolicitadoComercio, AceptadoFabricante, ProcesadoFabricante, EntregadoFabricante,
        AceptadoComercio, RechazadoComercio, RecibidoFabricante;

        public boolean isValidStateChange(PurchaseOrderState before, PurchaseOrderState after) {
            return before.compareTo(after) >= 0;
        }

        public static PurchaseOrderState getState(String strState) {
            PurchaseOrderState state = null;
            for (PurchaseOrderState pos : PurchaseOrderState.values()) {
                if (pos.toString().equals(strState)) {
                    state = pos;
                    break;
                }
            }
            return state;
        }
    }
}
