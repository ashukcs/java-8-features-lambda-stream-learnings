package com.tachtalk.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {// Ex type-1 implements Supplier<String>{

	/* Ex type-1
	 * @Override public String get() { return "Hi Tech Talk!!!"; }
	 */
	
	//Ex type-2	Supplier<String> supplier = () -> {return "Hi Tech Talk!";};
	
	public static void main(String[] args) {
		//Ex type-1	System.out.println(new SupplierExample().get());
		
		//Ex type-2	System.out.println(new SupplierExample().supplier.get());
		/*
		 * Supplier<String> supplier = () -> { return "Something!"; };
		 */
		
		//Ex type-2	System.out.println(supplier.get());
		
		Supplier<String> supplier = ()->{return "Supplier called!";};
		
		List<String> strList = Arrays.asList("Ashutosh", "Saurabh");
		System.out.println(strList.stream().findAny().orElseGet(supplier));
	}
	
}
