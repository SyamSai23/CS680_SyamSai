package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    static FileSystem fs = FileSystem.getFileSystem();
    static LocalDateTime date1 = LocalDateTime.now();
    static LocalDateTime date2 = LocalDateTime.now();
    static Directory root = new Directory(null,"root",0,date1);
    static Directory src = new Directory(root,"src",0,date1);
    static Directory test = new Directory(root,"test",0,date1);
    static File xml = new File(root,"xml",3,date2);
    static File ivy = new File(root,"ivy",4,date2);
    static File java1 = new File(src,"HelloWorld",4,date2);
    static File java2 = new File(test,"TestHelloWorld",5,date2);


    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
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
        String[] expected = {null,"root", String.valueOf(0), String.valueOf(date1)};
        Directory actual = root;
        assertArrayEquals(expected,dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitysrc(){
        String[] expecetd = {"root","src", String.valueOf(0), String.valueOf(date1)};
        Directory actual = src;
        assertArrayEquals(expecetd,dirToStringArray(actual));
    }

    @Test
    void TestgetChildren() {
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : root.getChildren()){
            actual.add(fsElement.getName());
        }
        String[] expecetd = {"src","test","xml","ivy"};
        assertArrayEquals(expecetd,actual.toArray());
    }

    @Test
    void TestgetSubDirectories() {
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : root.getSubDirectories()){
            actual.add(fsElement.getName());
        }
        String[] expected = {"src","test"};
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    void TestgetFiles() {
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : src.getFiles()){
            actual.add(fsElement.getName());
        }
        String[] expected = {"HelloWorld"};
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    void TestappendChild() {
//        src.appendChild(java1);
        assertTrue(src.getChildren().contains(java1));
    }

    @Test
    void TestcountChildren() {
       int expecetd = 4;
       assertEquals(expecetd,root.getChildren().size());
    }

    @Test
    void TestesTotalSize() {
        int expecetd = 16;
        assertEquals(expecetd,root.getTotalSize());
    }

    @Test
    void TestisDirectory() {
        assertTrue(root.isDirectory());
        assertTrue(src.isDirectory());
        assertTrue(test.isDirectory());
    }
}