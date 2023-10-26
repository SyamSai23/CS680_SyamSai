package edu.umb.cs680.hw3;

public class Car {
    private String make,model;
    private int mileage,year;
    private float price;

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

    public static void main(String[] args){
        Car c = new Car("Honda","civic",12,2003,10000);
        System.out.println("manufractured by "+ c.getMake());
        System.out.println("mdoel of the car is " + c.getModel());
        System.out.println("the mileage of the car is "+ c.getMileage());
        System.out.println("Manufractured in the year " + c.getYear());
        System.out.println("The price of the car is " + c.getPrice());
    }


}
