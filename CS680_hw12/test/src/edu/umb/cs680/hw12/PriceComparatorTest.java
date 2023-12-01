package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {


    @Test
    void TestcomparePrice() {
        ArrayList<Car> usedCars = TestFixture.getUsedCars();

        usedCars.sort(new PriceComparator());
        assertEquals("Passat", usedCars.get(0).getModel());
        assertEquals("Optima", usedCars.get(2).getModel());


    }
}