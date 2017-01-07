package tij.container2.filling.generators;



import tij.generics.genericinterface.Generator;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p571-572
 *
 * MapData adapter is a map filled with data using using various combinations of
 * Generators, Iterables, and constant values to fill Map initialization objects.
 *
 * Design Pattern: Adapter design pattern; it adapts a Generator to the constructor /putAll() method for a Map.
 *
 * MapData can be used by calling:
 * (1) overloaded public constructor; or
 * (2) overloaded static method map()
 *
 *
 */

public class MapData<K, V> extends LinkedHashMap<K, V> {
    // A single Pair Generator:
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }

    // Two separate Generators:
    public MapData(Generator<K> genK, Generator<V> genV,
                   int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    // A key Generator and a single value:
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }

    // An Iterable and a value Generator (as there is an Iterable, there is no quantity):
    // Use Iterable in foreach
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K key : genK) {
            put(key, genV.next());
        }
    }

    // An Iterable and a single value (as there is an Iterable, there is no quantity):
    // Use Iterable in foreach
    public MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }

    // Generic convenience static methods calling the public constructors above:
    public static <K, V> MapData<K, V>
    map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<K, V>(gen, quantity);
    }

    public static <K, V> MapData<K, V>
    map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<K, V>(genK, genV, quantity);
    }

    public static <K, V> MapData<K, V>
    map(Generator<K> genK, V value, int quantity) {
        return new MapData<K, V>(genK, value, quantity);
    }

    public static <K, V> MapData<K, V>
    map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K, V>(genK, genV);
    }

    public static <K, V> MapData<K, V>
    map(Iterable<K> genK, V value) {
        return new MapData<K, V>(genK, value);
    }
}
