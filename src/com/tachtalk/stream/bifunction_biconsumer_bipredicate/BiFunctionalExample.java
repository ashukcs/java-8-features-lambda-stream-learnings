package com.tachtalk.stream.bifunction_biconsumer_bipredicate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionalExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
		return Stream.of(list1, list2).flatMap(List::stream).distinct().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction = new BiFunctionalExample();
		List<Integer> list1 = Stream.of(1, 24, 37, 4, 5, 6, 7, 8, 3).collect(Collectors.toList());
		List<Integer> list2 = Stream.of(13, 6, 81, 74, 5, 16, 7, 8, 13).collect(Collectors.toList());

		System.out.println("Traditional Approach : " + biFunction.apply(list1, list2));
		

		BiFunction<List<Integer>, List<Integer>, List<Integer>> bifunctional = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
		
			@Override
			public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
				return Stream.of(list1, list2)
						.flatMap(List::stream)
						.distinct()
						.collect(Collectors.toList());
			}
		
		};

		System.out.println("Annonymous Impl Approach : " + bifunctional.apply(list1, list2));


		BiFunction<List<Integer>, List<Integer>, List<Integer>> lambdaBiFunction = (l1, l2) -> {
			return Stream.of(list1, list2)
					.flatMap(List::stream)
					.distinct()
					.collect(Collectors.toList());
		};
		
		System.out.println("Lambda Approach : " + lambdaBiFunction.apply(list1, list2));

		
		Map<String, Integer> map = new HashMap<>();
		map.put("Ashutosh", 12000);
		map.put("Saurabh", 60000);
		map.put("Rajesh", 70000);
		
		BiFunction<String, Integer, Integer> increaseSalBiFunction = new BiFunction<String, Integer, Integer>() {

			@Override
			public Integer apply(String key, Integer value) {
				return value+5000;
			}
		};
		
		map.replaceAll(increaseSalBiFunction);
		System.out.println("Annonymous Approach with real time operation : " + map);
		
		map.replaceAll((key, value) -> value + 12000);
		System.out.println("Lambda approach for real time operation : " + map);
		
		//Sorting approach
		
		Function<List<Integer>, List<Integer>> sortedFunction = new Function<List<Integer>, List<Integer>>() {

			@Override
			public List<Integer> apply(List<Integer> list1) {
				return list1.stream().sorted().collect(Collectors.toList());
			}
		};
		
		
		System.out.println("Annonymous Implementation approach for Sorting : " + sortedFunction.apply(bifunctional.apply(list1, list2)));

		Function<List<Integer>, List<Integer>> sortedFunctionLambda = list -> list.stream().sorted().collect(Collectors.toList());
			
		System.out.println("Lambda Approach for Sorting : " + bifunctional.andThen(sortedFunctionLambda).apply(list1, list2));
	}
	
}
