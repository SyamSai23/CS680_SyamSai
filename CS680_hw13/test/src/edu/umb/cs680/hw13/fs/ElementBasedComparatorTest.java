package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.ElementBasedComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ElementBasedComparatorTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestElementBasedComparatorForRepoDir(){
        Directory d1  = fs.getRootDirs().get(0);

        LinkedList<String> beforesorting = new LinkedList<>();
        for(FSElement fsElement : d1.getChildren()){
            beforesorting.add(fsElement.getName());
        }
        System.out.println("Element before Element Based Sorting : "+ beforesorting);

        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement : d1.getChildren(new ElementBasedComparator())){
            actual.add(fsElement.getName());
        }
        System.out.println("Elemnts after Element based sorting :" + actual);
        String[] expected = {"src","test","readme.md"};
        assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public  void TestElementBasedComparatorForTestDir(){
        Directory d4 = fs.getRootDirs().get(2).getSubDirectories().get(0);
        LinkedList<String> actual = new LinkedList<>();

        for(FSElement fsElement : d4.getChildren(new ElementBasedComparator())){
            actual.add(fsElement.getName());
        }
        String[] expecetd = {"ATest.java","BTest.java","rm.md"};
        assertArrayEquals(expecetd, actual.toArray());
    }

}