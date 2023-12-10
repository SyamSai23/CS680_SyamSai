package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.ReverseAlphabeticalComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAlphabeticalComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestReverseAlphabeticalComparatorForRepoDir(){
        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> beforesorting = new LinkedList<>();
        for(FSElement fsElement : d1.getChildren()){
            beforesorting.add(fsElement.getName());
        }
        System.out.println("Elements before sorting : "+ beforesorting);

        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : d1.getChildren(new ReverseAlphabeticalComparator())){
            actual.add(fsElement.getName());
        }

        System.out.println("Elements after Reverse Alphabetical sorting : " + actual);
        String[] expecetd = {"test","src","readme.md"};
        assertArrayEquals(expecetd, actual.toArray());
    }

    @Test
    public void TestReverseAlphabeticalComparatorForTestDir(){
        Directory d4  = fs.getRootDirs().get(2).getSubDirectories().get(0);
        LinkedList<String> actual =new LinkedList<>();

        for(FSElement fsElement : d4.getChildren(new ReverseAlphabeticalComparator())){
            actual.add(fsElement.getName());
        }

        String[] expecetd = {"rm.md","BTest.java","ATest.java"};
        assertArrayEquals(expecetd, actual.toArray());
    }
}