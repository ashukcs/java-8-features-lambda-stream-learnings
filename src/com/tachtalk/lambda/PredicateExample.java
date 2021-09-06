package com.tachtalk.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {//Ex type-1 implements Predicate<Integer>{
	public static void main(String[] args) {
		//Ex type-1	System.out.println(new PredicateExample().test(10));
		//Ex type-2 System.out.println(new PredicateExample().predicate.test(10));
		
		/* Ex type-3
		 * Predicate<Integer> predicate = (t)-> t % 2 == 0;
		 * System.out.println(predicate.test(10));
		 */
		
		// Ex type-4
		Predicate<Integer> predicate = t -> t % 2 == 0;
		
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		intList.stream().filter(predicate).forEach(t -> {System.out.println(t);});
	}

	/* Ex type-1
	 * @Override public boolean test(Integer t) { if(t < 5) return false; else
	 * return true; }
	 */
	
	/* Ex type-2
	 * Predicate<Integer> predicate = (t) -> { if(t%2==0) return true; else return
	 * false; };
	 */
}
