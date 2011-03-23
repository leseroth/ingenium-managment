package com.ingenium.tsp.model;


public class Task extends PropertyRecord implements Comparable<Task> {

    String ciclo;
    String fase;
    String name;
    String tiempoEstimado;
    String valorEstimado;
    String responsable;

    public Task(){
    }
    
    public Task(String encoded) {
	decodeData(encoded);
    }

    @Override
    public String encodeData() {
	StringBuffer encoded = new StringBuffer();
	encoded.append(id);
	encoded.append(SEPARATOR);
	encoded.append(ciclo);
	encoded.append(SEPARATOR);
	encoded.append(fase);
	encoded.append(SEPARATOR);
	encoded.append(name);
	encoded.append(SEPARATOR);
	encoded.append(tiempoEstimado);
	encoded.append(SEPARATOR);
	encoded.append(valorEstimado);
	encoded.append(SEPARATOR);
	encoded.append(responsable);
	return encoded.toString();
    }

    @Override
    public void decodeData(String encodedData) {
	String[] decoded = encodedData.split(SEPARATOR);
	id = decoded[0];
	ciclo = decoded[1];
	fase = decoded[2];
	name = decoded[3];
	tiempoEstimado = decoded[4];
	valorEstimado = decoded[5];
	responsable = decoded[6];	
    }    

    @Override
    public int compareTo(Task o) {
	return getId().compareToIgnoreCase(o.getId());
    }
    
    public String toString() {
        return name;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(String valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

}
