package com.ingenium.tsp.report;

import java.util.HashMap;
import java.util.Map;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.model.Task;
import com.ingenium.tsp.util.Constants;

public class DurationRecord extends Record {
    private int cycle;
    private int stage;
    private double plannedTime;
    private int realTime;
    private Map<String, Task> taskMap;
    
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 4, responsible = "201110949") })
    public DurationRecord(Task task, int time){
	taskMap = new HashMap<String, Task>();
	cycle = Integer.parseInt(task.getCiclo());
	stage = Integer.parseInt(task.getFase());
	plannedTime = Double.parseDouble(task.getTiempoEstimado());
	realTime = time;
	taskMap.put(task.getId(), task);
    }

    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 5, responsible = "201110949") })
    public DurationRecord(int cycle, int stage, double plannedTime, int realTime) {
	super();
	this.cycle = cycle;
	this.stage = stage;
	this.plannedTime = plannedTime;
	this.realTime = realTime;
    }

    public int getCycle() {
	return cycle;
    }

    public int getStage() {
	return stage;
    }
    
    public double getPlanneTime() {
	return plannedTime;
    }

    public int getRealTime() {
	return realTime;
    }

    public void addTime(int addRealtime) {
	realTime = addRealtime + realTime;
    }
    
    public void addTime(Task task, int addRealtime) {
	realTime = addRealtime + realTime;
	if(taskMap.get(task.getId())==null) {
	    taskMap.put(task.getId(), task);
	    plannedTime = Double.parseDouble(task.getTiempoEstimado()) + plannedTime;
	}
    }
}
