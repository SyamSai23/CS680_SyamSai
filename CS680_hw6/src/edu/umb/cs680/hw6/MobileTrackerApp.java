package edu.umb.cs680.hw6;

public class MobileTrackerApp implements StepCountObserver, LocationObserver {


    private boolean reactedNotification = false;

    private final String name;
    public MobileTrackerApp(String name){
        this.name = name;
    }

    @Override
    public void updateLocationSensor(LOCATIONEvent locationName) {
        reactedNotification = true;
        System.out.println( " hey " + name + " your Current Location is  " + locationName.getLocationName());
    }

    @Override
    public void updateStepCount(STEPCOUNTEvent stepCount) {
        reactedNotification = true;
        System.out.println(" hey " + name + " You have achieved an new goal " + stepCount.getStepCount());
    }

    public boolean hasReactedToStateChange(){
        return reactedNotification;
    }


}
