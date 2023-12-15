package edu.umb.cs680.hw10.fs;

import java.util.LinkedList;

public interface FSCommand {
    public LinkedList<File> execute(Directory rootDir);

}

