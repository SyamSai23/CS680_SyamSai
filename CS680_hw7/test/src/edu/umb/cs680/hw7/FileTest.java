package edu.umb.cs680.hw7;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setUpFS(){
         fs = TestFixtureInitializer.CreateFS();

    }

    private String[] FileToStringArray(File f){

        return new String[]{f.getParent().getName(),f.getName(),
                String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }

    @Test
    public void FileEqualityJava1(){
        Directory d2 = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File f2 = d2.getFiles().get(0);
        String[] expected = {"src", "A.java", "4", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        assertArrayEquals(expected, FileToStringArray(f2));
    }

    @Test
    public void FileEqualityReadme(){
        Directory d1 = fs.getRootDirs().get(0);
        File f1 = d1.getFiles().get(0);
        String[] expected = {"repo", "readme.md", "3", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        assertArrayEquals(expected, FileToStringArray(f1));
    }

    @Test
    public void FileEqualityAJava(){
        Directory d2 = fs.getRootDirs().get(1);
        File f2 = d2.getFiles().get(0);
        String[] expected = {"src", "A.java", "4", String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
        assertArrayEquals(expected, FileToStringArray(f2));
    }

    @Test
    public void FileEqualityATestJava(){
        Directory d4 = fs.getRootDirs().get(2).getSubDirectories().get(0);
        File f3 = d4.getFiles().get(0);
        String[] expected = {"src","ATest.java","5",String.valueOf(LocalDateTime.of(2023,12,2,11,30))};
    }

    @Test
    public void TestIsDirectoryReturnsFalse(){
        Directory d2 = fs.getRootDirs().get(0).getSubDirectories().get(0);
        File f2 = d2.getFiles().get(0);
        assertFalse(f2.isDirectory());
    }


}