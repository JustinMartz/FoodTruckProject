# FoodTruckProject
![](./food-truck.png)

Week 2 homework by Justin Martz

## Description

Users enter data for up to five food trucks. They then enter a menu that lets them: list all existing food trucks, see the average rating of all food trucks, display the highest-rated food truck(s), or quit the program.

![](./food-truck-recording.webm)



## Technologies Used

Java

Eclipse

## Lessons Learned

Throughout this project I thought that methods should have their own local variables, but couldn't reconcile the compiler after trying to add access modifiers like public and private and whatnot. So I made all variables global. After being mostly done with this project, I received clarification in a TA session that methods <strong>CANNOT</strong> have access modifiers. I left most of the variables as globals as it doesn't change the functionality, but now I am 100% onboard with the difference between local variables not having/needing access modifiers and global variables/fields having them. Thank you to Eric, John, and Will for clearing that up.

I ran into a bug where my array of food trucks was being filled with the first food truck I entered. My loop wasn't breaking after I plopped a food truck in the array's spot. All it need was a little break; statement!

```java
for (int index = 0; index < listOfFoodTrucks.length; index++) {
			if (listOfFoodTrucks[index] == null) {
				listOfFoodTrucks[index] = newFoodTruck;
				break;
			} else if (listOfFoodTrucks[index] != null) {
				;
			}
		}
```
		
In one version of this program I ran into

```java
Exception in thread "main" java.lang.NullPointerException
```

because I was trying to reference the fifth element of the array <code>(listOfFoodTrucks[4])</code> by

```java
if (listOfFoodTrucks[index] != null) {
```

with the ID of the fifth food truck (id=5). It worked after I referenced by using id - 1, but altogether used a different way to do this.