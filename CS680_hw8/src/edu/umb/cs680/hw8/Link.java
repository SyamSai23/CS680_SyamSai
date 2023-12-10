package edu.umb.cs680.hw8;

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
    public void placeHolder() {
        if (target != null){
            System.out.println(this.name);
            target.placeHolder();
        }
        else {
            System.out.println(name);
        }
    }
    public void removeLink(){
//        Removes the particular Link when a remove method is called , BY not affecting the original File or Directory.
        if(parent !=null){
            parent.getChildren().remove(this);

        }


    }
    public FSElement getTarget(){
        return this.target;
    }

    public int getSize(){
        return 0;
    }




}
