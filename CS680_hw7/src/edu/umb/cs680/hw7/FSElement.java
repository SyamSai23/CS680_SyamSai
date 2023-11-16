package edu.umb.cs680.hw7;

import java.time.LocalDateTime;

public abstract  class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;

    protected  Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime){
        this.parent = parent;
        this.name =name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent(){
        return this.parent;
    }

    public void setParent(Directory parent){
        this.parent = parent;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }

    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size =size;
    }

    public LocalDateTime getCreationTime(){
        return creationTime;
    }

    public abstract boolean isDirectory();

}


