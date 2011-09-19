package co.com.losalpes.marketplace.pomanager;

/**
 * Interfaz empleada para identificar las entidades
 * @author Erik
 */
public interface MarketPlaceEntity {

    /**
     * Convierte la entidad en su respectivo BussinesObject
     * @return
     */
    public MarketPlaceBO toBO();

    /**
     * Determina si la informacion presente en el objeto es suficiente para almacenarlo
     * @return
     */
    public boolean isInfoComplete();
}
