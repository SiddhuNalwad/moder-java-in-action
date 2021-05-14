package com.modernjavainaction.chapter05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriplesExercise {
	public static void main(String[] args) {
		Stream<int[]> pythagoreanTriples = 
				IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
				.filter(b -> Math.sqrt(a*a + b*b) %1 == 0).mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)}));
		
		//print all pythagorean triples
		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + "\t" + t[1] + "\t" + t[2]));
		
		System.out.println("\n---------------------------------------------\n");
		//To optimize the solution, can we avoid calling Math.sqrt twice ?
		Stream<double[]> pythagoreanTriples2 = 
		IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
				.mapToObj(b -> new double[] {a*a, b*b, Math.sqrt(a*a + b*b)})
				.filter(t -> t[2] % 1 ==0));
		pythagoreanTriples2.limit(5).forEach(t -> System.out.println(t[0] + "\t" + t[1] + "\t" + t[2]));
		}
}
