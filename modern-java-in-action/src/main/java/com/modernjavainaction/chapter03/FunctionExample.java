package com.modernjavainaction.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		
		//for understanding purpose
		final List<String> listStrings = Arrays.asList("This", "is", "a", "test");
		Function<String, Integer> strToLenFunc = s -> s.length();
		List<Integer> listResult1 = map(listStrings, strToLenFunc);
		System.out.println(listResult1);
		listResult1 = map(listStrings,String::length); // Using method reference
		System.out.println(listResult1);
		
		List<String> listResult2 = map(listStrings, String::toUpperCase);
		System.out.println(listResult2);
		
		//best solution
		listStrings.stream().map(String::length).forEach(System.out::println);
		listStrings.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	
	private static <T,R> List<R> map(List<T> list, Function<T,R> function) {
		List<R> listOfR = new ArrayList<>();
		for (T t : list) {
			R r = function.apply(t);
			listOfR.add(r);
		}
		return listOfR;
		
	}
}	
