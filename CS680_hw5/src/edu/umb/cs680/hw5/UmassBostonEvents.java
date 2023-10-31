package edu.umb.cs680.hw5;

// We created a class and built a constructer and getter method , here the getter method is what , we will update .
public class UmassBostonEvents {
    private String EventName;

    public UmassBostonEvents(String EventName){
        this.EventName =EventName;
    }

    public String getEventName(){
        return EventName;
    }
}
