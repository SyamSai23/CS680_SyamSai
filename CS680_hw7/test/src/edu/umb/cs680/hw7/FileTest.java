package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static edu.umb.cs680.hw7.TestFixtureInitializer.date2;
import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
         fs = TestFixtureInitializer.createFS();

    }

    private String[] FileToStringArray(File f){

        return new String[]{f.getParent().getName(),f.getName(),
                String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }

    @Test
    public void FileEqualityJava1(){
        File java1 = TestFixtureInitializer.java1;
        String[] expected = {"src", "HelloWorld", "4", String.valueOf(date2)};
        assertArrayEquals(expected, FileToStringArray(java1));
    }

    @Test
    public void FileEqualityXml(){
        File xml = TestFixtureInitializer.xml;
        String[] expected = {"root", "xml", "3", String.valueOf(date2)};
        assertArrayEquals(expected, FileToStringArray(xml));
    }

    @Test
    public void FileEqualityIvy(){
        File ivy = TestFixtureInitializer.ivy;
        String[] expected = {"root", "ivy", "4", String.valueOf(date2)};
        assertArrayEquals(expected, FileToStringArray(ivy));
    }

    @Test
    public void TestIsDirectoryReturnsFalse(){
        File java1 = TestFixtureInitializer.java1;
        assertFalse(java1.isDirectory());
    }


}