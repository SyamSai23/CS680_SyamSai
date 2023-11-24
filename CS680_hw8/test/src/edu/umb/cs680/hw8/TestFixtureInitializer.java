package edu.umb.cs680.hw8;

import java.time.LocalDateTime;

public class TestFixtureInitializer {
    public static Directory root;
    public static Directory src;
    public static Directory test;
    public static File xml;
    public static File ivy;
    public static File java1;
    public static File java2;
    static LocalDateTime date1;
    static LocalDateTime date2;


    public  static FileSystem createFS(){
        FileSystem fs = FileSystem.getFileSystem();
        LocalDateTime date1 = LocalDateTime.now();
        LocalDateTime date2 = LocalDateTime.now();
        Directory root = new Directory(null,"root",0,date1);
        fs.appendRootDir(root);
        Directory src = new Directory(root,"src",0,date1);
        fs.getRootDirs().add(src);
        Directory test = new Directory(root,"test",0,date1);
        fs.getRootDirs().add(test);
        File xml = new File(root,"xml",3,date2);
        File ivy = new File(root,"ivy",4,date2);
        File java1 = new File(src,"HelloWorld",4,date2);
        File java2 = new File(test,"TestHelloWorld",5,date2);

        TestFixtureInitializer.root = root;
        TestFixtureInitializer.src = src;
        TestFixtureInitializer.test = test;
        TestFixtureInitializer.xml = xml;
        TestFixtureInitializer.ivy = ivy;
        TestFixtureInitializer.java1 = java1;
        TestFixtureInitializer.java2 = java2;
        TestFixtureInitializer.date1 = date1;
        TestFixtureInitializer.date2 = date2;
        return  fs;
    }
}
