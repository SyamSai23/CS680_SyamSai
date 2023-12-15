package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

import java.util.LinkedList;

public class FileCrawling implements FSCommand{



    @Override
    public LinkedList<File> execute(Directory rootDir) {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        rootDir.accept(visitor);
        return visitor.getFiles();
    }
}
