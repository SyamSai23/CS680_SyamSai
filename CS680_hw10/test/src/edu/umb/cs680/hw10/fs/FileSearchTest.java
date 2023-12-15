package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUP(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestBTestJavaUsingCommand(){
        Directory d1 = fs.getRootDirs().get(0);
        FileSearch searchCmd = new FileSearch("BTest.java");
        LinkedList<File> files = searchCmd.execute(d1);
        assertEquals(1, files.size());

//        if you search a file from another directory , the file will not be found in that particular directory.
        Directory d2 = fs.getRootDirs().get(1);
        FileSearch cmd = new FileSearch("BTest.java");
        LinkedList<File> res = cmd.execute(d2);
        assertEquals(0, res.size());
    }

}