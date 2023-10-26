package edu.umb.cs680.hw3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
//    Including private method
    private String[] carToStringArray(Car c) {
        String[] CarInfo = {c.getMake(),
                c.getModel(), String.valueOf(c.getYear())};
        return CarInfo;
    }
    @Test
    public void verifyCarEqualityWithMakeModelYear(){
//      Array to Array comparison
        String[] expectedcar1 = {"Tayota","Innova", String.valueOf(2018)};
        Car actualcar1 = new Car("Tayota","Innova",12,2018,35000);
        assertArrayEquals(expectedcar1, carToStringArray(actualcar1));

        String[] expectedcar2 = {"Honda","civic", String.valueOf(2010)};
        Car actualcar2 = new Car("Honda","civic",12,2010,12000);
        assertArrayEquals(expectedcar2,carToStringArray(actualcar2));
    }




}