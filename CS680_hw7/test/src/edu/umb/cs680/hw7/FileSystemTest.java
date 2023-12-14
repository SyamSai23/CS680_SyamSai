package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
         fs= TestFixtureInitializer.CreateFS();
    }

    @Test
    public void TestSingletonReturnsNOnNullValue(){
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();

        assertSame(fs1, fs2, "Instance should be the same ");
    }

    @Test
    public void TeatAppendRootDir(){
        fs = FileSystem.getFileSystem();
        Directory d1 = new Directory(null,"repo",0, LocalDateTime.now());
        fs.appendRootDir(d1);
        assertTrue(fs.getRootDirs().contains(d1));
        assertEquals(fs.hashCode(), fs.getFileSystem().hashCode());
    }


}