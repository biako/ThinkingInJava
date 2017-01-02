package tij.array.utilities;

import tij.array.generator.RandomGenerator;

import java.util.*;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p560
 *
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = array(new String[20],
                new RandomGenerator.String(5));
        System.out.println("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);

        System.out.println("After sort: " + Arrays.toString(sa));

        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println("Reverse sort: " + Arrays.toString(sa));

        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(sa));
    }
}