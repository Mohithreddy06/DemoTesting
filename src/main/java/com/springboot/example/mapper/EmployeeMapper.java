package com.springboot.example.mapper;

import com.springboot.example.dto.EmployeeDTO;
import com.springboot.example.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDTO mapTOEmployeeDTO(Employee employee) {
		return new EmployeeDTO(				
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()				
				);
	}
	
	
	public static Employee mapTOEmployee(EmployeeDTO employeeDTO) {
		return new Employee(				
				employeeDTO.getId(),
				employeeDTO.getFirstName(),
				employeeDTO.getLastName(),
				employeeDTO.getEmail()				
				);
	}

}
