package com.tachtalk.stream.parallelstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tachtalk.stream.map_reduce.Employee;

public class EmployeeDB {
	public static List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		Random random = new Random();
		for(int i=0; i<=1000; i++) {
			
			employees.add(new Employee(i, "Employee-"+i, (char) (random.nextInt(26)+'a'), Double.valueOf(random.nextInt(1000*100))));
		}
		
		return employees;
	}
}
