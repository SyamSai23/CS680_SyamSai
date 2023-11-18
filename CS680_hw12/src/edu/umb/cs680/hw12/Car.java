package edu.umb.cs680.hw12;

import java.util.ArrayList;
import java.util.Collections;

public class Car {
    private final String make;
    private final String model;
    private final int mileage;
    private final int year;
    private final int  price;
    private int  DominationCount;

    public Car(String make, String model, int mileage, int year, int price){
        this.make= make;
        this.model = model;
        this.mileage =mileage;
        this.year = year;
        this.price =price;
//        this.DominationCount = DominationCount;
    }
//    create Getter Methods.
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
    public int getDominationCount(){
        return DominationCount;
    }

    ArrayList<Car> usedCars = new ArrayList<>();
    public void setDominationCount(ArrayList<Car> usedCars){
        for(Car DC : usedCars){
//            comparing models, If the models are different then compare the price , Year & mileage.
            if(!DC.getModel().equals(this.model)){
                if(DC.getPrice() <= this.getPrice() && DC.getYear() >= this.getYear() && DC.getMileage() <= this.getMileage()){
                    this.DominationCount++;
                }
            }
        }

    }

    public static void main(String[] args){
        ArrayList<Car> usedCars = new ArrayList<Car>();
        usedCars.add(new Car("Tayota","Innova",23,2010,12000));
        usedCars.add(new Car("Honda","Accord",12,2020,10000));
        usedCars.add(new Car("Hundai","Creta",18,2019,20000));
        usedCars.add(new Car("Chavalite","Tavera",23,2009,15000));
        for(Car DC: usedCars){
            DC.setDominationCount(usedCars);
            System.out.println(DC.getMake() + " : Domination Count : " + DC.getDominationCount());
        }
        usedCars.sort(new ParetoComparator<Car>());


//        usedCars.sort(new PriceComparator());
//        for (Car p : usedCars){
//            System.out.println(p.model);
//        }
//
//        System.out.println(" ");
//
//        usedCars.sort(new YearComparator());
//        for(Car Y : usedCars){
//            System.out.println(Y.model);
//        }
//
//        System.out.println(" ");
//
//        usedCars.sort(new MileageComparator());
//        for(Car M : usedCars){
//            System.out.println(M.model);
//        }
//

    }


}
