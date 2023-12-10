package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.TimeStampComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TimeStampComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public  static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestTimeStampComparatorForRepoDir(){
        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> beforeSorting  = new LinkedList<>();
        for(FSElement fsElement:d1.getChildren()){
            beforeSorting.add(fsElement.getName());
        }
        System.out.println("Elements before TimeStamp Sorting : "+ beforeSorting);
//      After sorting, we will get First created Files and Directories.
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d1.getChildren(new TimeStampComparator())){
            actual.add(fsElement.getName());
        }

        String[] expected = {"src","readme.md","test"};
        assertArrayEquals(expected, actual.toArray());
        System.out.println("Elements after TimeStamp Sorting " + actual);
    }

    @Test
    public void TestTimeStampComparatorForSrcDir(){
        Directory d2 = fs.getRootDirs().get(1);
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d2.getChildren(new TimeStampComparator())){
            actual.add(fsElement.getName());
        }
        String[] expected = {"A.java","B.java"};
        assertArrayEquals(expected, actual.toArray());
    }

}