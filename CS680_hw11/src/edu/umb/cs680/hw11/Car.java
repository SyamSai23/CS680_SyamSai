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
        List<Double> mileages = new ArrayList<>();
        List<Double> years = new ArrayList<>();
        for(List<Double> val : values){
          prices.add(val.get(0));
          mileages.add(val.get(1));
          years.add(val.get(2));
        }
//        Sort the list min and max using collections.
        Collections.sort(prices);
        Collections.sort(mileages);
        Collections.sort(years);
//        Getting min and max values using index
        double priceMin = prices.get(0);
        double priceMax = prices.get(prices.size() -1);
        double mileageMin = mileages.get(0);
        double mileageMax = mileages.get(mileages.size() -1);
        double yearMin = years.get(0);
        double yearMax = years.get(years.size() -1);

//        Adding normalized values in to a new ArrayList
        List<List<Double>> normValues = new ArrayList<>();
        for (List<Double> val : values){
            double price = val.get(0);
            double mileage = val.get(1);
            double year = val.get(2);

            double PNorm = (price - priceMin) / (priceMax - priceMin);
            double MNorm = (mileage - mileageMin) / (mileageMax - mileageMin);
            double YNorm = (year - yearMin) / (yearMax - yearMin);
            List<Double> normalizedCarValues = Arrays.asList(PNorm, MNorm, YNorm);
            normValues.add(normalizedCarValues);
        }
        return normValues;

    }




}
