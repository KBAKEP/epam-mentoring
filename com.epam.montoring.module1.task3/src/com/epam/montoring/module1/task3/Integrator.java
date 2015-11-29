package com.epam.montoring.module1.task3;
public class Integrator {

	public static final double CONUTER = 0.01D;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double z = 0;
		double x = 0;
		double y = 0;
		double maxY = 1D;
		double squareZY = 0;
		double volumeXYZ = 0;
		
		for (; y <= maxY; y = y + CONUTER) {
			z = functionZofY(y);
			x = functionXofY(y);
			squareZY = CONUTER * z;
			volumeXYZ += squareZY * x;
		}
		
		System.out.printf("Volume is %.5f", volumeXYZ);
	}
	
	static double functionXofY(double y) {
		double x = 1 - y;
		return x;
	}
	
	static double functionZofY(double y) {
		double z = Math.pow(y, 2);
		return z;
	}

}
