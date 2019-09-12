package com.javabyrajasekhar.springorm.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabyrajasekhar.springorm.entity.Employee;
import com.javabyrajasekhar.springorm.entity.Employee_Address;
import com.javabyrajasekhar.springorm.service.EmployeeService;

public class AppMain {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		 EmployeeService employeeService = context.getBean(EmployeeService.class);
		//saveEmployee(employeeService);
		
		 //getAllEmployees(employeeService);
		 
		 getEmployeeById(employeeService);
		 
		 //employeeService.deleteEmployee(1);
		 
		context.close();
	}


	private static void getEmployeeById(EmployeeService employeeService) {
		Employee employee2 = employeeService.getEmployee(1);
		 System.out.println("id : - "+employee2.getEmpId());
			System.out.println("name : - "+employee2.getEmpName());
			Set<Employee_Address> employeeAddress = employee2.getEmployeeAddress();
			for (Employee_Address employee_Address : employeeAddress) {
				System.out.println("-----------------------------------------");
				System.out.println("addrId : - "+employee_Address.getAddrId());
				System.out.println("city : - "+employee_Address.getCity());
				System.out.println("country : - "+employee_Address.getCountry());
				System.out.println("state : - "+employee_Address.getState());
				System.out.println("street : - "+employee_Address.getStreet());
				System.out.println("------------------------------------------------");
			}
	}


	private static void getAllEmployees(EmployeeService employeeService) {
		List<Employee> employee = employeeService.getEmployee();
		 for (Employee employee2 : employee) {
			System.out.println("id : - "+employee2.getEmpId());
			System.out.println("name : - "+employee2.getEmpName());
			Set<Employee_Address> employeeAddress = employee2.getEmployeeAddress();
			for (Employee_Address employee_Address : employeeAddress) {
				System.out.println("-----------------------------------------");
				System.out.println("addrId : - "+employee_Address.getAddrId());
				System.out.println("city : - "+employee_Address.getCity());
				System.out.println("country : - "+employee_Address.getCountry());
				System.out.println("state : - "+employee_Address.getState());
				System.out.println("street : - "+employee_Address.getStreet());
				System.out.println("------------------------------------------------");
			}
			
			
		}
	}


public static  void saveEmployee(EmployeeService employeeService)
{
    Employee employee = new Employee();
    employee.setEmpName("JIP");
    
    Employee_Address employeeAddress1 = new Employee_Address();
    employeeAddress1.setStreet("Street 1");
    employeeAddress1.setCity("City 1");
    employeeAddress1.setCountry("Country 1");
    employeeAddress1.setState("State 1");
    employeeAddress1.setEmployee(employee);
    
    
    Employee_Address employeeAddress2 = new Employee_Address();
    employeeAddress2.setStreet("Street 2");
    employeeAddress2.setCity("City 2");
    employeeAddress2.setCountry("Country 2");
    employeeAddress2.setState("State 2");
    employeeAddress2.setEmployee(employee);
    
    Set<Employee_Address> employeeAddressSet = new HashSet<Employee_Address>();
    employeeAddressSet.add(employeeAddress1);
    employeeAddressSet.add(employeeAddress2);
    
    employee.setEmployeeAddress(employeeAddressSet);
    
    employeeService.saveEmployee(employee);
    System.out.println("Employee and Employee Address saved successfully!!");
}
}
