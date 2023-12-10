package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ParetoComparatorTest {
    @Test
    public void TestParetoComparision(){
        ArrayList<Car> usedCars = TestFixture.getUsedCars();
        for(Car car: usedCars){
            car.setDominationCount(usedCars);
        }
        Collections.sort(usedCars, new ParetoComparator<Car>());
//        The Domination Count for Model Tavera is 2, Both Accord & Innova Dominated tavera in terms of Price, Year & Mileage .
        assertEquals(8,usedCars.get(11).getDominationCount());

    }
}