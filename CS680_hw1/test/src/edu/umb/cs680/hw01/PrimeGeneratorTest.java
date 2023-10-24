package edu.umb.cs680.hw01;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {



    @Test
    public void TestCaseForIsEvenMethod(){
        PrimeGenerator gen = new PrimeGenerator(1,25);
        boolean actual = gen.isEven(24);
        boolean expected = true;
        assertEquals(expected,actual);
    }
//    Checking when you call the constructor , whether we are getting called same values or not.
    @Test
    public void TestConstructorPrimeGenerator(){
        PrimeGenerator gen = new PrimeGenerator(1,23);
        assertEquals(1,gen.from);
        assertEquals(23, gen.to);

    }

//    checking whether the input range is valid or not , using Try Catch Method .
//    if not valid throw RunTimeException
    @Test
    public void TestWhetherTheGivenRangeIsValid(){
        try {
            PrimeGenerator gen = new PrimeGenerator(-12,1);
            fail("Input range is not valid");
        }catch (RuntimeException ex){
            assertEquals("Wrong input values: from=-12 to=1", ex.getMessage());
        }
    }

//Checking for single number , whether the number is prime or not .
    @Test
    public void TestForIsPrimeMethod(){
        PrimeGenerator gen = new PrimeGenerator(1,20);
        boolean actual = gen.isPrime(3);
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void TestCaseForGettingPrimesFrom1To12(){
        PrimeGenerator gen = new PrimeGenerator(1, 12);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L };
//      we use asserArrayEquals for checking whether the elements in array are equal or not .
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
//        we use assertIterableEquals for checking whether the total number of elements are same or not .
        assertIterableEquals(Arrays.asList(expectedPrimes), gen.getPrimes());

    }


}

