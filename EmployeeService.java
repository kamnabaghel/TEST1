package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class EmployeeService {
   @Autowired
	private EmployeeRepository employeeRepository;
	
   public List<Employee>listAllEmployee(){
		return employeeRepository.findAll();
	}

	public Employee  saveEmployee(Employee employee) {
		 return employeeRepository.save(employee);
		
	}
	


	public void deleteEmployee(Integer id) {
		
		employeeRepository.deleteById(id);;
		  
	}

	public Optional<Employee> findByIntegerId(Integer id) {
		
		return employeeRepository.findById(id);
	}

	public void deleteEmployeeUsingId(Integer id) {
		employeeRepository.deleteById(id);
		
	}
	
	
	

	
	
	
}
