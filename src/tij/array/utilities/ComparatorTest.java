package tij.array.utilities;

import java.util.Arrays;
import java.util.Comparator;

import static tij.array.generator.GeneratedArray.array;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p559-560
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
        Arrays.sort(a, new CompTypeComparator());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
