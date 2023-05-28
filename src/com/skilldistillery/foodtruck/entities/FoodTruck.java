package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckId;	// current number of trucks
	private int id;
	private String name;
	private String foodType;
	private int rating;
	
	public FoodTruck() {
		nextTruckId++;
		id = nextTruckId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "FoodTruck [id=" + id + ", name=" + name + ", foodType=" + foodType + ", rating=" + rating + "]";
	}
	
}
