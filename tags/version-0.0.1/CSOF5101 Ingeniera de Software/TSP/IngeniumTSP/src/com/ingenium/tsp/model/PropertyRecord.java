package com.ingenium.tsp.model;

public abstract class PropertyRecord {

    protected String id;

    protected static final String SEPARATOR = "]";

    public abstract String encodeData();

    public abstract void decodeData(String encodedData);

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
}
