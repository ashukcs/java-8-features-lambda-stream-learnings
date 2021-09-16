package com.tachtalk.stream.filter;

import java.util.ArrayList;
import java.util.List;

public class DummyDatabase {
	public static List<Employee> getEmployees(){
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(123, "Suraj", "IT", 400000l));
		empList.add(new Employee(145, "Sam", "IT", 800000l));
		empList.add(new Employee(11, "Aman", "CIVIL", 600000l));
		empList.add(new Employee(165, "Rohan", "MACHANICAL", 500000l));
		
		return empList;
	}
}
