package tij.container2.maps;

import tij.container2.filling.abstractclass.CountingMapData;

import java.util.concurrent.*;
import java.util.*;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p600-601
 *
 * I. Types of Maps
 *
 * (1) Map (interface)
 *
 * (2) HashMap
 * Implementation based on a hash table. (Use this class instead of Hashtable.)
 * Provides constant-time performance for inserting and locating pairs.
 * Performance can be adjusted via constructors that allow you to set the
 * capacity and load factor of the hash table.
 *
 * (3) LinkedHashMap
 * Like a HashMap, but when you iterate through it, you get the pairs
 * in insertion order, or in least-recently-used (LRU) order. Only slightly
 * slower than a HashMap, except when iterating, where it is faster due to
 * the linked list used to maintain the internal ordering.
 *
 * (4) TreeMap
 * Implementation based on a red-black tree. When you view the keys
 * or the pairs, they will be in sorted order (determined by Comparable
 * or Comparator). The point of a TreeMap is that you get the results
 * in sorted order.
 *
 * TreeMap is the only Map with the subMap( ) method,
 * which allows you to return a portion of the tree.
 *
 * (5) WeakHashMap
 * A map of weak keys that allow objects referred to by the map to
 * be released; designed to solve certain types of problems. If no
 * references to a particular key are held outside the map, that key
 * may be garbage collected.
 *
 * (6) ConcurrentHashMap
 * A thread-safe Map which does not involve synchronization locking.
 * This is discussed in the Concurrency chapter.
 *
 * (7) IdentityHashMap
 * A hash map that uses == instead of equals( ) to compare keys.
 * Only for solving special types of problems; not for general use.
 *
 *
 * II. Notes:
 * (1) Any key must have an equals( ) method.
 * (2) If the key is used in a hashed Map, it must also have a proper hashCode( ).
 * (3) If the key is used in a TreeMap, it must implement Comparable.
 * (4) Map has ‘Set’ behavior for keys:
 *
 * III. Methods in Map interface:
 *
 *void	clear()
 Removes all of the mappings from this map (optional operation).

 default V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).

 default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
 If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.

 default V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
 If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.

 boolean	containsKey(Object key)
 Returns true if this map contains a mapping for the specified key.

 boolean	containsValue(Object value)
 Returns true if this map maps one or more keys to the specified value.

 boolean	equals(Object o)
 Compares the specified object with this map for equality.

 default void	forEach(BiConsumer<? super K,? super V> action)
 Performs the given action for each entry in this map until all entries have been processed or the action throws an exception.

 int	hashCode()
 Returns the hash code value for this map.

 boolean	isEmpty()
 Returns true if this map contains no key-value mappings.

 Set<Map.Entry<K,V>>  entrySet()
 Returns a Set view of the mappings contained in this map.

 Set<K> keySet()
 Returns a Set view of the keys contained in this map.

 Collection<V> values()
 Returns a Collection view of the values contained in this map.

 default V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
 If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.

 V get(Object key)
 Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

 default V getOrDefault(Object key, V defaultValue)
 Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

 V put(K key, V value)
 Associates the specified value with the specified key in this map (optional operation).

 void	putAll(Map<? extends K,? extends V> m)
 Copies all of the mappings from the specified map to this map (optional operation).

 default V putIfAbsent(K key, V value)
 If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value.

 V remove(Object key)
 Removes the mapping for a key from this map if it is present (optional operation).

 default boolean	remove(Object key, Object value)
 Removes the entry for the specified key only if it is currently mapped to the specified value.

 default V replace(K key, V value)
 Replaces the entry for the specified key only if it is currently mapped to some value.

 default boolean	replace(K key, V oldValue, V newValue)
 Replaces the entry for the specified key only if currently mapped to the specified value.

 default void	replaceAll(BiFunction<? super K,? super V,? extends V> function)
 Replaces each entry's value with the result of invoking the given function on that entry until all entries have been processed or the function throws an exception.

 int	size()
 Returns the number of key-value mappings in this map.

 *
 *
 *
 *
 * The printKeys( ) method demonstrates how to produce a Collection view of a Map.
 * The keySet( ) method produces a Set backed by the keys in the Map. Because of
 * improved printing support in Java SE5, you can simply print the result of the
 * values( ) method, which produces a Collection containing all the values in the
 * Map. (Note that keys must be unique, but values may contain duplicates.) Since
 * these Collections are backed by the Map, any changes in a Collection will be
 * reflected in the associated Map.
 *
 *
 */
// Things you can do with Maps.
public class Maps {
    public static void printKeys(Map<Integer,String> map) {
        System.out.print("Size = " + map.size() + ", \n");
        System.out.println("Keys: ");
        System.out.print(map.keySet()); // Produce a Set of the keys
    }
    public static void test(Map<Integer,String> map) {
        System.out.print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has ‘Set’ behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a Collection of the values:
        System.out.println();
        System.out.println("Values: ");
        System.out.print(map.values());
        System.out.println();
        System.out.println("Map: ");
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"F0\"): "
                + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        System.out.println();
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
        test(new HashMap<Integer,String>());
        test(new TreeMap<Integer,String>());
        test(new LinkedHashMap<Integer,String>());
        test(new IdentityHashMap<Integer,String>());
        test(new ConcurrentHashMap<Integer,String>());
        test(new WeakHashMap<Integer,String>());
    }
}