

package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {

	     @Autowired
	    EmployeeService employeeService;
	
	    @GetMapping("/api/employee")
	    public List<Employee> list() {
	        return employeeService.listAllEmployee();
	    }

	    @PostMapping("/employees")
	    public Employee newEmployee(@RequestBody Employee newEmployee) {
	      
		return employeeService.saveEmployee(newEmployee);
	    }
		
		@GetMapping("/api/v1/employee/{id}")
		Optional<Employee> getEmployeeById(@PathVariable Integer id){
			
			return employeeService.findByIntegerId(id);
			
		}
		@DeleteMapping("/del/employee/{id}")
		public void deleteEmployee(@PathVariable Integer id) {
			employeeService.deleteEmployeeUsingId(id);
		}
		
		
	
		
		/* @GetMapping("/emp/id") public ResponseEntity<Employee> get(@PathVariable
		 * Integer id) { try { Employee employee = employeeService.getEmployee(id);
		 * return new ResponseEntity<Employee>(employee, HttpStatus.OK); }
		 * catch(NoSuchElementException e) { return new
		 * ResponseEntity<Employee>(HttpStatus.NOT_FOUND); } }
		 */
		  
		  @PostMapping("/api/v1/employee/save") public void add(@RequestBody Employee employee) {
		  employeeService.saveEmployee(employee); }
		  
		  @PutMapping("/{id}")
		  public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) 
		  {
			  try {
		  
		   employee.setId(id);
		  employeeService.saveEmployee(employee); 
		  return new ResponseEntity<>(HttpStatus.OK); 
		  } 
			  catch (NoSuchElementException e) { 
				  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			  }
			  
			  }
		 
		 
		
		  
		  
		  @DeleteMapping("/{id}") 
		  public void delete(@PathVariable Integer id) {
		  
		   employeeService.deleteEmployee(id);
		   }
		 
		  /*
		  @PostMapping("/{save}") public void add(@RequestBody Employee employee) {
		  employeeService.saveEmployee(employee); }
		  
		  @PutMapping("/{id}") public ResponseEntity<?> update(@RequestBody Employee
		  employee, @PathVariable Integer id) { try { Employee existUser =
		  employeeService.getEmployee(id); employee.setId(id);
		  employeeService.saveEmployee(employee); return new
		  ResponseEntity<>(HttpStatus.OK); } catch (NoSuchElementException e) { return
		  new ResponseEntity<>(HttpStatus.NOT_FOUND); }
		 
		 
		/*
		 * }
		 * 
		 * @DeleteMapping("/{id}") public void delete(@PathVariable Integer id) {
		 * 
		 * employeeService.deleteEmployee(id); }
		 */
   
}
