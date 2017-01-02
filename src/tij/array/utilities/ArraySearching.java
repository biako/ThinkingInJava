package tij.array.utilities;

import tij.array.generator.ConvertTo;
import tij.array.generator.RandomGenerator;
import tij.generics.genericinterface.Generator;

import java.util.Arrays;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p561
 *
 * Once an array is sorted, you can perform a fast search
 * for a particular item by using Arrays.binarySearch( ).
 * However, if you try to use binarySearchC ) on an unsorted
 * array the results will be unpredictable. The following
 * example uses a RandomGenerator.Integer to fill an array,
 * and then uses the same generator to produce search values
 *
 *
 */
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen =
                new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(
                array(new Integer[25], gen));
        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));

        // In the while loop, random values are generated as search items until one of them is found.
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                System.out.println("Location of " + r + " is " + location +
                        ", a[" + location + "] = " + a[location]);
                break; // Out of while loop
            }
        }
    }
}
