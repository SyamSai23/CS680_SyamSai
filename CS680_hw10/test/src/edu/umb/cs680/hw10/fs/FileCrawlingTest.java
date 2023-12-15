package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUP(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public  void TestFileCrawlingCommand(){
        Directory d1 = fs.getRootDirs().get(0);
        FileCrawling searchCmd = new FileCrawling();
        LinkedList<File> files = searchCmd.execute(d1);
        //visitor.getFiles().get(3) : we will get the BTest.java file . as the FileCrawler will systematically explore the Files and Directories in order .
        assertEquals(7, files.get(3).getSize());
        assertEquals("B.java", files.get(1).getName());
        assertEquals("src", files.get(1).getParent().getName());

        LocalDateTime dateTime = LocalDateTime.of(2023,12,2,11,30);
        assertEquals(dateTime , files.get(0).getCreationTime());
    }

}