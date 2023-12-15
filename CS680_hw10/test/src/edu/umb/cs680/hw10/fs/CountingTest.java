package edu.umb.cs680.hw10.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingTest {


    private static FileSystem fs;

    @BeforeAll
    public static void setUP(){
        fs = TestFixtureInitializer.createFS();
    }

    @Test
    public void TestCountingCommand(){
        Directory d1 = fs.getRootDirs().get(0);
        Counting searchCmd = new Counting();
        searchCmd.execute(d1);

        assertEquals(4, searchCmd.getDirNum());
        assertEquals(5, searchCmd.getFileNum());
        assertEquals(1, searchCmd.getLinkNum());

        Directory d3 = fs.getRootDirs().get(2);
        Counting cmd = new Counting();
        cmd.execute(d3);
        assertEquals(2,cmd.getDirNum());
        assertEquals(2, cmd.getFileNum());
        assertEquals(1, cmd.getLinkNum());
    }

}