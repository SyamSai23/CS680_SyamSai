package edu.umb.cs680.hw8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static edu.umb.cs680.hw8.TestFixtureInitializer.date1;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setUP(){
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
        Directory actual = fs.getRootDirs().get(0);
        assertArrayEquals(expected,dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualitysrc(){
        String[] expecetd = {"root","src", String.valueOf(0), String.valueOf(date1)};
        Directory actual = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assertArrayEquals(expecetd,dirToStringArray(actual));
    }
    @Test
    void TestgetChildren() {
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : fs.getRootDirs().get(0).getChildren()){
            actual.add(fsElement.getName());
        }
        String[] expecetd = {"src","test","xml","ivy"};
        assertArrayEquals(expecetd,actual.toArray());
    }

    @Test
    void TestgetSubDirectories() {
        Directory root = TestFixtureInitializer.root;
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : root.getSubDirectories()){
            actual.add(fsElement.getName());
        }
//        System.out.println(fs.getRootDirs().get(0).getSubDirectories().size());
        String[] expected = {"src","test"};

        Arrays.sort(expected);
        String[] actualArray = actual.toArray(new String[0]);
        Arrays.sort(actualArray);

        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actualArray));

        assertArrayEquals(expected,actualArray);

    }

    @Test
    void TestgetFiles() {
        Directory src = TestFixtureInitializer.src;
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : src.getFiles()){
            actual.add(fsElement.getName());
        }
        String[] expected = {"HelloWorld"};
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    void TestappendChild() {
        Directory src = TestFixtureInitializer.src;
        File java1 = TestFixtureInitializer.java1;
        assertTrue(src.getChildren().contains(java1));
    }

    @Test
    void TestcountChildren() {
        Directory root = TestFixtureInitializer.root;
        int expecetd = 4;
        assertEquals(expecetd,root.getChildren().size());
    }

    @Test
    void TestesTotalSize() {
        Directory root = TestFixtureInitializer.root;
        System.out.println(root.getTotalSize());
        int expecetd = 16;
        assertEquals(expecetd,root.getTotalSize());
    }

    @Test
    void TestisDirectory() {
        Directory root = TestFixtureInitializer.root;
        Directory src = TestFixtureInitializer.src;
        Directory test = TestFixtureInitializer.test;
        assertTrue(root.isDirectory());
        assertTrue(src.isDirectory());
        assertTrue(test.isDirectory());
    }

}