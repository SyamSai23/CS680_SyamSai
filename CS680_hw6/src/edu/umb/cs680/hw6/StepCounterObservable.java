package edu.umb.cs680.hw6;

import java.util.LinkedList;

public class StepCounterObservable {
    private final LinkedList<StepCountObserver> stepCountObservers = new LinkedList<>();

    public void addStepCountObserver(StepCountObserver o) {
        stepCountObservers.add(o);
    }

    public void removeStepCountObserver(StepCountObserver o) {
        stepCountObservers.remove(o);
    }

    public int CountStepCountObserver(){
        return stepCountObservers.size();
    }

//    private int count;
//    public void StepCountNotify(){
//        STEPCOUNTEvent s = new STEPCOUNTEvent(count);
//        notifyStepCountObserver(s);
//    }

    public void notifyStepCountObserver(STEPCOUNTEvent event ) {
        stepCountObservers.forEach((StepCountObserver)->{StepCountObserver.updateStepCount(event);});

    }



}

