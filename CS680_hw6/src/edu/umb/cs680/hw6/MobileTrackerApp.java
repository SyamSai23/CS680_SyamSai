package edu.umb.cs680.hw6;

public class MobileTrackerApp implements StepCountObserver, LocationObserver {


    private boolean reactedNotification = false;

    private final String name;
    public MobileTrackerApp(String name){
        this.name = name;
    }

    @Override
    public void updateLocationSensor(String LocationName) {
        reactedNotification = true;
        System.out.println( "hey" + name+ "your Current Location is  " + LocationName);
    }

    @Override
    public void updateStepCount(int stepCount) {
        reactedNotification = true;
        System.out.println("hey" + name + "You have acheived an new goal " + stepCount);
    }

    public boolean hasReactedToStateChange(){
        return reactedNotification;
    }


}
