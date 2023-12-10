package edu.umb.cs680.hw6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TrackerAppTest {

    StepCounterObservable o  = new StepCounterObservable();
    LocationSensorObservable l = new LocationSensorObservable();

    MobileTrackerApp ob1 = new MobileTrackerApp("shyam");
    MobileTrackerApp ob2 = new MobileTrackerApp("Chipp");
    MobileTrackerApp ob3 = new MobileTrackerApp("swash");
    SmartWatchTrackerApp ob4 = new SmartWatchTrackerApp("sai");
    SmartWatchTrackerApp ob5 = new SmartWatchTrackerApp("Jack");



    @Test
    public void TestCaseForRegistrationAndUnRegistration(){
        o.addStepCountObserver(ob1);
        l.addLocationObserver(ob1);

        o.addStepCountObserver(ob2);
        l.addLocationObserver(ob2);

        o.addStepCountObserver(ob3);
        l.addLocationObserver(ob3);

        o.addStepCountObserver(ob4);
        l.addLocationObserver(ob4);


        o.addStepCountObserver(ob5);
        l.addLocationObserver(ob5);

        assertEquals(5,o.CountStepCountObserver());
        assertEquals(5, l.CountLocationObservers());

    }

    @Test
    public void TestCaseForWhetherObserversAreNotified() {
//        Here we are checking if the user really gets the notification to mobile or either watch .
//        using hasReactedToStateChange method which will be initially false if it executes update method , then it will become true .

        ob1.updateStepCount(new STEPCOUNTEvent(2300));
        ob1.updateLocationSensor(new LOCATIONEvent("China Town"));

        ob2.updateStepCount(new STEPCOUNTEvent(400));
        ob2.updateLocationSensor(new LOCATIONEvent("Jfk-Umass"));

        ob3.updateStepCount(new STEPCOUNTEvent(5000));
        ob3.updateLocationSensor(new LOCATIONEvent("Medford"));

        ob4.updateStepCount(new STEPCOUNTEvent(3000));
        ob4.updateLocationSensor(new LOCATIONEvent("Park Street"));

        ob5.updateStepCount(new STEPCOUNTEvent(1200));
        ob5.updateLocationSensor(new LOCATIONEvent("DownTown"));
        assertTrue(ob1.hasReactedToStateChange());
        assertTrue(ob2.hasReactedToStateChange());
        assertTrue(ob3.hasReactedToStateChange());
        assertTrue(ob4.hasReactedToStateChange());
        assertTrue(ob5.hasReactedToStateChange());

    }







}
