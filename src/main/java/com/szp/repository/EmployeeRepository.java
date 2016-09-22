package com.szp.repository;

import java.util.List;

import com.szp.domain.Employee;

public interface EmployeeRepository {
	public void addEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeesByNames(String firstName, String lastName);
	public List<Employee> getAllEmployees();
}
