package co.com.losalpes.marketplace.transact.util;

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
    public static final String EXC_ENTITY_TOO_MUCH_INFO = "No se esperaba el campo ? en ?";
    public static final String EXC_ENTITY_TOO_FEW_INFO = "Se esperaba el campo ? en ?";
    public static final String EXC_ENTITY_INEXSISTENT = "La entidad ? identificada por ? no existe";
    public static final String EXC_INCORRECT_STATE = "El estado ? no es un estado valido";
    public static final String EXC_INCORRECT_ARGUMENT = "Los siguientes argumentos tienen valores no validos: ?";
    public static final String EXC_PO_STATE_UPDATE = "Error en la actualizacion de estado: ?";
    public static final String EXC_DUPLICATED_FIELD = "El campo ? con valor ? ya existe en ?";

    /**
     * Enumeracion para almacenar los estados posibles de una orden de compra
     */
    public enum PurchaseOrderState {

        SolicitadoComercio, AceptadoFabricante, RechazadoFabricante, ProcesadoFabricante,
        EntregadoFabricante, AceptadoComercio, RechazadoComercio, RecibidoFabricante;

        public static boolean isValidStateChange(PurchaseOrderState before, PurchaseOrderState after) {
            return before.compareTo(after) < 0;
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
