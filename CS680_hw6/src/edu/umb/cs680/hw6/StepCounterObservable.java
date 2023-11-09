package edu.umb.cs680.hw6;

import java.util.LinkedList;

public class StepCounterObservable {
    private LinkedList<StepCountObserver> StepCountObservers = new LinkedList<>();

    public void addStepCountObserver(StepCountObserver o) {
        StepCountObservers.add(o);
    }

    public void removeStepCountObserver(StepCountObserver o) {
        StepCountObservers.remove(o);
    }

    public int CountStepCountObserver(){
        return StepCountObservers.size();
    }

//    private int count;
//    public void StepCountNotify(){
//        STEPCOUNTEvent s = new STEPCOUNTEvent(count);
//        notifyStepCountObserver(s);
//    }

    public void notifyStepCountObserver(int StepCount ) {
        STEPCOUNTEvent event = new STEPCOUNTEvent(StepCount);
//        StepCountObservers.forEach((StepCountObserver)->{StepCountObserver.updateStepCount(event.getStepCount());});
        for(StepCountObserver ob : StepCountObservers){
            ob.updateStepCount(event.getStepCount());
        }
    }

}

