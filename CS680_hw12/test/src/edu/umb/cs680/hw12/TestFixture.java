package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class TestFixture {
    public static ArrayList<Car> getUsedCars(){
        ArrayList<Car> usedCars = new ArrayList<>();
        Car usedCar1 = new Car("Tayota","Innova",23,2010,12000);
        Car usedCar2 = new Car("Honda","Accord",12,2020,10000);
        Car usedCar3 = new Car("Hundai","Creta",18,2019,20000);
        Car usedCar4 = new Car("Chavalite","Tavera",23,2009,15000);

        usedCars.add(usedCar1);
        usedCars.add(usedCar2);
        usedCars.add(usedCar3);
        usedCars.add(usedCar4);

        return usedCars;
    }

}
