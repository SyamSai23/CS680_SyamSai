package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;

public interface FSVisitor {

    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);


}
