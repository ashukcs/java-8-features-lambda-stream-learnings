package com.tachtalk.stream.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.tachtalk.stream.api.liveexample.Employee;

public class MapSortDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		map.put(5, "A");
		map.put(3, "B");
		map.put(8, "C");
		map.put(9, "D");
		map.put(2, "E");

		List<Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());

		// Traditional approach of sorting
		Collections.sort(entries, new Comparator<Entry<Integer, String>>() {

			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println("***************************************");
		// Sorting using Lambda expression
		Collections.sort(entries, (entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));
		for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}
		System.out.println("***************************************");
		// Sorting using stream api comparator
		map.entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue())).forEach(System.out::println);
		System.out.println("***************************************");
		// Soring using stream api functioning comparator
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

		System.out.println("***************************************");
		// Soring using stream api functioning comparator
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		System.out.println("***************************************");
		// Sorting map of custom object using traditional approach
		Map<Employee, Integer> employeeMap = new TreeMap<>(new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		employeeMap.put(new Employee(123, "Suraj", "IT", 400000l), 50);
		employeeMap.put(new Employee(145, "Sam", "IT", 800000l), 70);
		employeeMap.put(new Employee(11, "Aman", "CIVIL", 600000l), 65);
		employeeMap.put(new Employee(165, "Rohan", "MACHANICAL", 500000l), 80);

		System.out.println(employeeMap);
		System.out.println("***************************************");
		// Sorting map of custom object using lambda
		Map<Employee, Integer> employeeMap1 = new TreeMap<>(
				(Employee o1, Employee o2) -> o2.getSalary().compareTo(o1.getSalary()));

		employeeMap1.put(new Employee(123, "Suraj", "IT", 400000l), 50);
		employeeMap1.put(new Employee(145, "Sam", "IT", 800000l), 70);
		employeeMap1.put(new Employee(11, "Aman", "CIVIL", 600000l), 65);
		employeeMap1.put(new Employee(165, "Rohan", "MACHANICAL", 500000l), 80);

		System.out.println(employeeMap1);
		
		System.out.println("***************************************");
		// Sorting map of custom object using stream api
		employeeMap1.entrySet().stream().sorted((e1,e2)->e1.getKey().getDept().compareTo(e2.getKey().getDept())).forEach(System.out::println);

		System.out.println("***************************************");
		// Sorting map of custom object using stream api comparator functioning methods and method reference
		employeeMap1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed())).forEach(System.out::println);

	}

}
