package edu.umb.cs680.hw17.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {
// Changing External Iterations with Internal Iterations . using "foreach" method.
    private  static FileSystem fs;

    @BeforeAll
    public static void setUp(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestGetChildrenDefaultAlphabeticalComparatorWithInternalIteration(){
        Directory d1  = fs.getRootDirs().get(0);

        LinkedList<String> actual = new LinkedList<>();
        d1.getChildren().forEach(child -> actual.add(child.getName()));
        String[] expected = {"readme.md","src","test"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestGetSubDirectoriesDefaultAlphabeticalComparatorWithInternalIteration(){
        Directory d1 = fs.getRootDirs().get(0);

        LinkedList<String> actual = new LinkedList<>();
        d1.getSubDirectories().forEach(child -> actual.add(child.getName()));
        String[] expected = {"src","test"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestGetFilesDefaultAlphabeticalComparatorWithInternalIteration(){
        Directory d2 = fs.getRootDirs().get(1);

        LinkedList<String> actual = new LinkedList<>();
        d2.getFiles().forEach(child -> actual.add(child.getName()));
        String[] expected = {"A.java","B.java"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestElementBasedSortingWithLEUsingInternalIteration(){
        Comparator<FSElement> comparator = Comparator.comparing( (FSElement fs) -> {
            if(fs.isDirectory()) return  0;
            else if (fs.isFile()) {
                return 1;
            }
            else  return 2;
        } ).thenComparing(fs -> fs.getName().charAt(0));

        Directory d1 = fs.getRootDirs().get(0);

        LinkedList<String> actual = new LinkedList<>();
        d1.getChildren(comparator).forEach(child -> actual.add(child.getName()));
        String[] expected = {"src","test","readme.md"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestReverseAlphabeticalSortingWithLEUsingInternalIteration(){
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getName, Comparator.reverseOrder() );
        Directory d1 = fs.getRootDirs().get(0);

        LinkedList<String> actual = new LinkedList<>();

        d1.getChildren(comparator).forEach(child -> actual.add(child.getName()));

        String[] expected = {"test","src","readme.md"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestSizeBasedSortingWithLEUsingInternalIteration(){
        Comparator<FSElement> comparator = (o1, o2) -> o2.getSize() - o1.getSize();
        Directory d2  = fs.getRootDirs().get(1);

        LinkedList<String> actual = new LinkedList<>();
        d2.getChildren(comparator).forEach(child -> actual.add(child.getName() + child.getSize()));
        String[] expected = {"B.java5","A.java4"};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void TestTimeStampBasedSortingWithLEUsingInternalIteration(){
        Comparator<FSElement> comparator = Comparator.comparing(FSElement::getCreationTime);
        Directory d1 = fs.getRootDirs().get(0);

        LinkedList<String> actual = new LinkedList<>();

        d1.getChildren(comparator).forEach(child -> actual.add(child.getName()));
        String[] expected = {"src","readme.md","test"};
        assertArrayEquals(expected, actual.toArray());
    }


}