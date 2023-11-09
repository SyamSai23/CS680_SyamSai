package edu.umb.cs680.hw6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TrackerAppTest {

    StepCounterObservable o  = new StepCounterObservable();
    LocationSensorObservable L = new LocationSensorObservable();

    MobileTrackerApp Ob1 = new MobileTrackerApp("shyam");
    MobileTrackerApp  Ob2 = new MobileTrackerApp("shyam");

    SmartWatchTrackerApp ob3 = new SmartWatchTrackerApp("sai");
    SmartWatchTrackerApp ob4 = new SmartWatchTrackerApp("sai");

    @Test
    public void TestCaseForRegistrationAndUnRegistration(){
        o.addStepCountObserver(Ob1);
        L.addLocationObserver(Ob2);

        o.addStepCountObserver(ob3);
        L.addLocationObserver(ob4);
// when the user un sunbcribe from one of the event , then the user will not get notification from any of the event
//        in the TrackerApp
        assertEquals(2,o.CountStepCountObserver());
        o.removeStepCountObserver(Ob1);
        assertEquals(1,o.CountStepCountObserver());


    }

    @Test
    public void TestCaseForWhetherEachObserverNotified() {
//        Here we are checking if the user really gets the notification to mobile or either watch .
//        using hasReactedToStateChange method which will be initially false if it exceutes update method , then it will become true .
        o.addStepCountObserver(Ob1);
        L.addLocationObserver(Ob2);

        Ob1.updateStepCount(23);
        Ob2.updateLocationSensor("Dmm");
        assertTrue(Ob1.hasReactedToStateChange());
        assertTrue(Ob2.hasReactedToStateChange());

    }







}
