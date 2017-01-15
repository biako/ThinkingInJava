package tij.container2.hashing.whyhashing.hashedmap;

import tij.container2.filling.abstractclass.Countries;
import tij.container2.hashing.whyhashing.arraylistmap.*;

import java.util.*;
/**
 * Created by Xiaolong on 1/11/2017.
 *
 * Thinking in Java p610-611
 * A demonstration hashed Map.
 *
 * I. Bucket: The list containing key-value pairs with the same hash code for non-perfect hashed map.
 *
 * So the process of looking up a value starts by computing the hash code and using it
 * to index into the array. If you could guarantee that there were no collisions (which
 * is possible if you have a fixed number of values), then you’d have a perfect hashing
 * junction, but that’s a special case.
 *
 * In all other cases, collisions are handled by external chaining: The array doesn't
 * point directly to a value, but instead to a list of values. These values are searched
 * in a linear fashion using the equals( ) method. Of course, this aspect of the search
 * is much slower, but if the hash function is good, there will only be a few values in
 * each slot. So instead of searching through the entire list, you quickly jump to a slot
 * where you only have to compare a few entries to find the value. This is much faster,
 * which is why the HashMap is so quick.
 *
 * Each of such list of value is called a bucket.
 *
 *
 * II. Example of SimpleHashMap
 *
 * Because the "slots" in a hash table are often referred to as buckets,
 * the array that represents the actual table is called buckets. To promote
 * even distribution, the number of buckets is typically a prime number.
 *
 * Notice that it is an array of LinkedList, which automatically provides for
 * collisions: Each new item is simply added to the end of the list in a particular
 * bucket. Even though Java will not let you create an array of generics, it is possible
 * to make a reference to such an array. Here, it is convenient to upcast to such an
 * array, to prevent extra casting later in the code.
 *
 *
 * Each new item is simply added to the end of the list in a particular bucket.
 * Even though Java will not let you create an array of generics, it is possible
 * to make a reference to such an array. Here, it is convenient to upcast to such
 * an array, to prevent extra casting later in the code.
 *
 *
 *
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;

    // You can’t have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];


    /**
     * For a put( ), the hashCode( ) is called for the key and the result is forced to a
     * positive number. To fit the resulting number into the buckets array, the modulus
     * operator is used with the size of that array.
     *
     * If that location is null, it means there are no elements that hash to that
     * location, so a new LinkedList is created to hold the object that just did hash
     * to that location.
     *

     *
     * */
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        System.out.println("Calling put(): Index of " + key + " = " + index);

        // If that location is null, it means there are no elements that hash to that
        // location, so a new LinkedList is created to hold the object that just did hash
        // to that location.
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key, value);



        // However, the normal process is to look through the list to see if there
        // are duplicates, and if there are, the old value is put into oldValue and
        // the new value replaces the old.
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                System.out.println("Found old = " + oldValue + "replaced with new" + value);
                found = true;
                break;
            }
        }

        // The found flag keeps track of whether an old key-value pair
        // was found and, if not, the new pair is appended to the end of the list.
        if(!found) {
            System.out.println("Not found old and add new pair: " + pair);
            buckets[index].add(pair);
        }
        return oldValue;
    }

    /**
     *  The get( ) calculates the index into the buckets array in the same fashion as put( )
     * (this is important in order to guarantee that you end up in the same spot). If a
     * LinkedList exists, it is searched for a match.
     *
     * */
    public V get(Object key) {
        // First get the hash index
        int index = Math.abs(key.hashCode()) % SIZE;
        System.out.println("Calling get(): Index of " + key + " = " + index);

        // If the hash bucket of such index is empty, return null
        if(buckets[index] == null) return null;

        // Traverse the bucket of such index and get the value if the key is found.
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key)) {
                System.out.println("Found pair: " + iPair);
                return iPair.getValue();
            }

        // Default return null
        return null;
    }


    /**
     *
     * Note that this implementation is not meant to be tuned for performance; it is only
     * intended to show the operations performed by a hash map. If you look at the source
     * code for java.util.HashMap, you’ll see a tuned implementation. Also, for simplicity
     * SimpleHashMap uses the same approach to entrySet( ) as did SlowMap, which is oversimplified
     * and will not work for a general-purpose Map.
     * *
     * */
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m =
                new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        /*
        This is putAll in AbstractMap: Will get keys and values by calling entrySet()
        and call put() to put in each of the entry:

        public void putAll(Map<? extends K, ? extends V> m) {
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
        }
        * */

        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}