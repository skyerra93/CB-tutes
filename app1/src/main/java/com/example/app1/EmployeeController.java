package com.example.app1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("employee")
public class EmployeeController {


	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PostMapping("all")
	public List<Employee> saveAll(@RequestBody Company company) {
		List<Employee> employees = company.getEmployees();
		employeeRepository.saveAll(employees);
		return employees;
	}

	@GetMapping("count")
	public Long count() {
		return employeeRepository.count();
	}
	
	@GetMapping("availability/{id}")
	public Boolean checkAvailability(@PathVariable Integer id) {
		return employeeRepository.existsById(id);
	}
	
	@GetMapping
	public Iterable<Employee> readAll() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee read(@PathVariable Integer id) {
		return employeeRepository.findById(id).get();
	}
	

	
	@PostMapping("ids")
	public Iterable<Employee> readAllByIdsWithPost(@RequestBody Company company){
		List<Integer> ids = company.getEmpIds();
		return employeeRepository.findAllById(ids);
	}
	
	@DeleteMapping("/{id}")
	public Integer delete(@PathVariable Integer id) {
		employeeRepository.deleteById(id);
		return id;
	}
	
	@DeleteMapping
	public Employee delete(@RequestBody Employee employee) {
		employeeRepository.delete(employee);
		return employee;
	}
	
	@DeleteMapping("employees")
	public Iterable<Employee> deleteAllByIdsWithPost(@RequestBody Company company){
		List<Employee> employees = company.getEmployees();
		employeeRepository.deleteAll(employees);
		return employees;
	}
	
	@DeleteMapping("all")
	public String deleteAll(){
		employeeRepository.deleteAll();
		return "successfully deleted all the records";
	}
}
