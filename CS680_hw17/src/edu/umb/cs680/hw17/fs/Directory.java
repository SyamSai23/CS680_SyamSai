package edu.umb.cs680.hw17.fs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        children.forEach(e -> {
            e.accept(v);
        });
    }
    public LinkedList<FSElement> getChildren(){
        return this.children;
    }
    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDir = new LinkedList<Directory>();
//        Here we have used Enhanced ForLoop, Get all the children from the
//        FSElement and check whether node is directory or not .
        children.forEach(NOde -> {
            if(NOde.isDirectory()){
                subDir.add((Directory) NOde);
            }
        });
        return subDir;
    }


    public  LinkedList<File> getFiles()
    {
        LinkedList<File> files = new LinkedList<File>();
        children.forEach(N0de -> {
            if(N0de.isFile()){
                files.add( (File) N0de);
            }
        });
        return files;
    }

    public LinkedList<Link> getLink(){
        LinkedList<Link>  links = new LinkedList<>();
        children.forEach(Node -> {
            if(Node.isLink()){
                links.add( (Link) Node);
            }
        });
        return links;
    }
    public  void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
        Collections.sort(children, Comparator.comparing((FSElement fselement) -> fselement.getName().charAt(0)));
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){
        LinkedList<FSElement> list = new LinkedList<>(children);
        Collections.sort(list, comparator);
        return list;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator){
        LinkedList<Directory> subDir = new LinkedList<>();
        children.forEach(Node ->{
            if(Node.isDirectory()){
                subDir.add((Directory) Node);
            }
        });
        Collections.sort(subDir, comparator);
        return subDir;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator){
        LinkedList<File> files = new LinkedList<>();
        children.forEach(Node -> {
            if(Node.isFile()){
                files.add((File) Node);
            }
        });
        Collections.sort(files, comparator);
        return files;
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
    public boolean isLink() {
        return false;
    }

    @Override
    public void PlaceHolder() {}



}


