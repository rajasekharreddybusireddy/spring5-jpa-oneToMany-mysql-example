package com.javabyrajasekhar.springorm.dao;

import java.util.List;

import com.javabyrajasekhar.springorm.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployee();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
	
}
