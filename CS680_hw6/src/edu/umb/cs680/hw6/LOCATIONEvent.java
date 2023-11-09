package edu.umb.cs680.hw6;

public class LOCATIONEvent {
    private String LocationName;

    public LOCATIONEvent(String LocationName){
        this.LocationName = LocationName;
    }

    public  String getLocationName(){
        return LocationName;
    }
}
