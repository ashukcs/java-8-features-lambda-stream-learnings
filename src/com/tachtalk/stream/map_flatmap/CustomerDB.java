package com.tachtalk.stream.map_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDB {
	public static List<Customer> getAll() {
		return Stream.of(
			new Customer("101", "Nikhil", "nikhi@gmail.com", Arrays.asList("3432423423", "7565433231")),
			new Customer("104", "Ashutosh", "ashutosh@gmail.com", Arrays.asList("5443325356","9823124354")),
			new Customer("103", "Saurabh", "saurabhshcs@gmail.com", Arrays.asList("4523457632","7832456732")),
			new Customer("102","Birendra","Birendra@gmail.com",Arrays.asList("4354656763","6732893290"))
		).collect(Collectors.toList());
	}
}
