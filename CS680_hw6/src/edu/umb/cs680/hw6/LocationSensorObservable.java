package edu.umb.cs680.hw6;

import java.util.LinkedList;

public class LocationSensorObservable {
    private final LinkedList<LocationObserver> locationSensorObservers = new LinkedList<>();

    public void addLocationObserver(LocationObserver o) {
        locationSensorObservers.add(o);
    }

    public void RemoveLocationObserver(LocationObserver o){
        locationSensorObservers.remove(o);
    }

    public  int CountLocationObservers(){
        return locationSensorObservers.size();
    }
//    private String LocationName;
//    public void notifyLocationObserver(){
//        LOCATIONEvent L = new LOCATIONEvent(LocationName);
//        notifyLocationObserver(L);
//    }

    public void notifyLocationObserver(LOCATIONEvent event) {
        locationSensorObservers.forEach((LocationObserver)->{LocationObserver.updateLocationSensor(event);});

    }


}
