package edu.umb.cs680.hw11;

import java.util.*;

public class Car {
    private final String make;
    private final String model;
    private final int mileage;
    private final int year;
    private final float price;

    public Car(String make, String model, int mileage, int year, float price){
        this.make= make;
        this.model = model;
        this.mileage =mileage;
        this.year = year;
        this.price =price;
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
    public float getPrice(){
        return price;
    }

//     To get the List of car values, price ,year and mileage.

   public List<Double> getCarValuesAsList(){
//        Downcast the variables of price, year, mileage .
        return Arrays.asList((double) this.price, (double) this.year, (double) this.mileage);
   }

//   Do Normalization
    public List<Double> Normalization(List<Double> values){
//       Get the min & max values using Collections
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(Double val : values){
            if(val < min){
                min = val;
            }
            if (val > max){
                max = val;
            }
        }

//        Adding normalized values in to a new ArrayList
        List<Double> normValues = new ArrayList<>();
        for (Double Xvalue : values){
            double normalization = (Xvalue - min) / (max - min) ;
            normValues.add(normalization);
        }
        return normValues;

    }



    public static void main(String[] args){

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Honda","civic",12,2003,10000);
        Car car2 = new Car("Honda","Accord",11,2020,12000);
        Car car3 = new Car("Chavalite","Tavera",23,2009,15000);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        for(Car car: cars){
            List<Double> carValues = car.getCarValuesAsList();
            System.out.println(carValues);
        }
        List<List<Double>> carValues = new ArrayList<>();
        carValues.add(car1.getCarValuesAsList());
        carValues.add(car2.getCarValuesAsList());
        carValues.add(car3.getCarValuesAsList());
        System.out.println(Distance.matrix(carValues, new Euclidean()));
        System.out.println(Distance.get(car1.getCarValuesAsList() ,car2.getCarValuesAsList(),new Manhattan()));
        System.out.println(Distance.get(car1.getCarValuesAsList(), car2.getCarValuesAsList(), new Cosine()));
        System.out.println(Distance.get(car1.getCarValuesAsList(), car2.getCarValuesAsList()));


        System.out.println(" ");

        for(Car car: cars){
            List<Double> normCarValues = car.Normalization(car.getCarValuesAsList());
            System.out.println(normCarValues);
        }
//        TO get values in matric , creating List<List<Double>> new ArrayList , that will have normalized values of price, year, mileage in a matrix form.

        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars){
            points.add(car.Normalization(car.getCarValuesAsList()));
        }
        System.out.println(Distance.matrix(points,new Euclidean()));

//        points.add(car1.Normalization(car1.getCarValuesAsList()));
//        points.add(car2.Normalization(car2.getCarValuesAsList()));
//        points.add(car3.Normalization(car3.getCarValuesAsList()));
//        System.out.println(Distance.matrix(points, new Cosine()));
//        System.out.println(Distance.matrix(points, new Manhattan()));
//        System.out.println(Distance.matrix(points, new Euclidean()));
//
//             System.out.println("manufractured by "+ c.getMake());
//        System.out.println("mdoel of the car is " + c.getModel());
//        System.out.println("the mileage of the car is "+ c.getMileage());
//        System.out.println("Manufractured in the year " + c.getYear());
//        System.out.println("The price of the car is " + c.getPrice());

    }


}
