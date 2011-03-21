package com.ingenium.tsp.report;

public class ProductivityRecord extends Record {
    private int size;
    private int min;
    private String responsible;
    private String cycle;

    public int getSize() {
	return size;
    }

    public void setSize(int size) {
	this.size = size;
    }

    public int getMin() {
	return min;
    }

    public void setMin(int min) {
	this.min = min;
    }

    public String getResponsible() {
	return responsible;
    }

    public void setResponsible(String responsible) {
	this.responsible = responsible;
    }

    public String getCycle() {
	return cycle;
    }

    public void setCycle(String cycle) {
	this.cycle = cycle;
    }

    public double getProductivity() {
	return min == 0 ? min : (double)size / ((double)min / 60);
    }
}
