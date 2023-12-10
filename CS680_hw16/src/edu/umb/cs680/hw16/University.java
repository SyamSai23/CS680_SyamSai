package edu.umb.cs680.hw16;

// we have to extend Observable class, in which we will write public method that will take a variables which we want to update , and notifies the observers
public class University extends Observable<UmassBostonEvents> {
//    when we use notifyObservers method in EventUpdate , we have to pass which will get updated.
//    In our case the UmassBostonEvents will be notified when they uploaded in the app 0r website .
    public void EventUpdateNotify(String eventName){
        notifyObservers(new UmassBostonEvents(eventName));
    }

//    public static void main(String[] args){
//        University university = new University();
//        LinkedList<String> androidUsers = new LinkedList<>();
//        androidUsers.add("shyam");
//        androidUsers.add("Sai");
//        androidUsers.add("chipp");
//        androidUsers.add("swash");
//        androidUsers.add("jack");
//
//        Map<String, Observer<UmassBostonEvents>> androidObservers = new HashMap<>();
//
//        androidUsers.forEach(name -> {
//            Observer<UmassBostonEvents> obs = ((sender, event) -> {
//                System.out.println("Hey " + name + " " + event.getEventName());
//            });
//            university.addObserver(obs);
//            androidObservers.put(name, obs);
//        });
//
//        university.removeObserver(androidObservers.get("shyam"));
//
//        university.EventUpdateNotify("Gharba Night!!");
//
//        System.out.println(university.countObservers());
//
//    }
//
/////        androidUsers.forEach(name ->{
////            uni.addObserver( (Observable<UmassBostonEvents> sender ,UmassBostonEvents  event) -> {
////                System.out.println("Hey "+ name + " book your tickets for " + event.getEventName());
////            } );
////        });
////        LinkedList<String> iphoneUsers = new LinkedList<>();
////        iphoneUsers.add("raw");
////        iphoneUsers.add("josh");
////        iphoneUsers.add("simha");
////
////        iphoneUsers.forEach(name ->{
////            uni.addObserver( (Observable<UmassBostonEvents> sender , UmassBostonEvents events) ->{
////                System.out.println("hey "+ name + " book your tickets for " + events.getEventName());
////            } );
////        });
//



}
