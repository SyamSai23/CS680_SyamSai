package edu.umb.cs680.hw6;

import java.util.LinkedList;

public class LocationSensorObservable {
    private final LinkedList<LocationObserver> LocationSensorObservers = new java.util.LinkedList<>();

    public void addLocationObserver(LocationObserver o) {
        LocationSensorObservers.add(o);
    }

    public void RemoveLocationObserver(LocationObserver o){
        LocationSensorObservers.remove(o);
    }

    public  int CountLocationObservers(){
        return LocationSensorObservers.size();
    }
//    private String LocationName;
//    public void LocationNotify(){
//        LOCATIONEvent L = new LOCATIONEvent(LocationName);
//        notifyLocationObserver(L);
//    }

    public void notifyLocationObserver(String LocationName) {
        LOCATIONEvent event = new LOCATIONEvent(LocationName);
        LocationSensorObservers.forEach((LocationObserver)->{LocationObserver.updateLocationSensor(event.getLocationName());});

    }
}
