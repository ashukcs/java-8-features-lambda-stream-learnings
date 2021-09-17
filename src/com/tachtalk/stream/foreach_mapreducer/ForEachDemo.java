package com.tachtalk.stream.foreach_mapreducer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ForEachDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("Ashu");
		list.add("Reena");
		list.add("Ranu");
		list.add("Maahi");
		list.add("Sam");
		
		for(String s:list) {
			System.out.println("Normal iteration - "+s);
		}
		
		list.forEach(s->System.out.println("Iteration using simple stream api - "+s));
		
		list.stream().forEach(s->System.out.println("Iteration with streaming api - "+s));
		
		//usage of predicate
		Predicate<String> predicate = (s)-> s.startsWith("R");
		list.stream().filter(s-> s.startsWith("R")).forEach(t->System.out.println("Interation with stream filter - "+t));
		
		list.spliterator().forEachRemaining(s->System.out.println("using spliterator - "+s));
		
		list.parallelStream().forEach(s->System.out.println("parallelstream---"+s));
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "java");
		map.put(2, "scala");
		map.put(3, "kotlin");
		map.put(4, "c#");
		map.put(5, "c++");
		map.put(6, "python");
		
		map.forEach((k,v)->System.out.println("Simple Iteration of map of technologies - key - " + k + " value - " + v));
		map.entrySet().stream().filter(k->k.getValue().startsWith("c")).forEach(obj->System.out.println("Iterating through pipeline methods - "+obj));
		map.entrySet().parallelStream().filter(k->k.getKey() > 2 && k.getKey() <= 5).forEachOrdered(t->System.out.println("Using parallel stream - "+t));
	}
}
