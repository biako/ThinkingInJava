package tij.container2.sets;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p589-590
 *
 * I. Use the SortedSet interface for TreeSet:
 * SortedSet<T> sortedSet = new TreeSet<>();
 *
 * II. An ordered Set backed by a tree. This way, you can extract an ordered
 * sequence from a Set. Elements must also implement the Comparable interface.
 *
 * III. Methods under the SortedSet interface:
 *
 * Comparator comparator(): Produces the Comparator used for this Set, or null for natural ordering.
 *
 * Object first(): Produces the lowest element.
 *
 * Object last(): Produces the highest element.
 *
 * SortedSet subSet(fromElement, toElement): Produces a view of this Set with elements from fromElement, inclusive, to toElement, exclusive.
 *
 * SortedSet headSet(toElement): Produces a view of this Set with elements less than toElement.
 *
 * SortedSet tailSet(fromElement): Produces a view of this Set with elements greater than or equal to fromElement.
 *
 *
 */
public class SortedSetsTreeSets {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet,
                "one two three four five six seven eight"
                        .split(" "));
        System.out.println(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);


        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else it.next();
        }

        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}
