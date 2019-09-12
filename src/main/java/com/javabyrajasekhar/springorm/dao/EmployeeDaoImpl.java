package com.javabyrajasekhar.springorm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.javabyrajasekhar.springorm.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployee() {
		TypedQuery<Employee> createQuery = entityManager.createQuery("select e from Employee e", Employee.class);
		return createQuery.getResultList();
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		entityManager.persist(theEmployee);
	}

	@Override
	public Employee getEmployee(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@Override
	public void deleteEmployee(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		if (employee != null) { 
			entityManager.remove(employee);
			System.out.println("employee not found");
		}
		else
			System.out.println("employee not found");
	}

}
