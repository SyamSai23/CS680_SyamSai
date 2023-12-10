package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class ElementBasedComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement o1, FSElement o2) {
        if(o1.isDirectory() && o2.isFile())
            return -1;
        else if (o1.isFile() && o2.isLink()) {
            return -1;
        } else if (o1.isLink() && o2.isDirectory()) {
            return 1;
        }
        else
            return o1.getName().charAt(0) - o2.getName().charAt(0);
    }
}
