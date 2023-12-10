package edu.umb.cs680.hw14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void TestCarMileageWithLEInAscendingOrder(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        Collections.sort(usedcars, Comparator.comparing((Car car) -> car.getMileage()));
        assertEquals("Accord", usedcars.get(0).getModel());
        assertEquals("Sonataa", usedcars.get(2).getModel());
    }

    @Test
    public void TestCarMileageWithLECompareMethod(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        Collections.sort(usedcars, (o1, o2) -> o1.getMileage() - o2.getMileage());
        assertEquals("Accord",usedcars.get(0).getModel());
        assertEquals("Sonataa", usedcars.get(2).getModel());
    }

    @Test
    public void TestCarMileageWIthLEInDescendingOrder(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        Collections.sort(usedcars, Comparator.comparing((Car car) -> car.getMileage(), Comparator.reverseOrder()));
        assertEquals("model-x", usedcars.get(0).getModel());
        assertEquals("Passat", usedcars.get(1).getModel());
    }

    @Test
    public void TestParetoComparisonWithLE(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        for(Car car :usedcars){
            car.setDominationCount(usedcars);
        }
        Collections.sort(usedcars, Comparator.comparing((Car car) -> car.getDominationCount()));
        assertEquals(8, usedcars.get(11).getDominationCount());

    }

    @Test
    public void TestCarPriceWithLE(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
//        sorting used cars using Comparator.comparing with LE's.
        Collections.sort(usedcars, Comparator.comparing((Car car) -> car.getPrice()));
        assertEquals("Passat",usedcars.get(0).getModel());
        assertEquals("Optima", usedcars.get(2).getModel());
    }

    @Test
    public void TestCarPriceWithLECompareMethod(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        Collections.sort(usedcars, (o1, o2) -> o1.getPrice() - o2.getPrice());
        assertEquals("Passat",usedcars.get(0).getModel());
        assertEquals("Optima", usedcars.get(2).getModel());
    }

    @Test
    public void TestCarPriceWithLEFromHighToLow(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        Collections.sort(usedcars, Comparator.comparing((Car car) -> car.getPrice(), Comparator.reverseOrder()));
        assertEquals("model-x", usedcars.get(0).getModel());
        assertEquals("Innova", usedcars.get(1).getModel());
    }

    @Test
    public void TestCarYearWithLE(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
//        To sort year from high to low we should use descending ordering in Comparator.comparing.
        Collections.sort(usedcars, Comparator.comparing((Car car) -> car.getYear(), Comparator.reverseOrder()));
        assertEquals("Accord", usedcars.get(0).getModel());
        assertEquals("model-y", usedcars.get(1).getModel());
    }

    @Test
    public void TestCarYearWithLECompareMethod(){
        ArrayList<Car> usedcars  = TestFixture.getUsedCars();
        Collections.sort(usedcars, (o1, o2) -> o2.getYear() - o1.getYear());
        assertEquals("Accord", usedcars.get(0).getModel());
        assertEquals("model-y", usedcars.get(1).getModel());
    }

    @Test
    public void TestSortCarYearFromLowToHigh(){
        ArrayList<Car> usedcars = TestFixture.getUsedCars();
        Collections.sort(usedcars, Comparator.comparing((Car::getYear)));
//        The Passet car has The Lowest Year among all cars .
        assertEquals("Passat", usedcars.get(0).getModel());
        assertEquals("6", usedcars.get(1).getModel());
    }





}