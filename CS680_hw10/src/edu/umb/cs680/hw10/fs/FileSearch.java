package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

import java.util.LinkedList;

public class FileSearch implements FSCommand{

    private  String fileName;

    public FileSearch(String fileName){
        this.fileName = fileName;
    }


    @Override
    public LinkedList<File> execute(Directory rootDir) {
        FileSearchVisitor visitor = new FileSearchVisitor(fileName);
        rootDir.accept(visitor);
        return visitor.getFoundFiles();
    }
}
