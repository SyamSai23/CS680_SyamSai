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
    public static List<List<Double>> Normalization(List<List<Double>> values){
//       Get the min & max values using Collections
        List<Double> prices = new ArrayList<>();
        List<Double> Mileages = new ArrayList<>();
        List<Double> Years = new ArrayList<>();
        for(List<Double> val : values){
          prices.add(val.get(0));
          Mileages.add(val.get(1));
          Years.add(val.get(2));
        }
//        Sort the list min and max using collections.
        Collections.sort(prices);
        Collections.sort(Mileages);
        Collections.sort(Years);
//        Getting min and max values using index
        double piceMin = prices.get(0);
        double priceMax = prices.get(prices.size() -1);
        double mileageMin = Mileages.get(0);
        double mIleageMax = Mileages.get(Mileages.size() -1);
        double YearMin = Years.get(0);
        double YearMax = Years.get(Years.size() -1);

//        Adding normalized values in to a new ArrayList
        List<List<Double>> normValues = new ArrayList<>();
        for (List<Double> val : values){
            double price = val.get(0);
            double Mileage = val.get(1);
            double Year = val.get(2);

            double PNorm = (price - piceMin) / (priceMax - piceMin);
            double MNorm = (Mileage - mileageMin) / (mIleageMax - mileageMin);
            double YNorm = (Year - YearMin) / (YearMax - YearMin);
            List<Double> normalizedCarValues = Arrays.asList(PNorm, MNorm, YNorm);
            normValues.add(normalizedCarValues);
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
        List<List<Double>> carValues = new ArrayList<>();
        for(Car car: cars){
           carValues.add(car.getCarValuesAsList());
        }
        System.out.println(carValues);

        System.out.println(Distance.get(car1.getCarValuesAsList(), car2.getCarValuesAsList(), new Euclidean()));
        System.out.println(Distance.get(car1.getCarValuesAsList(), car2.getCarValuesAsList(), new Manhattan()));
        System.out.println(Distance.get(car1.getCarValuesAsList(), car2.getCarValuesAsList(), new Cosine()));
//        Distance matrix with normalized values

        List<List<Double>> normValues = Car.Normalization(carValues);
        System.out.println(Distance.matrix(normValues, new Euclidean()));
    }
}
