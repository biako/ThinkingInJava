package tij.container2.collectionfunction;

import java.util.*;

import tij.container2.filling.abstractclass.Countries;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p581-582
 *
 * Things you can do with all Collections.
 *
 * boolean add(T):
 Ensures that the container holds the argument which is of generic type T. Returns false if it doesn’t add the argument. (This is an "optional" method, described in the next section.)

 boolean addAll( Collection<? extends T>):
 Adds all the elements in the argument. Returns true if any elements were added. ("Optional.")

 void clear():
 Removes all the elements in the container. ("Optional.")

 boolean contains (T):
 true if the container holds the argument which is of generic type T.

 Boolean containsAll( Collection<?>)
 true if the container holds all the elements in the argument.

 boolean isEmpty():
 true if the container has no elements.

 Iterator<T> iterator():
 Returns an Iterator<T> that you can use to move through the elements in the container.

 Boolean remove(Object):
 If the argument is in the container, one instance of that element is removed. Returns true if a removal occurred. ("Optional")

 boolean removeAll(Collection<?>)
 Removes all the elements that are contained in the argument. Returns true if any removals occurred. ("Optional.")

 Boolean retainAll(Collection<?>)
 Retains only elements that are contained in the argument (an "intersection," from set theory). Returns true if any
 changes occurred. ("Optional.")

 int size():
 Returns the number of elements in the container.

 Object[] toArray():
 Returns an array containing all the elements in the container.

 <T>T[] toArray(T[] a):
 Returns an array containing all the elements in the container. The runtime type of the result is that of the argument array a rather than plain Object.
 *
 *
 *
 */
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        // Make an array from the List:
        Object[] array = c.toArray();

        // Make a String array from the List:
        String[] str = c.toArray(new String[0]);

        // Find max and min elements; this means
        // different things depending on the way
        // the Comparable interface is implemented:
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));

        // Add a Collection to another Collection
        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);

        c.remove(Countries.DATA[0][0]);
        System.out.println(c);
        c.remove(Countries.DATA[1][0]);
        System.out.println(c);

        // Remove all components that are
        // in the argument collection:
        c.removeAll(c2);
        System.out.println(c);
        c.addAll(c2);
        System.out.println(c);

        // Is an element in this Collection?
        String val = Countries.DATA[3][0];
        System.out.println("c.contains(" + val + ") = " + c.contains(val));

        // Is a Collection in this Collection?
        System.out.println("c.containsAll(c2) = " + c.containsAll(c2));
        Collection<String> c3 =
                ((List<String>) c).subList(3, 5);

        // Keep all the elements that are in both
        // c2 and c3 (an intersection of sets):
        c2.retainAll(c3);
        System.out.println(c2);

        // Throw away all the elements
        // in c2 that also appear in c3:
        c2.removeAll(c3);
        System.out.println("c2.isEmpty() = " + c2.isEmpty());

        c = new ArrayList<String>();
        c.addAll(Countries.names(6));
        System.out.println(c);

        c.clear(); // Remove all elements
        System.out.println("after c.clear():" + c);
    }
}