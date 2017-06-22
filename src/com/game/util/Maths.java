package com.game.util;

import java.util.Random;

public class Maths {

	private static Random rand = new Random();

	public static double randDouble(double min, double max) {
		return min + (max - min) * rand.nextDouble();
	}

	public static int randInt(int min, int max) {
		return rand.nextInt(max - min) + min;
	}
}
