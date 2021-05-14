package com.modernjavainaction.chapter03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		List<String> listStrings = Arrays.asList("Red", "Green", "", "Blue");
		List<String> nonEmptyList = filter(listStrings, s -> !s.isEmpty());
		System.out.println(nonEmptyList);
	}
	
	private static <T> List<T> filter(final List<T> list, final Predicate<T> p){
		return list.stream().filter(p).toList();
		
	}
}
