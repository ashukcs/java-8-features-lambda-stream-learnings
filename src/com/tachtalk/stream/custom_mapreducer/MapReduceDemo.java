package com.tachtalk.stream.custom_mapreducer;

import java.util.List;
import java.util.function.Consumer;

public class MapReduceDemo {
	public static void main(String[] args) {
		List<Employee> employees = EmployeeDatabase.getEmployees();
		
		//traditional iteration
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		//using simple iteration with stream api loop
		employees.forEach(new Consumer<Employee>() {
			public void accept(Employee e) {
				System.out.println("Iteration using simple stream api" + e);
			}
		});
		
		//get employee whose grade is A
		//get salary
		double averageSal = employees.stream().filter(e->e.getGrade().equals(Character.valueOf('A')))
		.map(employee->employee.getSalary())
		.mapToDouble(e->e)
		.average().getAsDouble();
		
		System.out.println(averageSal);
		
		double sumSalary = employees.stream().filter(employee->employee.getGrade().equals(Character.valueOf('A')))
				.map(employee->employee.getSalary())
				.mapToDouble(salary->salary)
				.sum();
		
		System.out.println(sumSalary);
		
	}
}
