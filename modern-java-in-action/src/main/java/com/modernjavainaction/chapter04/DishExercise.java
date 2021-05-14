package com.modernjavainaction.chapter04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DishExercise {
	public static void main(String[] args) {
		List<Dish> menu = DishFactory.getMenu();
		System.out.println(get3HighCalorieDishNames(menu, 300));
	}
	
	static List<Dish> get3HighCalorieDishNames(final List<Dish> menu, int maxCalorie){
		List<Dish> highCalorieDishNames = null;
		highCalorieDishNames = 
				menu.stream()
				.sorted(Comparator.comparing(Dish::getCalories).reversed())
				.filter(d -> d.getCalories() > maxCalorie)
				.limit(3)
				.toList();
		return highCalorieDishNames;
	}
	
	
}
