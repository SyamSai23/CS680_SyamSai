package edu.umb.cs680.hw8;

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

    private final LinkedList<Directory> RootDir = new LinkedList<>();

    public LinkedList<Directory> getRootDirs(){
        return this.RootDir;

    }

    public void appendRootDir(Directory root){
        this.RootDir.add(root);
    }

}
