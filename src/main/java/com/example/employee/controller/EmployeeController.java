package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
//@RequestMapping("/api")
@RequestMapping()
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	// @RequestMapping(value="/employees", method=RequestMethod.POST)
	@PostMapping(value = "/employees")
	public Employee createEmployee(@RequestBody Employee emp) {
		return empService.createEmployee(emp);
	}

	// @RequestMapping(value="/employees", method=RequestMethod.GET)
	@GetMapping(value = "/employees")
	public List<Employee> readEmployees() {
		return empService.getEmployees();
	}

	// custom JPA find method
	@GetMapping(value = "/employees/{firstName}")
	public List<Employee> getEmpByEmailId(@PathVariable(value = "firstName") String firstName) {
		return empService.findByName(firstName);
	}

	// @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
	@PutMapping(value = "/employees/{empId}")
	public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
		return empService.updateEmployee(id, empDetails);
	}

	// @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
	@DeleteMapping(value = "/employees/{empId}")
	public void deleteEmployees(@PathVariable(value = "empId") Long id) {
		empService.deleteEmployee(id);
	}

}
