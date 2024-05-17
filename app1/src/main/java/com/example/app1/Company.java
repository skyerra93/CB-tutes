package com.example.app1;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private List<Employee> employees = new ArrayList<Employee>();
	private List<Integer> empIds = new ArrayList<Integer>();
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Integer> getEmpIds() {
		return empIds;
	}
	public void setEmpIds(List<Integer> empIds) {
		this.empIds = empIds;
	}
}
