package com.tachtalk.stream.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.tachtalk.stream.api.liveexample.DummyDatabase;
import com.tachtalk.stream.api.liveexample.Employee;

public class ListSortDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(12);
		list.add(9);
		
		//tranditional approaches
		/*
		 * Collections.sort(list); System.out.println(list); Collections.reverse(list);
		 * System.out.println(list);
		 */
		
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
			
		});
		System.out.println(list);
		//sort in ascending order
		list.stream().sorted().forEach(t->System.out.println(t));
		
		//sort in descending order
		list.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.println(t));
		
		//sort in ascending order and filter some data
		
		list.stream().filter(l->l%2!=0).forEach(t->System.out.println(t));
		
		//custom sorting
		List<Employee> employees = DummyDatabase.getEmployees();
		employees.sort(new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e2.getSalary().compareTo(e1.getSalary());
			}
		});
		
		System.out.println("Custom sorting--"+employees);
		
		employees.sort((e1, e2)->e1.getSalary().compareTo(e2.getSalary()));
		
		System.out.println("Custom Lambda sorting--"+employees);
		
		employees.stream().sorted((e1, e2)->e1.getSalary().compareTo(e2.getSalary())).forEach(t->System.out.println("Sorting using stream ---"+t));
		
		//sorting with function comparator
		employees.stream().sorted(Comparator.comparing(emp->emp.getId())).forEach(t->System.out.println("Soring Comparator functioning -"+t));
		
		//sorting using method reference
		System.out.println("Sorting using method reference - "+employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()));
		
	}
}
