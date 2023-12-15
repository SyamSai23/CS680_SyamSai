package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

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

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e : children){
            e.accept(v);
        }
    }


    public LinkedList<FSElement> getChildren(){
        return this.children;
    }
    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subDir = new LinkedList<Directory>();
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
        LinkedList<File> files = new LinkedList<File>();
        for(FSElement Node :this.children){
            if(Node.isFile()){
                files.add((File) Node);
            }
        }
        return files;
    }

    public LinkedList<Link> getLink(){
        LinkedList<Link>  links = new LinkedList<>();
        for(FSElement Node: this.children){
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
    public void PlaceHolder() {}

    public static void main(String[] args){

        LocalDateTime date1 = LocalDateTime.of(2023,12,1,4,15);
        LocalDateTime date2 = LocalDateTime.of(2023,12,2,11,30);

        Directory d1 = new Directory(null,"repo",0,date1);

        Directory d2 = new Directory(d1,"src",0,date1);

        Directory d3 = new Directory(d1,"test",0,date1);

        File f1 = new File(d1,"readme.md",3,date2);
        File f2 = new File(d2,"A.java",4,date2);
        File f3 = new File(d2,"B.java",5,date2);
        Directory d4 = new Directory(d3,"src",0,date1);
        File f4 = new File(d4,"ATest.java",5,date2);
        File f5 = new File(d4, "BTest.java",7,date2);

        Link l1 = new Link(d4,"rm.md",0,date2,f1);
        FileSearch search = new FileSearch("readme.m");
        for(File f: search.execute(d1)){
            System.out.println(f.name);
        }

        FileCrawling searchcmd = new FileCrawling();
        for(File f : searchcmd.execute(d2)){
            System.out.println(f.getSize());
        }

        Counting cmd = new Counting();
        cmd.execute(d1);
        System.out.println(cmd.getDirNum());
        System.out.println(cmd.getFileNum());
        System.out.println(cmd.getLinkNum());


    }

}
