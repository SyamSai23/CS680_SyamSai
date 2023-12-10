package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    University university = new University();

    @Test
    public void TestUserSubscribedForUmassBostonEvents(){
        LinkedList<String> androidUsers = new LinkedList<>();
        androidUsers.add("shyam");
        androidUsers.add("Sai");
        androidUsers.add("chip");
        androidUsers.add("swash");
        androidUsers.add("jack");


        androidUsers.forEach(name -> {
            Observer<UmassBostonEvents> obs = ((sender, event) -> {
                System.out.println("Hey " + name + " grab tickets for  " + event.getEventName());
            });
            university.addObserver(obs);
        });
        assertEquals(5, university.countObservers());
        university.clearObservers();
        assertEquals(0, university.countObservers());


    }

    @Test
    public void TestRemoveObserver(){
        LinkedList<String> androidUsers = new LinkedList<>();
        androidUsers.add("shyam");
        androidUsers.add("Sai");
        androidUsers.add("chip");
        androidUsers.add("swash");
        androidUsers.add("jack");

        Map<String, Observer<UmassBostonEvents>> androidObservers = new HashMap<>();

        androidUsers.forEach(name -> {
            Observer<UmassBostonEvents> obs = ((sender, event) -> {
                System.out.println("Hey " + name + " grab tickets for  " + event.getEventName());
            });
            university.addObserver(obs);
            androidObservers.put(name, obs);
        });

        university.removeObserver(androidObservers.get(androidUsers.get(0)));
        university.removeObserver(androidObservers.get(androidUsers.get(1)));
        assertEquals(3, university.countObservers());
    }

    @Test
    public void TestWhetherEachObserverNotified(){
        LinkedList<String> androidUsers = new LinkedList<>();
        androidUsers.add("shyam");
        androidUsers.add("Sai");
        androidUsers.add("chip");
        androidUsers.add("swash");
        androidUsers.add("jack");

        Map<String, Boolean> androidObservers = new HashMap<>();

        androidUsers.forEach(name -> {
            androidObservers.put(name, false);
            Observer<UmassBostonEvents> obs = ((sender, event) -> {
                androidObservers.put(name, true);
                System.out.println("Hey " + name + " grab tickets for  " + event.getEventName());
            });
            university.addObserver(obs);
        });

        university.EventUpdateNotify("GARBHA!! ");
        androidObservers.forEach( (name, eventNotified) -> {
            assertTrue(eventNotified);
        } );

    }



}