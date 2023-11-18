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
        assertEquals("Accord", usedCars.get(0).getModel());
        assertEquals("Innova", usedCars.get(1).getModel());


    }
}