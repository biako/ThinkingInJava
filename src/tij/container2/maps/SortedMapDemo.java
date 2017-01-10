package tij.container2.maps;

import tij.container2.filling.abstractclass.CountingMapData;

import java.util.*;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p602-603
 *
 * I. Use the SortedMap interface for TreeSMap:
 * SortedMap<T> sortedMap = new TreeMap<>();
 *
 * II. An ordered Set backed by a tree. Keys are guaranteed to be in sorted order.
 * Keys must also implement the Comparable interface.
 *
 * III. Methods under the SortedSet interface:
 *
 * Comparator comparator(): Produces the Comparator used for this Map, or null for natural ordering.
 *
 * Object firstKey(): Produces the lowest key.
 *
 * Object lastKey(): Produces the highest key.
 *
 * SortedMap subMap(fromKey, toKey): Produces a view of this Map with keys from fromKey, inclusive, to toKey, exclusive.
 *
 * SortedMap headMap(toKey): Produces a view of this Map with keys less than toKey.
 *
 * SortedMap tailMap(fromKey): Produces a view of this Map with keys greater than or equal to fromKey.
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> sortedMap =
                new TreeMap<>(new CountingMapData(10));
        System.out.println(sortedMap);

        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println(low);
        System.out.println(high);

        Iterator<Integer> it = sortedMap.keySet().iterator();
        for(int i = 0; i <= 6; i++) {
            if(i == 3) low = it.next();
            if(i == 6) high = it.next();
            else it.next();
        }
        System.out.println(low);
        System.out.println(high);

        System.out.println(sortedMap.subMap(low, high));
        System.out.println(sortedMap.headMap(high));
        System.out.println(sortedMap.tailMap(low));
    }
}

