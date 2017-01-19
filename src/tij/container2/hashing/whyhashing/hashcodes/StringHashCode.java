package tij.container2.hashing.whyhashing.hashcodes;

/**
 * Created by Xiaolong on 1/15/2017.
 *
 * Thinking in Java p613
 *
 * One example can be seen in the String class. Strings have the special
 * characteristic that if a program has several String objects that contain
 * identical character sequences, then those String objects all map to the
 * same memory. So it makes sense that the hashCode( ) produced by two separate
 * instances of the String "hello" should be identical.
 *
 *
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
