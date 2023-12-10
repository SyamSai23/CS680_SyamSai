package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(this.parent != null){
            parent.appendChild(this);
        }
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public void PlaceHolder() {}


}
