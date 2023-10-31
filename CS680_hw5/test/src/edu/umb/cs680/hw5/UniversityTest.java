package edu.umb.cs680.hw5;

import org.junit.jupiter.api.Test;

import java.lang.management.RuntimeMXBean;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    University uni =new University();
    AndroidUser s1 = new AndroidUser("shyam");
    MacUser s2 = new MacUser("sai");
    @Test
    public void TestCaseRegistrationAndUnRegistration(){

        uni.addObserver(s1);
        uni.addObserver(s2);
//Checks when an student subscribed to umass events , whether the student is actually there in the Observers List.
        assertEquals(2, uni.countObservers());
        uni.removeObserver(s1);
        assertEquals(1,uni.countObservers());

    }

    @Test
    public void TestCaseWhetherEachObserverNotified(){
        uni.addObserver(s1);
        uni.addObserver(s2);
        uni.EventUpdateNotify("Garbha");
        assertTrue(s1.hasReactedToStateChange());
        assertTrue(s2.hasReactedToStateChange());
    }

    @Test
    public void TestCaseForClearObservers(){
        uni.addObserver(s1);
        uni.addObserver(s2);

        uni.clearObservers();
        assertEquals(0,uni.countObservers());
    }


}