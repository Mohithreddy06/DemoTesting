package com.springboot.example.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.example.dto.EmployeeDTO;
import com.springboot.example.entity.Employee;
import com.springboot.example.exception.ResponseNotFoundException;
import com.springboot.example.mapper.EmployeeMapper;
import com.springboot.example.repository.EmployeeRepository;
import com.springboot.example.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {

		Employee employee = EmployeeMapper.mapTOEmployee(employeeDto);

		Employee savedEmployee = employeeRepository.save(employee);

		return EmployeeMapper.mapTOEmployeeDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmployeeById(long id) {
		Employee e = employeeRepository.findById(id)
				.orElseThrow(() -> new ResponseNotFoundException("Employee not found with the provided id " + id));
		return EmployeeMapper.mapTOEmployeeDTO(e);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> listEmployees = employeeRepository.findAll();
		return listEmployees.stream().map((employee) -> EmployeeMapper.mapTOEmployeeDTO(employee))
				.collect(Collectors.toList());
		
		//return listEmployees.stream().map((employee) -> EmployeeMapper.mapTOEmployeeDTO(employee)).toList();
	}

	@Override
	public EmployeeDTO updateEmployee(long id, EmployeeDTO employeeDto) {
		Employee e = employeeRepository.findById(id)
				.orElseThrow(() -> new ResponseNotFoundException("Employee not found with the provided id " + id));

		e.setFirstName(employeeDto.getFirstName());
		e.setLastName(employeeDto.getLastName());
		e.setEmail(employeeDto.getEmail());
		Employee savedEmployee = employeeRepository.save(e);

		return EmployeeMapper.mapTOEmployeeDTO(savedEmployee);
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Employee e = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResponseNotFoundException("Employee not found with the provided id " + employeeId));
		
		employeeRepository.deleteById(employeeId);
		
	}

}
