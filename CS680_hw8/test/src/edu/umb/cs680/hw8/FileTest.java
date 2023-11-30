package edu.umb.cs680.hw8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setFs(){
        fs = TestFixtureInitializer.CreateFS();
    }

    private String[] FileToStringArray(File f){

        return new String[]{f.getParent().getName(),f.getName(),
                String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }

    @Test
    public void FileEqualityJava1(){
        Directory src = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File java1 = src.getFiles().get(0);
        String[] expected = {"src", "HelloWorld", "4", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        File actual = java1;
        assertArrayEquals(expected, FileToStringArray(actual));
    }

    @Test
    public void TestIsDirectoryReturnsFalse(){
        Directory src = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File java1 = src.getFiles().get(0);
        assertFalse(java1.isDirectory());
    }

}