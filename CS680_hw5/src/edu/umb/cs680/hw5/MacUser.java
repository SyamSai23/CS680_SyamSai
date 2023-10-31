package edu.umb.cs680.hw5;

public class MacUser implements Observer<UmassBostonEvents>{
    private boolean reactedNotification = false;
    private  String name;
    public MacUser(String name){
        this.name = name;
    }
    @Override
    public void update(Observable<UmassBostonEvents> sender, UmassBostonEvents event) {
        reactedNotification =true;
        System.out.println( "hey " + name + " Grab your tickets for " +  event.getEventName());
    }

    public boolean hasReactedToStateChange(){
        return reactedNotification;
    }


}
