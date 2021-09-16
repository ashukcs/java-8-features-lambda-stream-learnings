package com.tachtalk.stream.bifunction_biconsumer_bipredicate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample implements BiConsumer<String, Integer>{

	@Override
	public void accept(String t, Integer u) {
		System.out.println("Traditional Approach - Key - " + t + " : Value - " + u);
	}
	
	public static void main(String[] args) {
		BiConsumerExample biConsumerTraditional = new BiConsumerExample();
		biConsumerTraditional.accept("Ashutosh", 3200);
		System.out.println("--------------------------------------------------------");
		BiConsumer<String, Integer> biConsumerAnnonymous = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println("Annonymous Impl Approach - Key - "+t+" : Value - "+u);
			}
		};
		
		biConsumerAnnonymous.accept("Consumer", 123);
		System.out.println("--------------------------------------------------------");
		BiConsumer<String, Integer> biConsumerLambda = (input1, input2) -> System.out.println("Lambda Approach - Key - "+input1+" : Value - "+input2);
		biConsumerLambda.accept("Hey Ashutosh", 143);
		System.out.println("--------------------------------------------------------");
		Map<String, Integer> map = new HashMap<>();
		map.put("Ashutosh", 12000);
		map.put("Saurabh", 60000);
		map.put("Rajesh", 70000);
		
		//iterating through traditional approach
		map.forEach(biConsumerTraditional);
		System.out.println("--------------------------------------------------------");
		//iterating through annonymous approach
		map.forEach(biConsumerAnnonymous);
		System.out.println("--------------------------------------------------------");
		//iterating through lambda approach
		map.forEach(biConsumerLambda);
		System.out.println("--------------------------------------------------------");
		//directly passing the lambda inside foreach
		map.forEach((k,v)->System.out.println("Key-"+k+" : Value-"+v));
	}
	
}
