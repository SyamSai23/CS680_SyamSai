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
        System.out.println(Distance.matrix(points,new Manhattan()));
//        Checking if the expected matrix size and actual matrix are same
        assertEquals(1000, Distance.matrix(points).size());
//         Checking if the all the values are in the range[0,1]
        List<List<Double>> ManhattanMatrix = Distance.matrix(points, new Manhattan());
        for(List<Double> row : ManhattanMatrix){
            for(Double values: row){
                values = Math.min(1.0, Math.max(0.0, values));
                assertTrue(values >= 0.0 && values <=1.0);
            }
        }
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
        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars){
            points.add(car.Normalization(car.getCarValuesAsList()));
        }
        System.out.println(Distance.matrix(points, new Manhattan()));
        List<List<Double>> expectedMatrix = Arrays.asList(
                Arrays.asList(0.0, 0.002861220119949104, 0.11129954915670028, 0.030344581024647155),
                Arrays.asList(0.002861220119949104, 0.0, 0.11416076927664938, 0.02748336090469805),
                Arrays.asList(0.11129954915670028, 0.11416076927664938, 0.0, 0.14164413018134742),
                Arrays.asList(0.030344581024647155, 0.02748336090469805, 0.14164413018134742, 0.0)
        );
        assertEquals(expectedMatrix, (Distance.matrix(points, new Manhattan())));


    }

}