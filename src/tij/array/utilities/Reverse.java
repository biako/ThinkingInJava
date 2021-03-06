package tij.array.utilities;

import java.util.Arrays;
import java.util.Collections;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p560
 *
 * An example follows ComparatorTest.java
 *
 * Using Collections.reverseOrder() as the Comparator argument
 * in Arrays.sort()
 *
 */
public class Reverse {

    public static void main(String[] args) {
        CompType[] a = array(
                new CompType[12], CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));

        // Using Collections.reverseOrder() as the Comparator argument
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
