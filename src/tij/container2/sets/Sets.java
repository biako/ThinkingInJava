package tij.container2.sets;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p589-590
 *
 * I. Types of Sets:
 * (1) Set (interface)
 * Each element that you add to the Set must be unique; otherwise, the Set doesn’t add the duplicate element.
 * Elements added to a Set must at least define equals( ) to establish object uniqueness.
 * Set has exactly the same interface as Collection.
 *
 * The Set interface does not guarantee that it will maintain its elements in any particular order.
 *
 * (2) HashSet
 * For Sets where fast lookup time is important. Elements must also define hashCode( ).
 *
 * (3) TreeSet
 * An ordered Set backed by a tree. This way, you can extract an ordered
 * sequence from a Set. Elements must also implement the Comparable interface.
 *
 * (4) LinkedHashSet
 * Has the lookup speed of a HashSet, but internally maintains the order
 * in which you add the elements (the insertion order) using a linked list.
 * Thus, when you iterate through the Set, the results appear in insertion order.
 * Elements must also define hashCode().
 *
 * II. Notes:
 * (1) For objects to be put in Sets: Must implements a refined version of hashcodes()
 *
 *      Placing a SetType or TreeType object, which doesn’t include a redefined
 *      hashCode() method, into any hashed implementations results in duplicate
 *      values, so the primary contract of the Set is violated.
 *
 * (2) For objects to be put in TreeSet: Must implements Comparable and override compareTo()
 *
 *      I did not use the "simple and obvious" form return i-i2.
 *      Although this is a common programming error, it would only
 *      work properly if i and i2 were "unsigned" ints (if Java had
 *      an "unsigned" keyword, which it does not). It breaks for Java’s
 *      signed int, which is not big enough to represent the difference
 *      of two signed ints. If i is a large positive integer and j
 *      is a large negative integer, i-j will overflow and return
 *      a negative value, which will not work.
 *
 *      You’ll usually want the compareTo( ) method to produce a natural
 *      ordering that is consistent with the equals( ) method. If equals( )
 *      produces true for a particular comparison, then compareTo( )
 *      should produce a zero result for that comparison, and if equals ( )
 *      produces false for a comparison then compareTo( ) should produce
 *      a nonzero result for that comparison.
 *
 * III. Methods in Map interface:
 *
 *  Set has exactly the same interface as Collection.
 */
class SetType {
    int i;
    public SetType(int n) { i = n; }
    public boolean equals(Object o) {
        return o instanceof SetType && (i == ((SetType)o).i);
    }
    public String toString() { return Integer.toString(i); }
}

// Object to be put in a TreeSet
class HashType extends SetType {
    public HashType(int n) { super(n); }
    public int hashCode() { return i; }
}

// Object to be put in a TreeSet must implement Comparable<> and override compareTo()
class TreeType extends SetType
        implements Comparable<TreeType> {
    public TreeType(int n) { super(n); }
    // THis is an inverse order compareTo()
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

        // Placing a SetType or TreeType object, which doesn’t include a redefined
        // hashCode() method, into any hashed implementations results in duplicate
        // values, so the primary contract of the Set is violated.
        //
        // This is rather disturbing because there’s not even a runtime error.
        // However, the default hashCode( ) is legitimate and so this is legal
        // behavior, even if it’s incorrect.
        test(new HashSet<SetType>(), SetType.class);
        test(new HashSet<TreeType>(), TreeType.class);
        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);

        // Objects does not implement Comparable cannot be used in TreeSet (interface is SortedSet)
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