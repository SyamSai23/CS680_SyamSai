package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.time.LocalDateTime;

public class TestFixtureInitializer {

    private  static FileSystem instance;
    public static FileSystem createFS() {
        LocalDateTime date1 = LocalDateTime.now();
        Directory root = new Directory(null,"Root",0,date1);
        Directory src = new Directory(root,"src",0,date1);
        Directory test = new Directory(root,"test",0,date1);
        File xml = new File(root,"xml",5,date1);
        File ivy = new File(root,"ivy",6,date1);
        File java1 = new File(src,"HelloWorld.java",4,date1);
        File java2 = new File(test,"TestHelloWorld.java",5,date1);

        return instance;
    }
//
//    @BeforeAll
//    public static void setUpFS() throws IOException{
//        fs = createFS();
//    }
//
//    public static FileSystem getFileSystem(){
//        return FileSystem.getFileSystem();
//    }


}
