package edu.umb.cs680.hw2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {
     @Test
    public  void TestCaseGetInstanceReturnsNonNUllValue(){
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
        assertNotNull(SingletonPrimeGenerator.getInstance(), "NULL");
//        Here it returns a NonNull value, which is true for Singleton class
//        if it is Null value , then it will return output as NULL .
    }

    @Test
    public void TestCaseGetInstanceReturnsIdenticalInstance(){
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance();
        assertSame(gen1,gen2);
//        Returns Identical Instances when it is called multiple times, here we have two objects gen1 & gen2
//        but returns both as same .which is true for Singleton class
    }

    @Test
    public void TestCaseWhetherTheGivenInputReturnsExpectedValue(){
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
        gen.SetValues(2,25);
        gen.generatePrimes();
        Long[] expected = {2L,3L,5L,7L,11L,13L,17L,19L,23L};
        assertIterableEquals(Arrays.asList(expected), gen.getPrimes());
        assertArrayEquals(expected , gen.getPrimes().toArray());
    }
    @Test
    public void TestCaseWhetherInputRangeIsValid(){
        try{
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
            gen.SetValues(-12,1);
            fail("Input Range is Not Valid");
        }catch (RuntimeException e){
            assertEquals("Wrong input values: from=-12 to=1",e.getMessage());
        }
    }

}