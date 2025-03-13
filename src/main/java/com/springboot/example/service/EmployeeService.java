package com.springboot.example.service;

import java.util.List;

import com.springboot.example.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO createEmployee(EmployeeDTO employeeDto);
	EmployeeDTO getEmployeeById(long id);
	List<EmployeeDTO> getAllEmployees();	
	EmployeeDTO updateEmployee(long id,EmployeeDTO employeeDto);
	void deleteEmployee(long employeeId);
	

}
