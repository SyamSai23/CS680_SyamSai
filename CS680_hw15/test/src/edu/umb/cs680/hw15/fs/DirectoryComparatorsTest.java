package edu.umb.cs680.hw15.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryComparatorsTest {

    private static  FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestDefaultAlphabeticalSortingWithLE(){
        Directory d1  = fs.getRootDirs().get(0);
//        In Default the elements are sorted in  Alphabetical order
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d1.getChildren()){
            actual.add((fsElement.getName()));
        }

        String[] expected = {"readme.md","src","test"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestElementBasedSortingWithLE(){
// using static method Comparator.comparing in LE to sort FSElements (ElementBased) .
        Comparator<FSElement> comparator = Comparator.comparing((FSElement fs) -> {
            if (fs.isDirectory()) return 0;
            else if (fs.isFile()) {
                return 1;
            }
            else return 2;
        }).thenComparing(fs -> fs.getName().charAt(0));

        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> actual = new LinkedList<>();
        for(FSElement fsElement: d1.getChildren(comparator)){
            actual.add(fsElement.getName());
        }
        String[] expected = {"src","test","readme.md"};
        assertArrayEquals(expected, actual.toArray());

    }

    @Test
    public void TestReverseAlphabeticalSorting(){
        Comparator<FSElement> comparator = Comparator.comparing((FSElement fs) ->fs.getName() , Comparator.reverseOrder());
        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> actual = new LinkedList<>();

        for(FSElement fsElement : d1.getChildren(comparator)){
            actual.add(fsElement.getName());
        }

        String[] expected = {"test","src","readme.md"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestSizeBasedSortingWithLE(){
        Comparator<FSElement> comparator = (o1, o2) -> o2.getSize() - o1.getSize();
        Directory d2 = fs.getRootDirs().get(1);
        LinkedList<String> actual = new LinkedList<>();

        for(FSElement fsElement: d2.getChildren(comparator)){
            actual.add(fsElement.getName());
        }
        String[] expected = {"B.java","A.java"};
        assertArrayEquals(expected, actual.toArray());
    }


    @Test
    public void TestTimeStampBasedSortingWithLE(){
//        To get TimeStamp in ascending order .( First created Directories and Files will be listed first ) .
        Comparator<FSElement> comparator =Comparator.comparing(FSElement::getCreationTime);
        Directory d1 = fs.getRootDirs().get(0);
        LinkedList<String> actual = new LinkedList<>();

        for(FSElement fsElement: d1.getChildren(comparator)){
            actual.add(fsElement.getName());
        }
        String[] expecetd = {"src","readme.md","test"};
        assertArrayEquals(expecetd, actual.toArray());

    }


}