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
        List<List<Double>> carvalues = new ArrayList<>();
        for(int i=0; i<1000;i++){
//            Getting price range between 10000 and 100000
            int price = rand.nextInt(100000 - 10000) + 10000;
            int mileage = rand.nextInt(5000 - 1000) + 1000;
            int Year = rand.nextInt(2020 - 2010) + 2010;
            Car car = new Car("","", mileage, price,Year);
//            cars.add(car);
            carvalues.add(car.getCarValuesAsList());
        }
//        normalizing the values
        List<List<Double>> points = Car.Normalization(carvalues);
        for(List<Double> row : points){
            for(Double values: row){
                assertTrue(values >= 0.0 && values <=1.0);
            }
        }

//        Checking if the expected matrix size and actual matrix are same
        assertEquals(1000, Distance.matrix(points).size());
//         Checking if the all the values are in the range[0,1]
        List<List<Double>> euclideanMatrix = Distance.matrix(points, new Euclidean());

        System.out.println(euclideanMatrix);
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
    public void TestNormalizedValuesEucliedean(){
//     Checking NNormalization values.
        ArrayList<Car> cars = TestFixtures.getCars();
        List<List<Double>> carValues = new ArrayList<>();
        for(Car car: cars){
            carValues.add(car.getCarValuesAsList());
        }
        List<List<Double>> normValues = Car.Normalization(carValues);
        List<List<Double>> expectedNormValues = Arrays.asList(
                Arrays.asList(0.52, 1.0, 0.39285714285714285),
                Arrays.asList(0.56, 0.8125, 0.0),
                Arrays.asList(0.0, 0.0, 0.19642857142857142),
                Arrays.asList(1.0, 1.0, 1.0)
        );
        assertEquals(expectedNormValues, normValues);
    }

    @Test
    public void TestDistanceMatrixValuesEuclidean(){
        List<Car> cars = TestFixtures.getCars();
        List<List<Double>> CarValues = new ArrayList<>();
        for(Car car: cars){
            CarValues.add(car.getCarValuesAsList());
        }
        List<List<Double>> normValues = Car.Normalization(CarValues);
        List<List<Double>> expecetdMatrix = Arrays.asList(
                Arrays.asList(0.0, 0.43714183589983413, 1.144108466743197, 0.7739654055444545),
                Arrays.asList(0.43714183589983413, 0.0, 1.0061512976056184, 1.1084927830166509),
                Arrays.asList(1.144108466743197, 1.0061512976056184, 0.0, 1.6265691011501253),
                Arrays.asList(0.7739654055444545, 1.1084927830166509, 1.6265691011501253, 0.0)
        );
        assertEquals(expecetdMatrix, (Distance.matrix(normValues, new Euclidean())));

    }

}