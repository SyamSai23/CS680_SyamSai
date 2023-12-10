package edu.umb.cs680.hw8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setFs(){
        fs = TestFixtureInitializer.CreateFS();


    }
    @Test
    public  void TestLinkCreationAndDeletion(){
        Directory d4 = fs.getRootDirs().get(2).getSubDirectories().get(0);
        Link l1 = d4.getLink().get(0);
        assertNotNull(l1);
        System.out.println(l1.name);
        System.out.println(l1.isFile());
//        Checking if the link corresponds to correct Target or not .
        assertEquals("readme.md", l1.getTarget().name);
//        The size of the link will be 0.
        assertEquals(0, l1.getSize());
//      Checking the deletion of the link.
        assertTrue(d4.getChildren().contains(l1));
        l1.removeLink();
        assertFalse(d4.getChildren().contains(l1));
//        Checking if the target element remains same even after deleting the link.
        Directory d1 = fs.getRootDirs().get(0);
        File f1 = fs.getRootDirs().get(0).getFiles().get(0);
        assertTrue(d1.getChildren().contains(f1));

    }


}