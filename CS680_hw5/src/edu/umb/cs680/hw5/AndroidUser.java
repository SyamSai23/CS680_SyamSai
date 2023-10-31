package edu.umb.cs680.hw5;


// We are creating a Display methods that will implement the same Observer interface and overrides the update
//method .
public class AndroidUser implements Observer<UmassBostonEvents>{

//    Creating a method name called hasReactedTOStateChange , that tells us that each observer has been notified when an update method is called
    private  boolean reactedNotification = false;
    private  String name;
    public AndroidUser(String name){
        this.name = name;
    }

    @Override
    public void update(Observable<UmassBostonEvents> sender, UmassBostonEvents event) {
        reactedNotification = true;
        System.out.println("hey" + name +  "Grab your tickets for " +  event.getEventName());
    }

    public boolean hasReactedToStateChange(){
        return reactedNotification;
    }

}
