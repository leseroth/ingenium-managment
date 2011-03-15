package com.ingenium.tsp.report;

public class LocRecord extends Record {
	private int size;
	private String testClass;
	private String testMember;
	private String cycle;

	public LocRecord(String testClass, String testMember, int size, String cycle) {
		this.testClass = testClass;
		this.testMember = testMember;
		this.size = size;
		this.cycle = cycle;
	}

	public String getTestClass() {
		return testClass;
	}

	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}

	public String getTestMember() {
		return testMember;
	}

	public void setTestMember(String testMember) {
		this.testMember = testMember;
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
}