package tij.array.utilities;

import java.util.*;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p556-557
 *
 * Comparing arrays using Arrays.equals(Object[] a, Object[] a2):
 *
 *      public static boolean equals(Object[] a, Object[] a2)
 *
 * Arrays provides the equals( ) method to compare entire
 * arrays for equality, which is overloaded for all the primitives and for Object.
 *
 * (For primitives, that primitive’s wrapper class equals( )
 * is used; for example, Integer.equals( ) for int.)
 */
public class ComparingArrays {
    public static void main(String[] args) {
        // Primitives:
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        System.out.println(Arrays.equals(a1, a2));

        a2[3] = 11;
        System.out.println(Arrays.equals(a1, a2));

        // Objects:
        String[] s1 = new String[4];
        Arrays.fill(s1, "Hi");
        String[] s2 = {new String("Hi"), new String("Hi"),
                new String("Hi"), new String("Hi")};
        System.out.println(Arrays.equals(s1, s2));
    }
}