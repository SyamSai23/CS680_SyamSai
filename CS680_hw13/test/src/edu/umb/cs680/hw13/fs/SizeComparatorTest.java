package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.SizeComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SizeComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestSizeComparatorForRepoDir(){
        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d1.getChildren(new SizeComparator())){
            actual.add(fsElement.getName() );
        }
        String[] expected = {"readme.md","src","test"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestSizeComparatorForSrcDir(){
        Directory d2 = fs.getRootDirs().get(1);
        LinkedList<String> beforeSorting = new LinkedList<>();
        for(FSElement fsElement: d2.getChildren()){
            beforeSorting.add(fsElement.getName() );
        }
        System.out.println("Elements before SizeBased Sorting : " + beforeSorting );
//      After SizeBased Sorting we will get Files and Directories which have more size First .
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d2.getChildren(new SizeComparator())){
            actual.add(fsElement.getName());
        }
        System.out.println("Elements after SizeBased Sorting : " + actual);
        String[] expected = {"B.java","A.java"};
        assertArrayEquals(expected,actual.toArray());
    }

}