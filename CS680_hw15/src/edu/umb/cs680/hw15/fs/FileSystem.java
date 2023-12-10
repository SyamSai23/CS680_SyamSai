package edu.umb.cs680.hw15.fs;

import java.util.LinkedList;

public class FileSystem {
//    We are making FileSystem class as an Singleton because , we should have only
//    one FileSystem , here FileSystem instance restricts from creating another instance .
    private  static FileSystem instance;

    private FileSystem(){}

    public static FileSystem getFileSystem(){
        if (instance == null){
            instance = new FileSystem();
        }
        return instance;
    }

    private final LinkedList<Directory> rootDir = new LinkedList<>();

    public LinkedList<Directory> getRootDirs(){
        return this.rootDir;

    }

    public void appendRootDir(Directory root){
        this.rootDir.add(root);
    }

}
