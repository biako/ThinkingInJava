package tij.container2.collectionfunction;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *  *
 * Thinking in Java p583-584
 *
 * Unsupported operations in Java containers:
 *  will throw UnsupportedOperationException
 *
 * (1) Arrays.asList( ) returns a fixed-sized List:
 *      Unsupported: retainAll(), removeAll(), clear(), add(), addAll(), remove()
 *
 * (2) Collections.unmodifiableList( ) returns a list that cannot be changed:
 *      Unsupported: the methods above and List.set()
 *
 *
 */
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");

        Collection<String> c = list;
        Collection<String> subList = list.subList(1,8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<>(subList);

        try { c.retainAll(c2); } catch(Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try { c.removeAll(c2); } catch(Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try { c.clear(); } catch(Exception e) {
            System.out.println("clear(): " + e);
        }
        try { c.add("X"); } catch(Exception e) {
            System.out.println("add(): " + e);
        }
        try { c.addAll(c2); } catch(Exception e) {
            System.out.println("addAll(): " + e);
        }
        try { c.remove("C"); } catch(Exception e) {
            System.out.println("remove(): " + e);
        }

        // The List.set() method modifies the value but
        // doesn’t change the size of the data structure:
        /* The last try block in test( ) examines the set( ) method
           that’s part of List. This is interesting, because you can see
           how the granularity of the "unsupported operation" technique
           comes in handy—the resulting "interface" can vary by one method
           between the object returned by Arrays.asList( ) and that returned
           by Collections.unmodifiableList( ). Arrays.asList( ) returns a
           fixed-sized List, whereas Collections.unmodifiableList( ) produces
           a list that cannot be changed. */
        try {list.set(0, "X");} catch(Exception e) {
            System.out.println("List.set(): " + e);
        }
    }
    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()",
                Collections.unmodifiableList(new ArrayList<String>(list)));
    }
}
