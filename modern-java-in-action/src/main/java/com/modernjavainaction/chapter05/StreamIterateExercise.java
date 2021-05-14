package com.modernjavainaction.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 . . .
//Fibonacci tuples:(0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)...

//public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f);


public class StreamIterateExercise {
	public static void main(String[] args) {
		//get multiplication table of 9
		getMultiplicationTable(9).stream().forEach(System.out::println);
		
		System.out.println("\n--------------------------------------------------\n");
		
		//get Fibonacci servies using solution 1
		getFibonacciSeries_Solution1(10).stream().forEach(System.out::println);
		
		System.out.println("\n--------------------------------------------------\n");
		
		//get Fibonacci servies using solution 2
		getFibonacciSeries_Solution1(10).stream().forEach(System.out::println);
		
		System.out.println("\n--------------------------------------------------\n");
		
		//get Fibonacci tuples
		getFibonacciTuples_Solution2(10).stream().forEach(array -> System.out.println( "(" + array[0] + ", " + array[1] + ")"));
	}
	
	static List<Integer> getMultiplicationTable(int nTable) {
		return Stream.iterate(nTable, n -> n + nTable).limit(10).toList();
	}
	
	//generate Fibonacci series for given N numbers
	static List<Integer> getFibonacciSeries_Solution1(final long howMany) {
		return Stream.iterate(Arrays.asList(0,1), list -> Arrays.asList(list.get(1), list.get(0) + list.get(1)))
			.limit(howMany)
			.map(list -> list.get(0))
			.toList();
	}
	
	static List<Integer> getFibonacciSeries_Solution2(final long howMany) {
		return Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1]})
				.limit(howMany)
				.map(t -> t[0])
				.toList();
	}
	
	static List<int[]> getFibonacciTuples_Solution2(final long howMany){
		return Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1]})
				.limit(howMany)
				.toList();
	}
}
