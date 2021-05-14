package com.modernjavainaction.chapter05;

import java.util.Arrays;
import java.util.List;

public class StreamMappingExercise {
	public static void main(String[] args) {
		List<Integer> squareNumbers = getSquares(Arrays.asList(1,2,3,4,5,6));
		System.out.println(squareNumbers);
	}

	/**
	 * Given a list of numbers, how would you return a list of the square of each
	 * number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16,
	 * 25].
	 */
	static List<Integer> getSquares(final List<Integer> numbers){
		return numbers.stream().map(n -> n * 2).toList();
	}
}
