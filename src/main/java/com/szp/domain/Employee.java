package com.szp.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Employee {
	private static int idS = 0;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private List<Day> days = new ArrayList<>();
	
	{
		idS++;
	}
	
	public Employee() {
		this.id = idS;
	};
	
	public Employee(int id, String firstName, String lastName, String address, List<Day> days) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.days = days;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = idS;
	}	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Day> getDays() {
		return days;
	}
	
	public void setDays(List<Day> days) {
		this.days = days;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
}
