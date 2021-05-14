package com.modernjavainaction;

import java.awt.Color;

public class Apple {
	private int weight;
	private Color color;
	
	public Apple(int weight) {
		this.weight = weight;
	}
	
	public Apple(int weight, Color color) {
		this.weight = weight;
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Color getColor() {
		return color;
	}
}

