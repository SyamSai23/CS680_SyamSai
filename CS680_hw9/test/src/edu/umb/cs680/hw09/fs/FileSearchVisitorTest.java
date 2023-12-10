package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.TestFixtureInitializer;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestBTestJavaFile(){
//       You can search any file from repo directory.
        Directory d1 = fs.getRootDirs().get(0);
        FileSearchVisitor visitor  =new FileSearchVisitor("BTest.java");
        d1.accept(visitor);
        assertEquals(1, visitor.getFoundFiles().size());
//         If you search a File from another directory , the File will not be found in that Directory .
        Directory d2 = fs.getRootDirs().get(1);
        FileSearchVisitor visitor1 = new FileSearchVisitor("BTest.java");
        d2.accept(visitor1);
        assertEquals(0, visitor1.getFoundFiles().size());



    }
}