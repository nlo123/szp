package com.szp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szp.domain.Day;
import com.szp.domain.Employee;
import com.szp.domain.EmployeeAndDaysList;
import com.szp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.getAllEmployees();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepo.addEmployee(employee);	
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepo.getEmployeeById(id);
	}
	
	@Override
	public void addDay(int employeeId, Day day) {
		Employee employee = getEmployeeById(employeeId);
		List<Day> days = employee.getDays();
		days.add(day);
		employee.setDays(days);
	}

	@Override
	public List<Day> getDaysFromMonth(int employeeId, int month, int year) {
		Employee employee = getEmployeeById(employeeId);
		List<Day> days = new ArrayList<>();
		for(Day d : employee.getDays()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(d.getDate());
			if(cal.get(Calendar.MONTH) == month-1 && cal.get(Calendar.YEAR) == year) {
				days.add(d);
			}
		}
		return days;
	}

	@Override
	public Map<Employee, List<Day>> getAllEmployeesDaysFromMonth(int month, int year) {
		List<Employee> employees = getAllEmployees();
		Map<Employee, List<Day>> days = new HashMap<>();
		for(Employee e : employees) {
			List<Day> ddays = getDaysFromMonth(e.getId(), month, year);
			if(!ddays.isEmpty()) days.put(e, ddays);
		}
		return days;
	}

	@Override
	public List<EmployeeAndDaysList> getEmployeeAndDaysList (int month, int year) {
		List<Employee> users = getAllEmployees();
		List<EmployeeAndDaysList> eadl = new ArrayList<>();
		for(Employee e : users) {
			List<Day> ddays = getDaysFromMonth(e.getId(), month, year);
			if(!ddays.isEmpty()) eadl.add(new EmployeeAndDaysList(e, ddays));
		}
		return eadl;
	}

	@Override
	public void setPlanned(int employeeId, int month, int year, int planned) {
		List<Day> days = getDaysFromMonth(employeeId, month, year);
		for(Day d : days) d.setPlanned(planned);
		
	}
}
