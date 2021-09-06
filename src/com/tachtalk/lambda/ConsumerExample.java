package com.tachtalk.lambda;

import java.util.Arrays;
import java.util.List;

public class ConsumerExample {// Ex type-1 implements Consumer<Integer>{

	public static void main(String[] args) {
		// Ex type-1 new ConsumerWithLambdaExample().accept(10);
		// Ex type-2 new ConsumerWithLambdaExample().consumer.accept(10);
		
		/* Ex type-3
		 * Consumer<Integer> consumer = (t) -> System.out.println("Printing - " + t);
		 * consumer.accept(20);
		 */
		
		//Ex type-4
		List<Integer> intList = Arrays.asList(1, 3, 5, 6, 9);
		intList.forEach((t) -> {
			System.out.println("Printing - " +t);
		});
	}

	/* Ex type-1
	 * @Override public void accept(Integer t) { System.out.println("Printing : " +t
	 * ); }
	 */

	/* Ex type -2
	 * Consumer<Integer> consumer = (t) -> { System.out.println("Printing - " + t);
	 * };
	 */
	
}
