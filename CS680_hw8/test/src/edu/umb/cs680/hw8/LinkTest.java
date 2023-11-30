package edu.umb.cs680.hw8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setFs(){
        fs = TestFixtureInitializer.CreateFS();


    }
    @Test
    public  void TestLinkCreationAndDeletion(){
        Directory src = fs.getRootDirs().get(0).getSubDirectories().get(0);
        Directory test = fs.getRootDirs().get(0).getSubDirectories().get(1);
        File java1 = src.getFiles().get(0);
        File java2 = test.getFiles().get(0);
        Link J = new Link(src,"HelloWorld",4, LocalDateTime.now(),java1);
        Link K = new Link(test,"TestHelloWorld",5, LocalDateTime.now(),java2);
        assertNotNull(J);
        System.out.println(J.name);
        System.out.println(J.isFile());
//        Checking if the link corrsponds to correct Target or not .
        assertEquals(java1, J.getTarget());
//        The size of the link will be 0.
        assertEquals(0, J.getSize());
//      Checking the deletion of the link.
        assertTrue(src.getChildren().contains(J));
        J.removeLink();
        assertFalse(src.getChildren().contains(J));
//        Checking if the target element remains same even after deleting the link.
        assertTrue(src.getChildren().contains(java1));

    }


}