package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanTest {
    @Test
    public void TestManhattanDistanceMatrixWith1000Cars(){

        List<Car> cars = new ArrayList<>();
        Random rand = new Random();
        List<List<Double>> carValues = new ArrayList<>();
        for(int i=0; i<1000;i++){
//            Getting price range between 10000 and 100000
            int price = rand.nextInt(100000 - 10000) + 10000;
            int mileage = rand.nextInt(5000 - 1000) + 1000;
            int year = rand.nextInt(2020 - 2010) + 2010;
            Car car = new Car("","", mileage, price,year);
            cars.add(car);
            carValues.add(car.getCarValuesAsList());
        }
//        normalizing the values
        List<List<Double>> points = Car.Normalization(carValues);
        for(List<Double> row : points){
            for(Double values: row){
                assertTrue(values >= 0.0 && values <=1.0);
            }
        }
//        Checking if the expected matrix size and actual matrix are same
        assertEquals(1000, Distance.matrix(points).size());
//         Checking if the all the values are in the range[0,1]
        List<List<Double>> manhattanMatrix = Distance.matrix(points, new Manhattan());

        System.out.println(manhattanMatrix);
    }

    @Test
    public void TestManhattanDistance(){
        ArrayList<Car> cars = TestFixtures.getCars();
        double expectedCValue = 1025.0;
        assertEquals(expectedCValue, (Distance.get(cars.get(0).getCarValuesAsList(), cars.get(1).getCarValuesAsList(), new Manhattan())));
    }



    @Test
    public void TestDistanceMatrixManhattan(){
        List<Car> cars = TestFixtures.getCars();
        List<List<Double>> carValues = new ArrayList<>();
        for(Car car: cars){
            carValues.add(car.getCarValuesAsList());
        }
        List<List<Double>> normValues = Car.Normalization(carValues);
        List<List<Double>> expecetdMatrix = Arrays.asList(
                Arrays.asList(0.0, 0.6203571428571428, 1.7164285714285714, 1.0871428571428572),
                Arrays.asList(0.6203571428571428, 0.0, 1.5689285714285715, 1.6275),
                Arrays.asList(1.7164285714285714, 1.5689285714285715, 0.0, 2.803571428571429),
                Arrays.asList(1.0871428571428572, 1.6275, 2.803571428571429, 0.0)
        );
        assertEquals(expecetdMatrix, (Distance.matrix(normValues, new Manhattan())));

    }

}