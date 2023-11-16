package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    static LocalDateTime date1 = LocalDateTime.now();
    static Directory root = new Directory(null,"Root",0,date1);
    static Directory src = new Directory(root,"src",0,date1);
    static Directory test = new Directory(root,"test",0,date1);
    static File xml = new File(root,"xml",5,date1);
    static File ivy = new File(root,"ivy",6,date1);
    static File java1 = new File(src,"HelloWorld.java",4,date1);
    static File java2 = new File(test,"TestHelloWorld.java",5,date1);

    @BeforeAll
    public static void setUpFS(){
        FileSystem instance = TestFixtureInitializer.createFS();

    }

    private String[] FileToStringArray(File f){

        return new String[]{f.getParent().getName(),f.getName(),
                String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }

    @Test
    public void FileEqualityJava1(){
        String[] expected = {"src", "HelloWorld.java", "4", String.valueOf(date1)};
        File actual = java1;
        assertArrayEquals(expected, FileToStringArray(actual));
    }



    @Test
    public void TestIsDirectoryReturnsFalse(){
        assertFalse(java1.isDirectory());
    }


}