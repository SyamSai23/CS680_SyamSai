package edu.umb.cs680.hw09.fs;
import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    private  static FileSystem fs;

    @BeforeAll
    public static void setUP(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestCountingVisitor(){
        Directory d1  = fs.getRootDirs().get(0);
        CountingVisitor visitor = new CountingVisitor();
//      Counting Files, Directories and Links in repo Directory.
        d1.accept(visitor);
        assertEquals(4, visitor.getDirNum());
        assertEquals(5, visitor.getFileNum());
        assertEquals(1, visitor.getLinkNum());

        Directory d3 = fs.getRootDirs().get(2);
        CountingVisitor visitor1 = new CountingVisitor();
//      Counting Files, Directories and Links in test Directory.
        d3.accept(visitor1);
        assertEquals(2, visitor1.getDirNum());
        assertEquals(2, visitor1.getFileNum());
        assertEquals(1, visitor1.getLinkNum());



    }

}