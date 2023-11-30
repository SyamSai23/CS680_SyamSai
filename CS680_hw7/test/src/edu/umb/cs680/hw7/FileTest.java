package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
         fs = TestFixtureInitializer.CreateFS();

    }

    private String[] FileToStringArray(File f){

        return new String[]{f.getParent().getName(),f.getName(),
                String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }

    @Test
    public void FileEqualityJava1(){
        Directory src = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File java1 = src.getFiles().get(0);
        String[] expected = {"src", "HelloWorld", "4", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        assertArrayEquals(expected, FileToStringArray(java1));
    }

    @Test
    public void FileEqualityXml(){
        Directory root = fs.getRootDirs().get(0);
        File xml = root.getFiles().get(0);
        String[] expected = {"root", "xml", "3", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        assertArrayEquals(expected, FileToStringArray(xml));
    }

    @Test
    public void FileEqualityIvy(){
        Directory root = fs.getRootDirs().get(0);
        File ivy = root.getFiles().get(1);
        String[] expected = {"root", "ivy", "4", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        assertArrayEquals(expected, FileToStringArray(ivy));
    }

    @Test
    public void TestIsDirectoryReturnsFalse(){
        Directory src = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File java1 = src.getFiles().get(0);
        assertFalse(java1.isDirectory());
    }


}