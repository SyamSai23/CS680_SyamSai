package edu.umb.cs680.hw13.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest {

    private static FileSystem fs;
    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestDefaultAlphabeticalSorting(){
        Directory d1 = fs.getRootDirs().get(0);
//         In Default the elements are sorted in Alphabetical order
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : d1.getChildren()){
            actual.add(fsElement.getName());
        }
        System.out.println(actual);
        String[] expected = {"readme.md","src","test"};
        assertArrayEquals(expected, actual.toArray());
    }

}