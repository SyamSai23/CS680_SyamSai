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
                //         Checking if the all the values are in the range[0,1]
                assertTrue(values >= 0.0 && values <=1.0);
            }
        }

//        Checking if the expected matrix size and actual matrix are same
        assertEquals(1000, Distance.matrix(points).size());

        List<List<Double>> cosineMatrix = Distance.matrix(points, new Cosine());
        System.out.println(cosineMatrix);
    }

    @Test
    public void TestCosineSimilarity(){
        ArrayList<Car> cars = TestFixtures.getCars();
        double expectedCValue = 0.9999924165847464;
        assertEquals(expectedCValue, (Distance.get(cars.get(0).getCarValuesAsList(), cars.get(1).getCarValuesAsList(), new Cosine())));
    }
//
    @Test
    public void TestDistanceMatrixCosine(){
        List<Car> cars = TestFixtures.getCars();
        List<List<Double>> carValues = new ArrayList<>();
        for(Car car: cars){
            carValues.add(car.getCarValuesAsList());
        }
        List<List<Double>> normValues = Car.Normalization(carValues);
//        System.out.println(Distance.matrix(points, new Cosine()));
        List<List<Double>> expecetdMatrix = Arrays.asList(
                Arrays.asList(1.0, 0.9370410187024395, 0.32912990375354123, 0.9252404232446889),
                Arrays.asList(0.9370410187024395, 0.9999999999999999, 0.0, 0.8030204340156075),
                Arrays.asList(0.32912990375354123, 0.0, 1.0, 0.5773502691896258),
                Arrays.asList(0.9252404232446889, 0.8030204340156075, 0.5773502691896258, 1.0000000000000002)
        );
        assertEquals(expecetdMatrix, (Distance.matrix(normValues, new Cosine())));
    }

}