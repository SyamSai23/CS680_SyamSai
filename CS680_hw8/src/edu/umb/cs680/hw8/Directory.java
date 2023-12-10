package edu.umb.cs680.hw8;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    LinkedList<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
//        Check if  composite is not null that is , if the parent node is not
//        null then append(add) child as leaf node to the parent.
        if(this.parent != null){
            parent.appendChild(this);
        }

    }

    public LinkedList<FSElement> getChildren(){
        return this.children;
    }
    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDir = new LinkedList<>();
//        Here we have used Enhanced ForLoop, Get all the children from the
//        FSElement and check whether node is directory or not .
        for(FSElement Node : this.children){
            if(Node.isDirectory()){
                subDir.add((Directory) Node);
            }
        }
        return subDir;
    }
    public  LinkedList<File> getFiles()
    {
        LinkedList<File> files = new LinkedList<>();
        for(FSElement Node :this.children){
            if(Node.isFile()){
                files.add((File) Node);
            }
        }
        return files;
    }

    public LinkedList<Link> getLink(){
        LinkedList<Link> links = new LinkedList<>();
        for(FSElement Node : this.children){
            if(!Node.isDirectory() && !Node.isFile()){
                links.add((Link) Node);
            }
        }
        return links;
    }
    public  void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
    }

    public  int CountChildren(){
        return  children.size();
    }

    public  int getTotalSize(){
        int totalSize = 0;
        for(FSElement Node : this.children){
//            totalSize += Node.getSize();
//            Checking if the Node is not Directory , for adding all the
//            individual files in the Root Directory
            if(!Node.isDirectory()){
                totalSize += Node.getSize();
            }
            else {
//                Calling function Recursively
//                Adding the Size of files in all the SubDirectories in the
//                Root Directory.
                totalSize += ((Directory) Node).getTotalSize();
            }

        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public void placeHolder() {}


}
