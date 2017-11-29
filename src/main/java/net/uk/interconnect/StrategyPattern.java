package net.uk.interconnect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 */
public class StrategyPattern {

    public static void main(String[] args) {

        String[] names = {"Hillary", "Jeb", "Marco", "Donald Trump", "Bernie"};
        List<String> list = Arrays.asList(names);
        System.out.println("before sort: " + list);

        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.equals("Donald Trump") && !o2.equals("Donald Trump"))
                    return -1;
                else if (o2.equals("Donald Trump") && !o1.equals("Donald Trump"))
                    return 1;
                else
                    return o1.compareTo(o2);
            }
        });

        System.out.println("after sort: " + list);
    }
}
