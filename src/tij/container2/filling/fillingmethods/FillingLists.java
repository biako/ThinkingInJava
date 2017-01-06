package tij.container2.filling.fillingmethods;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p568
 *
 * Example of filling by the Collections.fill() & Collections.nCopies() methods.
 *
 * I. Static methods of Collections to fill references to the same object:
 *
 * (1) Collections.fill(): pass in a List and fill it
 *     public static <T> void fill(List<? super T> list, T obj)
 *
 * (2) Collections.nCopies(): will return a List
 *     public static <T> List<T> nCopies(int n, T o)
 *
 * II. Object.toString(): will return the hexadecimal the class name followed
 *       by the unsigned hexadecimal representation of the hash code of the object
 *      return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *
 */
// Creating a sample object String Address: it only has one String variable "s"
class StringAddress {
    private String s;
    public StringAddress(String s) { this.s = s; }

    // super.toString() will return the hexadecimal the class name followed
    // by the unsigned hexadecimal representation of the hash code of the object:
    // return getClass().getName() + "@" + Integer.toHexString(hashCode());
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        // ArrayList's constructor: pass in a Collection
        //    public ArrayList(Collection<? extends E> c)
        // Collection.nCopies() will return a List
        List<StringAddress> list= new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);


        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
