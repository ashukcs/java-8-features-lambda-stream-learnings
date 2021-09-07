package com.tachtalk.stream.api.liveexample;

import java.util.ArrayList;
import java.util.List;

public class DummyDatabase {
	public static List<Employee> getEmployees(){
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Suraj", "IT", 400000l));
		empList.add(new Employee(1, "Sam", "IT", 800000l));
		empList.add(new Employee(1, "Aman", "CIVIL", 600000l));
		empList.add(new Employee(1, "Rohan", "MACHANICAL", 500000l));
		
		return empList;
	}
}
