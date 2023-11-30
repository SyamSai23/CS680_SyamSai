package edu.umb.cs680.hw6;

public class LOCATIONEvent {
    private final String locationName;

    public LOCATIONEvent(String locationName){
        this.locationName = locationName;
    }

    public  String getLocationName(){
        return locationName;
    }
}
