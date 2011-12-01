package co.com.losalpes.marketplace.riskqualification;

/**
 * Interfaz empleada para identificar las entidades
 * @author Erik
 */
public interface MarketPlaceEntity {

    /**
     * Determina si la informacion presente en el objeto es suficiente para almacenarlo
     * @return true si la informacion esta completa
     */
    public boolean isInfoComplete();
}