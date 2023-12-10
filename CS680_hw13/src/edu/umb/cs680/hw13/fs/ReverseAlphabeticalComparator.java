package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        return o2.getName().charAt(0) - o1.getName().charAt(0);
    }
}

