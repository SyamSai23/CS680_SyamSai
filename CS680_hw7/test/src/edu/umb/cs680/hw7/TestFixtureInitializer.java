package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.time.LocalDateTime;

public class TestFixtureInitializer {
    private static FileSystem fs;

    public static FileSystem CreateFS() {
        if(fs == null){
            fs = FileSystem.getFileSystem();

            LocalDateTime date1 = LocalDateTime.of(2023,12,1,4,15);
            LocalDateTime date2 = LocalDateTime.of(2023,12,2,11,30);

            Directory d1 = new Directory(null,"repo",0,date1);
            fs.appendRootDir(d1);
            Directory d2 = new Directory(d1,"src",0,date1);
            fs.getRootDirs().add(d2);
            Directory d3 = new Directory(d1,"test",0,date1);
            fs.getRootDirs().add(d3);
            File f1 = new File(d1,"readme.md",3,date2);
            File f2 = new File(d2,"A.java",4,date2);
            File f3 = new File(d2,"B.java",5,date2);
            Directory d4 = new Directory(d3,"src",0,date1);
            File f4 = new File(d4,"ATest.java",5,date2);
            File f5 = new File(d4, "BTest.java",7,date2);
        }
        return fs;
    }



}
