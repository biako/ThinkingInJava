package tij.array.utilities;

import tij.generics.genericinterface.Generator;

import java.util.Arrays;
import java.util.Random;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p557
 *
 * Two ways of comparison in Java:
 *
 * (1) Implementation of Comparable:
 *      See CompType.java in this example.
 *
 * a. The class implements java.lang.Comparable, which has only a single method, compareTo( );
 *
 * b. Override public int compareTo(Type rv);
 *
 *     (current < compared ? -1 : (current == compared 0 : 1))
 *
 *      This method takes another object of the same type as an argument and produces:
 *      - a negative value if the current object is less than the argument,
 *      - zero if the argument is equal, and
 *      - a positive value if the current object is greater than the argument.
 *
 * c. Using the Java standard library method Arrays.sort(Object[] a).
 *
 *      public class Type implements Comparable<Type>{
 *          // e.g. private int i;
 *          @ Override
 *          public int compareTo(Type rv) {
 *              return (______ ? -1 : (_______? 0 : 1));
 *              // e.g. comparing the i value, like:
 *              // return (i < rv.i ? -1 : (i== rv.i ? 0 : 1))
 *          }
 *      }
 *
 *      For arrays, then use Arrays.sort(Object[] a):
 *
 * (2) Using a type-specific comparator that implements java.util.Comparator:
 *      See ComparatorTest.java
 *
 *  a. Create a type-specific comparator that implements java.util.Comparator
 *
 *  b. Override public int compare(Type o1, Type o2)
 *      Three ways: 1. A separate class; 2. anonymous inner class; 3. lambda expression.
 *
 *  c. Using the Java standard library method Arrays.sort(Type a, Comparator<Type> c ).
 *
 *
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;

    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }

    private static Random r = new Random(47);

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        // Use public static <T> T[] array(T[] a, Generator<T> gen) to fill an array.
        CompType[] a =
                array(new CompType[12], generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));

        // Sort:
        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}