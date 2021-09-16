package com.tachtalk.stream.custom_mapreducer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {
	public static List<Employee> getEmployees() {
		return Stream.of(
			new Employee(102, "Peter", 'A', 90000), 
			new Employee(103, "Mark", 'B', 60000),
			new Employee(105, "Elon", 'A', 95000), 
			new Employee(106, "Sam", 'C', 55000),
			new Employee(104, "Martin", 'D', 40000)
			)
			.collect(Collectors.toList());

	}
}
