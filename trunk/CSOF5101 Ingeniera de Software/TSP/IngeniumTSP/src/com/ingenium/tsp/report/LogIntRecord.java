package com.ingenium.tsp.report;

public class LogIntRecord extends Record {
    private String interruption;
    private String cycle;
    private String date;
    private String responsible;
    private int min;
    
    public LogIntRecord(){
    }

    public LogIntRecord(String interruption, String cycle, String date, String responsible, int min) {
	super();
	this.interruption = interruption;
	this.cycle = cycle;
	this.date = date;
	this.responsible = responsible;
	this.min = min;
    }

    public String getInterruption() {
	return interruption;
    }

    public void setInterruption(String interruption) {
	this.interruption = interruption;
    }

    public String getCycle() {
	return cycle;
    }

    public void setCycle(String cycle) {
	this.cycle = cycle;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getResponsible() {
	return responsible;
    }

    public void setResponsible(String responsible) {
	this.responsible = responsible;
    }

    public int getMin() {
	return min;
    }

    public void setMin(int min) {
	this.min = min;
    }

}
