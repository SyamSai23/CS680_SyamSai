package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class YearComparatorTest {
    @Test
    public void TestForYearComparison(){
        ArrayList<Car> usedCars = TestFixture.getUsedCars();
        usedCars.sort(new YearComparator());
        assertEquals("Accord", usedCars.get(0).getModel());
        assertEquals("model-y", usedCars.get(1).getModel());
    }

}