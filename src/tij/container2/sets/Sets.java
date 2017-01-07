package tij.container2.sets;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p589-590
 *
 *
 * I. Set (interface)
 *  Each element that you add to the Set must be unique; otherwise, the Set doesn’t add the duplicate element.
 *  Elements added to a Set must at least define equals( ) to establish object uniqueness.
 *  Set has exactly the same interface as Collection. *
 *  The Set interface does not guarantee that it will maintain its elements in any particular order.
 *
 * II. HashSet*
 * For Sets where fast lookup time is important. Elements must also define hashCode( ).
 *
 * III. TreeSet
 * An ordered Set backed by a tree. This way, you can extract an ordered
 * sequence from a Set. Elements must also implement the Comparable interface.
 *
 * IV. LinkedHashSet
 * Has the lookup speed of a HashSet, but internally maintains the order
 * in which you add the elements (the insertion order) using a linked list.
 * Thus, when you iterate through the Set, the results appear in insertion order.
 * Elements must also define hashCode( ).
 *
 */
class SetType {
    int i;
    public SetType(int n) { i = n; }
    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType)o).i);
    }
    public String toString() { return Integer.toString(i); }
}


class HashType extends SetType {
    public HashType(int n) { super(n); }
    public int hashCode() { return i; }
}


class TreeType extends SetType
        implements Comparable<TreeType> {
    public TreeType(int n) { super(n); }
    public int compareTo(TreeType arg) {
        return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
    }
}


public class Sets {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for(int i = 0; i < 10; i++)
                set.add(
                        type.getConstructor(int.class).newInstance(i));
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }


    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type); // Try to add duplicates
        fill(set, type);
        System.out.println(set);
    }


    public static void main(String[] args) {
        test(new HashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);
        test(new TreeSet<TreeType>(), TreeType.class);
        // Things that don’t work:
        test(new HashSet<SetType>(), SetType.class);
        test(new HashSet<TreeType>(), TreeType.class);
        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);

        try {
            test(new TreeSet<SetType>(), SetType.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            test(new TreeSet<HashType>(), HashType.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}