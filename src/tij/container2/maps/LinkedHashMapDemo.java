package tij.container2.maps;

import tij.container2.filling.abstractclass.CountingMapData;

import java.util.*;

/**
 * Created by Xiaolong on 1/9/2017.
 *
 * Thinking in Java p603-604
 *
 * In addition, a LinkedHashMap can be configured in the constructor to use
 * a least recently-used (LRU) algorithm based on accesses, so elements that
 * haven’t been accessed (and thus are candidates for removal) appear at the
 * front of the list. This allows easy creation of programs that do periodic
 * cleanup in order to save space.
 *
 *
 * LRU Constructor of LinkedHashMap:
 *
 * public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
 *
 *  initialCapacity the initial capacity
 *  loadFactor      the load factor
 *  accessOrder     the ordering mode - true for  access-order
 *                                      false for insertion-order
 *
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedMap =
                new LinkedHashMap<>(new CountingMapData(9));
        System.out.println("Normal linkedHashMap:\n" + linkedMap);

        // Least-recently-used order:
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        System.out.println("Least-recently-used order:\n" + linkedMap);

        for(int i = 0; i < 6; i++) // Cause accesses:
            linkedMap.get(i);
        System.out.println("linkedMap.get(0 to 5):\n" + linkedMap);

        linkedMap.get(0);
        System.out.println("linkedMap.get(0):\n" + linkedMap);
    }
}