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
        fs = FileSystem.getFileSystem();
        assertNotNull(FileSystem.getFileSystem(), "NOT NULL");
    }



    @Test
    public void TeatAppendRootDir(){
        fs = FileSystem.getFileSystem();
        Directory root = new Directory(null,"Root",0, LocalDateTime.now());
        fs.appendRootDir(root);
        assertTrue(fs.getRootDirs().contains(root));
    }


}