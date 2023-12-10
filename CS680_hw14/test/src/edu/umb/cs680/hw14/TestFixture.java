package edu.umb.cs680.hw14;
import java.util.ArrayList;
public class TestFixture {

    public static ArrayList<Car> getUsedCars(){

        ArrayList<Car> usedCars = new ArrayList<>();
        Car usedCar1 = new Car("Tayota","Innova",50000,2016,12000);
        Car usedCar2 = new Car("Honda","Accord",45000,2017,11500);
        Car usedCar3 = new Car("Ford","Fusion",60000,2015,10800);
        Car usedCar4 = new Car("Chavalite","Tavera",55000,2016,10500);
        Car usedCar5 = new Car("Nissan", "Altima",52000,2014,9800);
        Car usedCar6 = new Car("Hundai","Sonataa",48000,2015,9500);
        Car usedCar7 = new Car("Subaru","Legacy",65000,2013,8900);
        Car usedCar8 = new Car("Kia","Optima",58000,2014,8500);
        Car usedCar9 = new Car("Mazda","6",70000,2012,8200);
        Car usedCar10 = new Car("Volkswagen","Passat",75000,2011,7900);
        Car usedCar11 = new Car("Tesla","model-y",45000,2017,11500);
        Car usedCar12 = new Car("Tesla","model-x",78000,2014,18000);


        usedCars.add(usedCar1);
        usedCars.add(usedCar2);
        usedCars.add(usedCar3);
        usedCars.add(usedCar4);
        usedCars.add(usedCar5);
        usedCars.add(usedCar6);
        usedCars.add(usedCar7);
        usedCars.add(usedCar8);
        usedCars.add(usedCar9);
        usedCars.add(usedCar10);
        usedCars.add(usedCar11);
        usedCars.add(usedCar12);

        return usedCars;
    }



}
