package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class EuclideanTest {
    @Test
    public void TestEuclideanDistanceMatrixWith1000Cars(){
//      Running Distance matrix for 1000 random cars
        List<Car> cars = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<1000;i++){
//            Getting price range between 10000 and 100000
            int price = rand.nextInt(100000 - 10000) + 10000;
            int mileage = rand.nextInt(5000 - 1000) + 1000;
            int Year = rand.nextInt(2020 - 2010) + 2010;
            Car car = new Car("","", mileage, price,Year);
            car.getCarValuesAsList();
            cars.add(car);
        }
//        normalizing the values
        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars){
            points.add(car.Normalization(car.getCarValuesAsList()));
        }
        System.out.println(Distance.matrix(points,new Euclidean()));
//        Checking if the expected matrix size and actual matrix are same
        assertEquals(1000, Distance.matrix(points).size());
//         Checking if the all the values are in the range[0,1]
        List<List<Double>> euclideanMatrix = Distance.matrix(points, new Euclidean());
        for(List<Double> row : euclideanMatrix){
            for(Double values: row){
                values = Math.min(1.0, Math.max(0.0, values));
                assertTrue(values >= 0.0 && values <=1.0);
            }
        }

    }

    @Test
    public void TestForGetCarValuesAsList(){
//        Checking getCar-valuesAsAList method , returning correct values
        ArrayList<Car> cars = TestFixtures.getCars();
        List<Double> expectedValues = Arrays.asList(23000.0,2022.0,56.0);
        assertEquals(expectedValues, cars.get(0).getCarValuesAsList());
    }
    @Test
    public void TestEuclideanDistance(){
//        Checking the Euclidean Distance for two cars.
        ArrayList<Car> cars = TestFixtures.getCars();
        double expected = 14000.010357139026;
        assertEquals(expected, (Distance.get(cars.get(1).getCarValuesAsList(), cars.get(2).getCarValuesAsList(), new Euclidean())));
    }
    @Test
    public void TestNormalization(){
//     Checking NNormalization values.
        ArrayList<Car> cars = TestFixtures.getCars();
        List<Double> expectedValues = Arrays.asList(1.0,0.055342308794041825,0.0);
        assertEquals(expectedValues, cars.get(3).Normalization(cars.get(3).getCarValuesAsList()));
    }

    @Test
    public void TestDistanceMatrixValuesEuclidean(){
        List<Car> cars = TestFixtures.getCars();
        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars){
            points.add(car.Normalization(car.getCarValuesAsList()));
        }
        List<List<Double>> expecetdMatrix = Arrays.asList(
                Arrays.asList(0.0, 0.002861220119949104, 0.11129954915670028, 0.030344581024647155),
                Arrays.asList(0.002861220119949104, 0.0, 0.11416076927664938, 0.02748336090469805),
                Arrays.asList(0.11129954915670028, 0.11416076927664938, 0.0, 0.14164413018134742),
                Arrays.asList(0.030344581024647155, 0.02748336090469805, 0.14164413018134742, 0.0)
        );
        assertEquals(expecetdMatrix, (Distance.matrix(points, new Euclidean())));

    }

}