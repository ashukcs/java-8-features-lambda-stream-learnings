package com.tachtalk.stream.parallelstream;

import java.util.List;
import java.util.stream.IntStream;

import com.tachtalk.stream.map_reduce.Employee;

public class ParallelStreamExample {
	public static void main(String[] args) {
		long start = 0;
		long end = 0;
		
		start = System.currentTimeMillis();
		IntStream.range(1,100).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Plain stream took time to complete - " + (end - start));
		
		System.out.println("-------------------------------------------------------");
		
		start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel stream took time to complete - " + (end - start));
		
		
		IntStream.range(1, 10).forEach(x->{
			System.out.println("Thread : " + Thread.currentThread().getName() + " : "+x);
		});
		
		IntStream.range(1, 10).parallel().forEach(x->{
			System.out.println("Thread : " + Thread.currentThread().getName() + " : "+x);
		});
		
		List<Employee> employees = EmployeeDB.getEmployees();
		System.out.println("-------------------------------------------------");
		start = System.currentTimeMillis();
		double averageSalaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Plain stream took time to complete - " + (end - start));
		System.out.println(averageSalaryWithStream);
		System.out.println("-------------------------------------------------");
		start = System.currentTimeMillis();
		double averageSalaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Parallel stream took time to complete - " + (end - start));
		System.out.println(averageSalaryWithParallelStream);
	}
}
