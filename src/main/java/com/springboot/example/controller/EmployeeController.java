package com.springboot.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.dto.EmployeeDTO;
import com.springboot.example.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO dto) {

		EmployeeDTO savedEmployee = employeeService.createEmployee(dto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long id) {
		EmployeeDTO e = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(e);
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> listEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(listEmployees);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO dto) {

		EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, dto);
		return ResponseEntity.ok(updatedEmployee);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {

		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee Deleted Successfully");

	}

}
