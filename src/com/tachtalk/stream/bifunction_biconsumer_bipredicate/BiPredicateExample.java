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
		
		BiPredicate<String, String> equalsPredicate = (s1,s2) -> s1.equals(s2);
		BiPredicate<String, String> lengthPredicate = (s1,s2) -> s1.length()==s2.length();
		
		System.out.println("Lambda approach : " + equalsPredicate.and(lengthPredicate).test("madam", "madam"));
		
		System.out.println("Lambda approach : " + equalsPredicate.or(lengthPredicate).test("abef", "ghij"));

		System.out.println("Lambda approach : " + lengthPredicate.and(equalsPredicate).test("abef", "ghij"));

		System.out.println("Lambda approach : " + lengthPredicate.or(equalsPredicate).test("abef", "ghij"));

		
	}

}
