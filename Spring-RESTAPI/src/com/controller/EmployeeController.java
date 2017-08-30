package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class EmployeeController {
	
	
	
	@RequestMapping("/hello")
    public String helloMethod1(@RequestParam(value="name", defaultValue="World") String name) {
 
          return   "Hello  "+ name;
    }

	// private static final Logger logger =
	// LoggerFactory.getLogger(EmployeeController.class);

	// Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public ResponseEntity<Employee> getDummyEmployee() {
		// logger.info("Start getDummyEmployee");
		System.out.println("Hello...");
	
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		System.out.println(new Date());
		empData.put(9999, emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int empId) {
		// logger.info("Start getEmployee. ID="+empId);
			System.out.println("Employee id is "+empId);
		return empData.get(empId);
	}

	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		// logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for (Integer i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		// logger.info("Start createEmployee.");
		System.out.println(emp.getId());
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
		//return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable("id") int empId) {
		// logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
	
	@RequestMapping(value = EmpRestURIConstants.UPDATE_EMP, method = RequestMethod.PUT)
	public Employee UpdateEmployee(@PathVariable("id") int empId, @RequestBody Employee employee) {
		Employee emp = empData.get(empId);
		System.out.println(employee);
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		empData.put(empId, emp);
		return emp;
	}

}