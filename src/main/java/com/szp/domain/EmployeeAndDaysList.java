package com.szp.domain;

import java.util.List;

public class EmployeeAndDaysList {
	private Employee employee;
	private List<Day> listOfDays;
	
	public EmployeeAndDaysList(Employee employee, List<Day> listOfDays) {
		this.employee = employee;
		this.listOfDays = listOfDays;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Day> getListOfDays() {
		return listOfDays;
	}
	public void setListOfDays(List<Day> listOfDays) {
		this.listOfDays = listOfDays;
	}
}
