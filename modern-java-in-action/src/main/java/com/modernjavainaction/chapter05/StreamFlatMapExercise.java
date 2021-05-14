package com.modernjavainaction.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExercise {
	public static void main(String[] args) {
		final List<String> words = Arrays.asList("Hello", "World");
		System.out.println(words);
		final List<String> uniqueLetters = getDistinctLetters(words);
		System.out.println(uniqueLetters);
		System.out.println("\n-------------------------------\n");
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		List<int[]> pairs = getPairs(list1, list2);
		pairs.stream().forEach(StreamFlatMapExercise::printArray);
		System.out.println("\n-------------------------------\n");
		
		getPairsWithSumDivisibleBy3(list1, list2).stream().forEach(StreamFlatMapExercise::printArray);
		System.out.println("\n-------------------------------\n");
	}

	/**
	 * Return a list of all the unique characters for a list of words. For example,
	 * given the list of words ["Hello," "World"] you’d like to return the list
	 * ["H," "e," "l," "o," "W," "r," "d"].
	 */
	private static List<String> getDistinctLetters(final List<String> words) {
		List<String> uniqueLetters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());

		return uniqueLetters;
	}

	/**
	 * Given two lists of numbers, how would you return all pairs of numbers? For
	 * example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
	 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a
	 * pair as an array with two elements.
	 */
	static List<int[]> getPairs(final List<Integer> list1, final List<Integer> list2){
		return list1.stream().flatMap(i -> list2.stream().map(j -> new int[] {i,j})).toList();
	}

	static List<int[]> getPairsWithSumDivisibleBy3(final List<Integer> list1, final List<Integer> list2){
		return list1.stream().flatMap(i -> list2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] {i,j})).toList();
	}

	static void printArray(int a[]) {
		System.out.print("[");
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.print("]");
	}
}
