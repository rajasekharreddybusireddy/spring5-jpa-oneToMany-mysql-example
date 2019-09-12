package com.javabyrajasekhar.springorm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabyrajasekhar.springorm.dao.EmployeeDao;
import com.javabyrajasekhar.springorm.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployee() {

		return employeeDao.getEmployee();
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		employeeDao.saveEmployee(theEmployee);
	}

	@Override
	public Employee getEmployee(int theId) {
		return employeeDao.getEmployee(theId);
	}

	@Override
	public void deleteEmployee(int theId) {
		employeeDao.deleteEmployee(theId);
	}

}
