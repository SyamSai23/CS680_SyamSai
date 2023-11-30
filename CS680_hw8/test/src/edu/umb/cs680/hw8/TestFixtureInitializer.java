package edu.umb.cs680.hw8;

import java.time.LocalDateTime;

public class TestFixtureInitializer {


    public  static FileSystem CreateFS(){
        FileSystem fs = FileSystem.getFileSystem();
        LocalDateTime date1 = LocalDateTime.of(2023,12,1,4,15);
        LocalDateTime date2 = LocalDateTime.of(2023,12,2,11,30);
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


        return  fs;
    }
}
