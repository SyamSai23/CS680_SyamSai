package edu.umb.cs680.hw8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setFs(){
        fs = TestFixtureInitializer.createFS();


    }
    @Test
    public  void TestLinkCreationAndDeletion(){
        Directory src = TestFixtureInitializer.src;
        File java1 = TestFixtureInitializer.java1;
        Link J = new Link(src,"HelloWorld",4, LocalDateTime.now(),java1);
        assertNotNull(J);
        System.out.println(J.name);
//        CHecking if the link corrsponds to correct Target or not . 
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