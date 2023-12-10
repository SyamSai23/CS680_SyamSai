package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;


import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private  static FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.CreateFS();

    }

    private  String[] dirToStringArray(Directory d){
        String parentName = null;
//        Checking Singleton FileSystem class
        if(d.getParent() != null){
            parentName = d.getParent().getName();
        }
        return new String[]{parentName,d.getName(), String.valueOf(d.getSize()), String.valueOf(d.getCreationTime())};
    }

    @Test
    public void VerifyDirectoryEqualityRoot(){
        String[] expected = {null,"repo", String.valueOf(0), String.valueOf(LocalDateTime.of(2023,12,1,4,15))};
        Directory actual = fs.getRootDirs().get(0);
        assertArrayEquals(expected,dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitysrc(){
        String[] expecetd = {"repo","src", String.valueOf(0), String.valueOf(LocalDateTime.of(2023,12,1,4,15))};
        Directory actual = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assertArrayEquals(expecetd,dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitytest(){
        String[] expecetd = {"repo","test", String.valueOf(0), String.valueOf(LocalDateTime.of(2023,12,1,4,15))};
        Directory actual = fs.getRootDirs().get(0).getSubDirectories().get(1);
        assertArrayEquals(expecetd,dirToStringArray(actual));
    }
    @Test
    void TestgetChildren() {
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : fs.getRootDirs().get(0).getChildren()){
            actual.add(fsElement.getName());
        }
        String[] expected = {"src","test","readme.md"};
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    void TestgetSubDirectories() {
        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d1.getSubDirectories()){
            actual.add(fsElement.getName());
        }
        String[] expected = {"src","test"};

        Arrays.sort(expected);
        String[] actualArray = actual.toArray(new String[0]);
        Arrays.sort(actualArray);

        System.out.println("Expected " + Arrays.toString(expected));
        System.out.println("Acrual "+ Arrays.toString(actualArray));

        assertArrayEquals(expected,actualArray);
    }

    @Test
    void TestgetFiles() {
        Directory d2 = fs.getRootDirs().get(0).getSubDirectories().get(0);
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : d2.getFiles()){
            actual.add(fsElement.getName());
        }
        String[] expected = {"A.java","B.java"};
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    void TestappendChild() {
        Directory d2 = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File f2 = d2.getFiles().get(0);
        assertTrue(d2.getChildren().contains(f2));
    }

    @Test
    void TestcountChildren() {
        Directory d1 = fs.getRootDirs().get(0);
        int expecetd = 3;
        assertEquals(expecetd,d1.getChildren().size());
    }

    @Test
    void TestesTotalSize() {
        Directory d1 = fs.getRootDirs().get(0);
        System.out.println(d1.getTotalSize());
        int expecetd = 24;
        assertEquals(expecetd,d1.getTotalSize());
    }


    @Test
    void TestisDirectory() {
        Directory d1 = fs.getRootDirs().get(0);
        Directory d2 = d1.getSubDirectories().get(0);
        Directory d3 = d1.getSubDirectories().get(1);
        assertTrue(d1.isDirectory());
        assertTrue(d2.isDirectory());
        assertTrue(d3.isDirectory());
    }
}