package com.szp.service;

import java.util.List;
import java.util.Map;

import com.szp.domain.Day;
import com.szp.domain.Employee;
import com.szp.domain.EmployeeAndDaysList;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public void addEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public void addDay(int employeeId, Day day);
	public List<Day> getDaysFromMonth(int employeeId, int month, int year);
	public Map<Employee, List<Day>> getAllEmployeesDaysFromMonth(int month, int year);
	public List<EmployeeAndDaysList> getEmployeeAndDaysList(int month, int year);
	public void setPlanned(int employeeId, int month, int year, int planned);
}
