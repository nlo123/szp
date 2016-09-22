package com.szp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.szp.domain.Employee;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {
	List<Employee> employees = new ArrayList<>();
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public Employee getEmployeeById(int id) {
		for(Employee employee : employees) {
			if(employee.getId() == id) return employee;
		}
		return null;
	}

	public List<Employee> getEmployeesByNames(String firstName, String lastName) {
		List<Employee> employees = new ArrayList<>();
		for(Employee employee : employees) {
			if(employee.getFirstName() == firstName && employee.getLastName() == lastName) employees.add(employee);
		}
		return employees;
	}

	public List<Employee> getAllEmployees() {
		return employees;
	}

}
