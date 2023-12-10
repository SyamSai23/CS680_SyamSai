package edu.umb.cs680.hw17.fs.util;

import edu.umb.cs680.hw17.fs.Directory;
import edu.umb.cs680.hw17.fs.FSVisitor;
import edu.umb.cs680.hw17.fs.File;
import edu.umb.cs680.hw17.fs.Link;

import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {
    private final LinkedList<File> files = new LinkedList<File>();
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        files.add(file);
    }

    public LinkedList<File> getFiles(){
        return files;
    }
}
