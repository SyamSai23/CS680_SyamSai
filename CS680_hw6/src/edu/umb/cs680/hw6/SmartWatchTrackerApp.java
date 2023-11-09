package edu.umb.cs680.hw6;

public class SmartWatchTrackerApp implements StepCountObserver, LocationObserver {

    private boolean reactedNotification =false;

    private final String name;

    public SmartWatchTrackerApp(String name){
        this.name = name;
    }

    @Override
    public void updateLocationSensor(String Location) {
        reactedNotification = true;
        System.out.println(" hey "+ name +  " Your current location is   " + Location);

    }

    @Override
    public void updateStepCount(int stepCount) {
        reactedNotification = true;
        System.out.println(" Hey " + name + " You have acheived an new goal  " + stepCount);
    }

    public boolean hasReactedToStateChange(){
        return reactedNotification;
    }


}
