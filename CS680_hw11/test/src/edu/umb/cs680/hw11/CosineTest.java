package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CosineTest {
    @Test
    public void TestCosineDistanceMatrixWith1000Cars(){
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
        System.out.println(Distance.matrix(points,new Cosine()));
//        Checking if the expected matrix size and actual matrix are same
        assertEquals(1000, Distance.matrix(points).size());
//         Checking if the all the values are in the range[0,1]
        List<List<Double>> ManhattanMatrix = Distance.matrix(points, new Cosine());
        for(List<Double> row : ManhattanMatrix){
            for(Double values: row){
                values = Math.min(1.0, Math.max(0.0, values));
                assertTrue(values >= 0.0 && values <=1.0);
            }
        }
    }

    @Test
    public void TestCosineSimilarity(){
        ArrayList<Car> cars = TestFixtures.getCars();
        double expectedCValue = 0.9999924165847464;
        assertEquals(expectedCValue, (Distance.get(cars.get(0).getCarValuesAsList(), cars.get(1).getCarValuesAsList(), new Cosine())));
    }

    @Test
    public void TestDistanceMatrixCosine(){
        List<Car> cars = TestFixtures.getCars();
        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars){
            points.add(car.Normalization(car.getCarValuesAsList()));
        }
//        System.out.println(Distance.matrix(points, new Cosine()));
        List<List<Double>> expectedMatrix = Arrays.asList(
                Arrays.asList(1.0000000000000002, 0.9999959642221958, 0.9940634062554021, 0.9995442505923098),
                Arrays.asList(0.9999959642221958, 1.0000000000000002, 0.9937502821052444, 0.9996259809937771),
                Arrays.asList(0.9940634062554021, 0.9937502821052444, 0.9999999999999998, 0.9903258817548258),
                Arrays.asList(0.9995442505923098, 0.9996259809937771, 0.9903258817548258, 1.0000000000000002)
        );
        assertEquals(expectedMatrix, (Distance.matrix(points, new Cosine())));
    }

}