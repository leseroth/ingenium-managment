package com.ingenium.tsp.report;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.util.Constants;

public class LocRecord extends Record {
    private int size;
    private String responsible;
    private String cycle;

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 3, responsible = "201110949") })
    public LocRecord(int size, String cycle, String responsible) {
	this.size = size;
	this.cycle = cycle;
	this.responsible = responsible;
    }

    public String getCycle() {
	return cycle;
    }

    public void setCycle(String cycle) {
	this.cycle = cycle;
    }

    public int getSize() {
	return size;
    }

    public void setSize(int size) {
	this.size = size;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201110949") })
    public String getResponsible() {
        return responsible;
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 1, responsible = "201110949") })
    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
}
