package com.ingenium.tsp.report;

import com.ingenium.tsp.model.Task;

public class DurationRecord extends Record {
    private int cycle;
    private int stage;
    private double plannedTime;
    private int realTime;
    
    public DurationRecord(Task task, int time){
	cycle = Integer.parseInt(task.getCiclo());
	stage = Integer.parseInt(task.getFase());
	plannedTime = Double.parseDouble(task.getTiempoEstimado());
	realTime = time;
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

    public void addTime(int time) {
	realTime = time + realTime;
    }
}
