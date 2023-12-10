package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getSize() - o1.getSize();
    }


}

