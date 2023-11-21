package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestFixtures {
    public static ArrayList<Car> getCars(){
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car("tayota","Inova",56,2022,23000);
        Car car2 = new Car("Honda","civic",34,2019,24000);
        Car car3 = new Car("Chaverlite","Tavera",45,2006,10000);
        Car car4 = new Car("Hundai","Creata",90,2022,35000);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        return cars;

    }

}
