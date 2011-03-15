package com.ingenium.tsp.report;

public class LogTRecord extends Record {
	private String taskId;
	private String cycle;
	private String date;
	private String responsible;
	private int min;

	public LogTRecord(String date,
			String cycle, String taskId, String responsible, int min) {
		this.date = date;
		this.cycle = cycle;
		this.taskId = taskId;
		this.responsible = responsible;
		this.min = min;
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

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

}
