package com.tachtalk.stream.filter;

import java.util.List;
import java.util.stream.Collectors;

public class TestService {
	public static void main(String[] args) {

		System.out.println(evaluateTaxEmployee("non tax"));
		
	}

	public static List<Employee> evaluateTaxEmployee(String input) {
		/*
		 * if(input.equalsIgnoreCase("tax")) return
		 * DummyDatabase.getEmployees().stream().filter(emp -> emp.getSalary() >
		 * 600000l).collect(Collectors.toList()); else return
		 * DummyDatabase.getEmployees().stream().filter(emp -> emp.getSalary() <=
		 * 600000l).collect(Collectors.toList());
		 */

		return (input.equalsIgnoreCase("tax"))
				? DummyDatabase.getEmployees().stream().filter(emp -> emp.getSalary() > 600000l)
						.collect(Collectors.toList())
				: DummyDatabase.getEmployees().stream().filter(emp -> emp.getSalary() <= 600000l)
						.collect(Collectors.toList());
	}
	
}
