package com.tachtalk.stream.bifunction_biconsumer_bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateExample implements BiPredicate<String, String>{

	@Override
	public boolean test(String s1, String s2) {
		return s1.equals(s2);
	}
	
	public static void main(String[] args) {
		BiPredicateExample biPredicateTraditional = new BiPredicateExample();
		System.out.println(biPredicateTraditional.test("Ashutosh", "toshAshu"));
		
		BiPredicate<String, String> biPredicateAnnonymous = new BiPredicate<String, String>() {

			@Override
			public boolean test(String s1, String s2) {
				return s1.equals(s2);
			}
		};
		
		System.out.println("Annonymous approach : are both objects equal? - " + biPredicateAnnonymous.test("madam", "madam"));
		
		BiPredicate<String, String> biPredicateLambda = (s1,s2) -> s1.equals(s2);
		System.out.println("Lambda approach : are both objects equals? - " + biPredicateLambda.test("Sam", "Mas"));
	}

}
