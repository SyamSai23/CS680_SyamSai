package edu.umb.cs680.hw6;

public class SmartWatchTrackerApp implements StepCountObserver, LocationObserver {

    private boolean reactedNotification =false;

    private final String name;

    public SmartWatchTrackerApp(String name){
        this.name = name;
    }

    @Override
    public void updateLocationSensor(LOCATIONEvent locationName) {
        reactedNotification = true;
        System.out.println(" hey "+ name +  " Your current location is   " + locationName.getLocationName());

    }

    @Override
    public void updateStepCount(STEPCOUNTEvent stepCount) {
        reactedNotification = true;
        System.out.println(" Hey " + name + " You have acheived an new goal  " + stepCount.getStepCount());
    }

    public boolean hasReactedToStateChange(){
        return reactedNotification;
    }


}
