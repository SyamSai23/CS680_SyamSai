package edu.umb.cs680.hw7;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    LinkedList<FSElement> Children = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
//        Check if  composite is not null that is , if the parent node is not
//        null then append(add) child as leaf node to the parent.
        if(this.parent != null){
            parent.appendChild(this);
        }

    }

    public LinkedList<FSElement> getChildren(){
        return this.Children;
    }
    LinkedList<Directory> SubDirectories = new LinkedList<Directory>();
    public LinkedList<Directory> getSubDirectories(){
//        Here we have used Enhanced ForLoop, Get all the childrens from the
//        FSElement and check whether node is directory or not .
        SubDirectories.clear();
        for(FSElement Node : this.Children){
            if(Node.isDirectory()){
                SubDirectories.add((Directory) Node);
            }
        }
        return SubDirectories;
    }
    LinkedList<File> Files = new LinkedList<File>();
    public  LinkedList<File> getFiles()
    {
        Files.clear();
        for(FSElement Node :this.Children){
            if(!Node.isDirectory()){
                Files.add((File) Node);
            }
        }
        return Files;
    }
    public  void appendChild(FSElement child){
        this.Children.add(child);
        child.setParent(this);
    }



    public  int CountChildren(){
        return  Children.size();
    }

    public  int getTotalSize(){
        int totalSize = 0;
        for(FSElement Node : this.Children){
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

    public static void main(String[] args){
        FileSystem instance = FileSystem.getFileSystem();
        Directory root = new Directory(null,"Root",0, LocalDateTime.now());
        instance.appendRootDir(root);
        Directory src = new Directory(root,"src",0,LocalDateTime.now());
        Directory test = new Directory(root,"test",0,LocalDateTime.now());
        File java1 = new File(null,"main",2,LocalDateTime.now());
        src.appendChild(java1);
        File java2 = new File(src,"Helloworld",3,LocalDateTime.now());
//        src.RemoveChild(java2);
        File java3 = new File(test,"HelloworldTest",4,LocalDateTime.now());
        File xml = new File(root,"xml",2,LocalDateTime.now());
        File ivy = new File(root,"ivy",2,LocalDateTime.now());

//        for (FSElement fsElement: src.getChildren()){
//            fsElement.getName();
//            fsElement.getSize();
//            fsElement.getParent().getName();
//            System.out.println(fsElement.getName());
//            System.out.println(fsElement.getParent().getName());
//            System.out.println(fsElement.getSize());
//        }

//        System.out.println(root.getTotalSize());
//        System.out.println(root.CountChildren());
//        System.out.println(src.CountChildren());
        System.out.println(root.getTotalSize());


    }
}
