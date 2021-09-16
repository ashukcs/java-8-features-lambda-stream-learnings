package com.tachtalk.stream.map_flatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapExample {
	public static void main(String[] args) {
		
		//fetching customer data
		List<Customer> customers = CustomerDB.getAll();
		
		//List<Customer> covert to List<String> >> Data Transformation
		//mapping : customer -> customer.getEmail() -> one to one mapping
		List<String> emails = customers.stream().map(customer->customer.getEmail()).collect(Collectors.toList());
		System.out.println("Customer Emails - "+emails);
		
		//List<List<String>> convert to List<String> >> Data transformation and flattering
		List<String> phones = customers.stream().flatMap(customer->customer.getPhones().stream()).collect(Collectors.toList());
		System.out.println(phones);
	}
}
