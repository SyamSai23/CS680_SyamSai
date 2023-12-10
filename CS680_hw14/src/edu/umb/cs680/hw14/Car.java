package edu.umb.cs680.hw14;

import java.util.ArrayList;

public class Car {

    private final String make;
    private final String model;
    private final int mileage;
    private final int year;
    private final int  price;
    private int dominationCount;

    public Car(String make, String model, int mileage, int year, int price){
        this.make= make;
        this.model = model;
        this.mileage =mileage;
        this.year = year;
        this.price =price;

    }
    //    create Getter Methods for all the variables
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getMileage(){
        return mileage;
    }
    public int getYear(){
        return year;
    }
    public int  getPrice(){
        return price;
    }

    public void setDominationCount(ArrayList<Car> usedCars){
//        Initializing domination count for current car as 0 and Increment the count if the current car dominates car.
        this.dominationCount = 0;
        for(Car car : usedCars){
            if(!car.equals(this)){
//                Checking the two conditions I.e either all values are superior or at least one value is superior .
                if(car.getPrice() <= this.getPrice() && car.getMileage() <= this.getMileage() && car.getYear() >= this.getYear()) {
                    if(car.getPrice() < this.getPrice() || car.getMileage() < this.getMileage() || car.getYear() > this.getYear()) {
                        this.dominationCount++;
                    }
                }
            }

        }

    }

    public int getDominationCount(){
        return dominationCount;
    }


}
