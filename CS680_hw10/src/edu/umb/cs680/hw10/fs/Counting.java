package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.CountingVisitor;

import java.util.LinkedList;

public class Counting implements FSCommand{

    private int dirNum;
    private int FileNum;
    private int LinkNum;
    @Override
    public LinkedList<File> execute(Directory rootDir) {
        CountingVisitor visitor = new CountingVisitor();
        rootDir.accept(visitor);
        dirNum = visitor.getDirNum();
        FileNum = visitor.getFileNum();
        LinkNum = visitor.getLinkNum();
        return null;

    }

    public  int getDirNum(){
        return dirNum;
    }
    public  int getFileNum(){
        return FileNum;
    }
    public int getLinkNum(){
        return LinkNum;
    }

}
