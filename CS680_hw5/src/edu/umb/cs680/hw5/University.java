package edu.umb.cs680.hw5;

// we have to extend Observable class, in which we will write public method that will take a variables which we want to update , and notifies the observers
public class University extends Observable<UmassBostonEvents> {
//    when we use notifyObservers method in EventUpdate , we have to pass which will get updated.
//    In our case the UmassBostonEvents will be notified when they uploaded in the app 0r website .
    private String EventName;
    public void EventUpdateNotify(String EventName){
        notifyObservers(new UmassBostonEvents(EventName));
    }

    public static void main(String[] args){
        University uni = new University();
        AndroidUser s1 = new AndroidUser("shyam");
        MacUser  s2 = new MacUser("sai");
        AndroidUser s3 = new AndroidUser("chipp");

        uni.addObserver(s1);
        uni.addObserver(s2);

        uni.EventUpdateNotify("Garbha Night!!");
        uni.removeObserver(s2);
        System.out.println(uni.countObservers());
        uni.clearObservers();
        System.out.println(uni.countObservers());




    }

}
