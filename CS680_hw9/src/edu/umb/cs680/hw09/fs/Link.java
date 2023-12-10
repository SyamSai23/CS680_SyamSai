package edu.umb.cs680.hw09.fs;

import java.time.LocalDateTime;

public class Link extends FSElement {
//    Links can be used as Shortcuts to Directory or a File
//    Once you set a link to a target you can not again change the link to another target.
    private final FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
        if(parent !=null){
            parent.appendChild(this);
        }

    }



    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
//    Placeholder is ,checks
    public void PlaceHolder() {
        if (target != null){
            System.out.println(this.name);
            target.PlaceHolder();
        }
        else {
            System.out.println(name);
        }
    }

    public void removeLink(){
//        Removes the particular Link when a remove method is called , BY not affecting the orginal File or Directory.
        if(parent !=null){
            parent.getChildren().remove(this);

        }


    }

    public FSElement getTarget(){
        return this.target;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }

    public int getSize(){
        return 0;
    }




}
