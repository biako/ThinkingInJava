package tij.container2.hashing.whyhashing.hashcodes;

import java.util.*;
/**
 * Created by Xiaolong on 1/19/2017.
 *
 * Thinking in Java p614-615
 *
 *
 * I. Effective Java a basic recipe for generating a decent hashCode()
 *
 * 1. Store some constant nonzero value, say 17, in an int variable called result.
 * 2. For each significant field fin your object (that is, each field taken into
 * account by the equals( ) method), calculate an int hash code c for the field:
 *
 *       boolean:  c = ( f ? 0 : 1)
 *       byte, char, short, or int: c = (int)f
 *       long: c = (int)(f ^ (f>>>32))
 *       float: c = Float.floatToIntBits(f);
 *       double:  long l = Double.doubleToLongBits(f); c = (int)(1 ^ (l>>>32))
 *       Object, where equals( ) calls equals( ) for this field: c = f.hashCode( )
 *       Array: Apply above rules to each element
 * *
 * 3. Combine the hash code(s) computed above: result = 37 * result + c;
 * 4. Return result.
 * 5. Look at the resulting hashCode( ) and make sure that equal instances have equal hash codes.
 *
 * II. Explanation of CountedString
 *
 * CountedString includes a String and an id that represents the number of
 * CountedString objects that contain an identical String. The counting is
 * accomplished in the constructor by iterating through the static ArrayList
 * where all the Strings are stored.
 *
 * Both hashCode( ) and equals( ) produce results based on both fields;
 * if they were just based on the String alone or the id alone, there would be duplicate matches for distinct values.
 */
public class CountedString {
    // the created List<String> will store all the Strings created for the CountedString class.
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String str) {
        s = str;
        // the created List<String> will store all the Strings created for the CountedString class.
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString:
        for(String s2 : created)
            if(s2.equals(s))
                id++;
    }

    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    /** Both hashCode( ) and equals( ) produce results based on both fields;
     * if they were just based on the String alone or the id alone, there would
     * be duplicate matches for distinct values.*/
    public int hashCode() {
        // The very simple approach:
        // return s.hashCode() * id;
        // Using Joshua Bloch’s recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        // If not add the id, different instances of the same value will have the same hashcode
        result = 37 * result + id;
        return result;
    }

    /** Both hashCode( ) and equals( ) produce results based on both fields;
     * if they were just based on the String alone or the id alone, there would
     * be duplicate matches for distinct values.*/
    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString)o).s) &&
                id == ((CountedString)o).id;
    }


    /** In main( ), several CountedString objects are created using
     *  the same String, to show that the duplicates create unique
     *  values because of the count id. The HashMap is displayed so that
     *  you can see how it is stored internally (no discernible orders),
     *  and then each key is looked up individually to demonstrate that the lookup mechanism is working properly.
     * */
    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];

        for(int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i); // Autobox int -> Integer
        }

        System.out.println(map);

        for(CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }
}