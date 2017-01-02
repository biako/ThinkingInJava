package tij.array.utilities;

import java.util.Arrays;
import java.util.Comparator;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p559-560
 *
 * Two ways of comparison in Java:
 *
 * (1) Implementation of Comparable:
 *      See CompType.java
 *
 * (2) Using a type-specific comparator that implements java.util.Comparator:
 *      See ComparatorTest.java in this example.
 *
 *  a. Create a type-specific comparator that implements java.util.Comparator
 *
 *  b. Override public int compare(Type o1, Type o2)
 *      Three ways: 1. A separate class; 2. anonymous inner class; 3. lambda expression.
 *
 *  c. Using the Java standard library method Arrays.sort(Type a, Comparator<Type> c ).
 *
 */
class CompTypeComparator implements Comparator<CompType> {
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = array(
                new CompType[12], CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));

        // Using a separate class
        Arrays.sort(a, new CompTypeComparator());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));

        // Using an anonymous inner class
        Arrays.sort(a, new Comparator<CompType>() {
            @Override
            public int compare(CompType o1, CompType o2) {
                return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
            }
        });

        // Using lambda
        Arrays.sort(a, (o1, o2) -> (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1)));
    }
}
