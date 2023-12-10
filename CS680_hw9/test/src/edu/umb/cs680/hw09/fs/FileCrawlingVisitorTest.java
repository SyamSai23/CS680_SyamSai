package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.TestFixtureInitializer;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class FileCrawlingVisitorTest {

    private  static FileSystem fs;

    @BeforeAll
    public static void setUP(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestFileCrawlingVisitor(){
///      The Visitor will visit all the Files  in repo Directory and records information such as name
//        size and creation time , Owner's name etc.
        Directory d1  = fs.getRootDirs().get(0);
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        d1.accept(visitor);
//       visitor.getFiles().get(3) : we will get the BTest.java file . as the FileCrawler will systematically explore the Files and Directories in order .
        assertEquals(7, visitor.getFiles().get(3).getSize());
        assertEquals("B.java", visitor.getFiles().get(1).getName());
        assertEquals("src", visitor.getFiles().get(1).getParent().getName());

        LocalDateTime dateTime = LocalDateTime.of(2023,12,2,11,30);
        assertEquals(dateTime, visitor.getFiles().get(0).getCreationTime());

    }

}