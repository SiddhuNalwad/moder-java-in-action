package com.modernjavainaction.chapter04;

import java.util.Formatter;

public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		String dish = formatter.format("Name:%s, Calorie:%d", name, calories).toString();
		System.out.println(dish);
		formatter.close();
		return dish;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}
}