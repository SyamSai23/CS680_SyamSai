package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class MileageComparatorTest {

    @Test
    public void TestForMileageComparison(){
        ArrayList<Car> usedCars = TestFixture.getUsedCars();
        usedCars.sort(new MileageComparator());
       assertEquals("Accord", usedCars.get(0).getModel());
       assertEquals("Sonataa", usedCars.get(2).getModel());
    }

}