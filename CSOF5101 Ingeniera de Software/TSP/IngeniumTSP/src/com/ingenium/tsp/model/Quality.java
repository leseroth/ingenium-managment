package com.ingenium.tsp.model;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.util.Constants;

public class Quality extends PropertyRecord {

    public enum EtapaQuality {
	LANZAMIENTO("lanzamiento"), CICLO_1("ciclo1"), CICLO_2("ciclo2"), CICLO_3("ciclo3");

	private String etapa;

	EtapaQuality(String etapa) {
	    this.etapa = etapa;
	}

	public String getEtapa() {
	    return etapa;
	}
    }
    
    String defectosInyectados;
    String defectosRemovidos;
    String defectosInyectadosReal;
    String defectosRemovidosReal;
    
    public Quality(){
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 1, responsible = "201110949") })
    public Quality(String encoded) {
	decodeData(encoded);
    }
    
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 11, responsible = "201110949") })
    public String encodeData() {
	StringBuffer encoded = new StringBuffer();
	encoded.append(id);
	encoded.append(SEPARATOR);
	encoded.append(defectosInyectados);
	encoded.append(SEPARATOR);
	encoded.append(defectosRemovidos);
	encoded.append(SEPARATOR);
	encoded.append(defectosInyectadosReal);
	encoded.append(SEPARATOR);
	encoded.append(defectosRemovidosReal);
	return encoded.toString();
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 6, responsible = "201110949") })
    public void decodeData(String encodedData) {
	String[] decoded = encodedData.split(SEPARATOR);
	id = decoded[0];
	defectosInyectados = decoded[1];
	defectosRemovidos = decoded[2];
	defectosInyectadosReal = decoded[3];
	defectosRemovidosReal = decoded[4];
    }

    public String getDefectosInyectados() {
        return defectosInyectados;
    }

    public void setDefectosInyectados(String defectosInyectados) {
        this.defectosInyectados = defectosInyectados;
    }

    public String getDefectosRemovidos() {
        return defectosRemovidos;
    }

    public void setDefectosRemovidos(String defectosRemovidos) {
        this.defectosRemovidos = defectosRemovidos;
    }

    public String getDefectosInyectadosReal() {
        return defectosInyectadosReal;
    }

    public void setDefectosInyectadosReal(String defectosInyectadosReal) {
        this.defectosInyectadosReal = defectosInyectadosReal;
    }

    public String getDefectosRemovidosReal() {
        return defectosRemovidosReal;
    }

    public void setDefectosRemovidosReal(String defectosRemovidosReal) {
        this.defectosRemovidosReal = defectosRemovidosReal;
    }

}
