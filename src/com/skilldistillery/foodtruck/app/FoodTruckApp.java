package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] listOfFoodTrucks = new FoodTruck[5];
	private Scanner userInput = new Scanner(System.in);
	private String dataToInput;
	private boolean isRunning = true;
	private int integerChoice;
	private int truckCounter;
	private int highestRated;

	public static void main(String[] args) {
		FoodTruckApp myApp = new FoodTruckApp();
		myApp.run();
	}

	private void run() {
		inputFoodTruckData();
		foodTruckMenu();
	}

	private void addToArray(FoodTruck newFoodTruck) {
		for (int index = 0; index < listOfFoodTrucks.length; index++) {
			if (listOfFoodTrucks[index] == null) {
				listOfFoodTrucks[index] = newFoodTruck;
				break;
			} else if (listOfFoodTrucks[index] != null) {
				;
			}
		}
	}

	private boolean checkIfArrayFull() {
		// If last position is empty, return false
		if (listOfFoodTrucks[listOfFoodTrucks.length - 1] == null) {
			System.out.println("Still room to add another food truck!");
			return false;
		} else {
			System.out.println("No more space to add food trucks! Moving on...");
			return true;
		}
	}

	private void inputFoodTruckData() {
		while (isRunning) {
			System.out.print("Enter new food truck name or \"quit\" to move on: ");
			dataToInput = userInput.nextLine();
			if ((dataToInput.equals("quit") || dataToInput.equals("QUIT")) && listOfFoodTrucks[0] == null) {
				System.out.println("Please enter at least one food truck.");
				System.out.println();
				continue;
			} else if (dataToInput.equals("quit") || dataToInput.equals("QUIT")) {
				isRunning = false;
				continue;
			} else {
				FoodTruck foodTruck = new FoodTruck();
				foodTruck.setName(dataToInput);
				System.out.print("What type of food does " + foodTruck.getName() + " sell? ");
				foodTruck.setFoodType(userInput.nextLine());
				System.out.print("Rate " + foodTruck.getName() + " on a scale of 1-5: ");
				foodTruck.setRating(userInput.nextInt());
				userInput.nextLine();
				addToArray(foodTruck);
				System.out.println();
				if (checkIfArrayFull() == true) {
					isRunning = false;
				}
			}
		}
	}

	private void foodTruckMenu() {
		isRunning = true;
		while (isRunning) {
			System.out.println();
			System.out.println("[1] List all existing food trucks");
			System.out.println("[2] See average rating of all food trucks");
			System.out.println("[3] Display the highest-rated food truck");
			System.out.println("[4] Quit the program");
			System.out.println("Enter choice: ");
			integerChoice = userInput.nextInt();
			switch (integerChoice) {
			case 1:
				listFoodTrucks();
				break;
			case 2:
				System.out.printf("%.1f", displayAverageRating());
				System.out.print(" is the average rating of all " + truckCounter + " food trucks.");
				System.out.println();
				break;
			case 3:
				displayHighestRated();
				break;
			case 4:
				System.out.println("Quitting program.");
				System.exit(0);
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
	}

	private void listFoodTrucks() {
		for (int index = 0; index < listOfFoodTrucks.length; index++) {
			if (listOfFoodTrucks[0] == null) {
				// Shouldn't ever reach this
				System.out.println("No food trucks to list!");
				break;
			} else if (listOfFoodTrucks[index] != null) {
				System.out.println(listOfFoodTrucks[index]);
			}
		}
	}

	private double displayAverageRating() {
		int sumOfRatings = 0;
		truckCounter = 0;

		for (int index = 0; index < listOfFoodTrucks.length; index++) {
			if (listOfFoodTrucks[index] != null) {
				truckCounter++;
				sumOfRatings += listOfFoodTrucks[index].getRating();
			} else if (listOfFoodTrucks[index] == null) {
				;
			}
		}

		return sumOfRatings / (double) truckCounter;
	}

	private void displayHighestRated() {
		int numOfHighestRated = 0;
		
		// Get highest rating
		for (int index = 0; index < listOfFoodTrucks.length; index++) {
			if (listOfFoodTrucks[index] != null) {
				if (listOfFoodTrucks[index].getRating() > highestRated) {
					highestRated = listOfFoodTrucks[index].getRating();
				}
			}
		}
		
		// Get count of occurrences of highest rating
		for (int index = 0; index < listOfFoodTrucks.length; index++) {
			if (listOfFoodTrucks[index] != null) {
				if (listOfFoodTrucks[index].getRating() == highestRated) {
					numOfHighestRated++;
				}
			}
		}

		if (numOfHighestRated == 1) {
			System.out.println("Highest rated food truck is: ");
			for (int index = 0; index < listOfFoodTrucks.length; index++) {
				if (listOfFoodTrucks[index] != null) {
					if (listOfFoodTrucks[index].getRating() == highestRated) {
						System.out.println(listOfFoodTrucks[index]);
					}
				}
			}
		} else if (numOfHighestRated > 1) {
			System.out.println("We have a " + numOfHighestRated + "-way tie between: ");
			for (int index = 0; index < listOfFoodTrucks.length; index++) {
				if (listOfFoodTrucks[index] != null) {
					if (listOfFoodTrucks[index].getRating() == highestRated) {
						System.out.println(listOfFoodTrucks[index]);
					}
				}
			}
		}
	}

}
