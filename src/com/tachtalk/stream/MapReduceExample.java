package com.tachtalk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
	public static void main(String[] args) {
		List<Integer> nos = Arrays.asList(1, 4, 5, 7, 2, 9, 7, 8, 4, 6);

		List<String> strList = Arrays.asList("Martin Fowler", "Sam Newman", "Kathy Sierra");

		// traditional approach
		int sum = 0;
		for (Integer no : nos) {
			sum = sum + no;
		}

		System.out.println(sum);
		System.out.println("**********************");
		// demonstrate using stream api
		int sum1 = nos.stream().mapToInt(i -> i).sum();
		System.out.println(sum1);
		System.out.println("**********************");
		// using method reference
		int sum2 = nos.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum2);

		System.out.println("**********************");
		// using method reduce
		int sum3 = nos.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum3);

		System.out.println("**********************");
		// using method reduce and method reference
		int reduceSum = nos.stream().reduce(0, Integer::sum);
		System.out.println(reduceSum);

		Optional<Integer> reduceSum1 = nos.stream().reduce(Integer::sum);
		System.out.println(reduceSum1);

		System.out.println("**********************");
		// multiplication with lambda and stream

		Optional<Integer> max = nos.stream().reduce(Integer::max);
		System.out.println(max.get());

		System.out.println("**********************");
		Optional<Integer> multiResult = nos.stream().reduce((a, b) -> a * b);
		System.out.println(multiResult.get());

		System.out.println("**********************");
		Optional<String> str = strList.stream().reduce(String::concat);
		System.out.println(str.get());

		System.out.println("**********************");
		String longestStr = strList.stream().reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2).get();
		System.out.println(longestStr);

	}
}
