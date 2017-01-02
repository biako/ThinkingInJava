package tij.array.utilities;

import tij.array.generator.RandomGenerator;

import java.util.Arrays;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 * <p>
 * Thinking in Java p561
 */
public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = array(new String[30],
                new RandomGenerator.String(5));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa, sa[10],
                String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: " + index + "\n" + sa[index]);
    }
}
