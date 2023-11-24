package edu.umb.cs680.hw8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static edu.umb.cs680.hw8.TestFixtureInitializer.date2;
import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private static FileSystem fs;
    @BeforeAll
    public static void setFs(){
        fs = TestFixtureInitializer.createFS();
    }

    private String[] FileToStringArray(File f){

        return new String[]{f.getParent().getName(),f.getName(),
                String.valueOf(f.getSize()), String.valueOf(f.getCreationTime())};
    }

    @Test
    public void FileEqualityJava1(){
        File java1 = TestFixtureInitializer.java1;
        String[] expected = {"src", "HelloWorld", "4", String.valueOf(date2)};
        File actual = java1;
        assertArrayEquals(expected, FileToStringArray(actual));
    }

    @Test
    public void TestIsDirectoryReturnsFalse(){
        File java1 = TestFixtureInitializer.java1;
        assertFalse(java1.isDirectory());
    }

}