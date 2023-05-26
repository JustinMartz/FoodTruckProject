package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckId;	// current number of trucks
	private int id;
	
	public FoodTruck() {
		nextTruckId++;
	}
}
