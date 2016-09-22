package com.szp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.szp.domain.Day;
import com.szp.domain.Employee;
import com.szp.domain.EmployeeAndDay;
import com.szp.domain.EmployeeAndDaysList;
import com.szp.service.EmployeeService;

@Controller
@RequestMapping("/")
public class RestController {
	private EmployeeService employeeService;
	
	@Autowired
	public RestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, headers={"Content-Type=application/json"})
	@ResponseBody
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers={"Content-Type=application/json"})
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	void addUser(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping(value = "/addDay", method = RequestMethod.POST,  headers={"Content-Type=application/json"})
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	void addDay(@RequestBody EmployeeAndDay ead) {
		employeeService.addDay(ead.getId(), ead.getDay());
	}
	
	@RequestMapping(value = "/getDaysFromMonth/{month}/{year}", method = RequestMethod.GET,  headers={"Content-Type=application/json"})
	@ResponseBody
	Map<Employee, List<Day>> getAllDayFromMonth(@PathVariable int month, @PathVariable int year) {
		return employeeService.getAllEmployeesDaysFromMonth(month, year);
	}
	
	@RequestMapping(value = "/getEmployeeAndDaysList/{month}/{year}", method = RequestMethod.GET,  headers={"Content-Type=application/json"})
	@ResponseBody
	List<EmployeeAndDaysList> getEmployeeAndDaysList(@PathVariable int month, @PathVariable int year) {
		return employeeService.getEmployeeAndDaysList(month, year);
	}
	
	@RequestMapping(value = "/setPlanned", method = RequestMethod.GET,  headers={"Content-Type=application/json"})
	void setPos(@RequestParam int month, @RequestParam int year, @RequestParam int userId, @RequestParam int pos) {
		employeeService.setPlanned(userId, month, year, pos);
	}
}
