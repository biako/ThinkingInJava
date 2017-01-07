package tij.container2.filling.generators;

import tij.array.generator.*;
import tij.generics.genericinterface.Generator;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p571-572
 *
 * Example to use MapData as an adaptor to using various Generators,
 * Iterables or constant values to fill a Map class
 *
 */

// LettersGeneratorIterable implements both a generator (can call next()) and an Iterable (can use foreach):
class LettersGeneratorIterable implements Generator<Pair<Integer,String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    // Override next() in Generator interface:
    // Generates a Integer and String in Sequence, from 1 and 'A'
    public Pair<Integer,String> next() {
        return new Pair<Integer,String>(
                number++, "" + letter++);
    }

    // Override iterator() in Iterable interface:
    // will only iterates for 8 times (from 1 to 8)
    public Iterator<Integer> iterator() {
        // Using anonymous class
        return new Iterator<Integer>() {
            public Integer next() { return number++; }
            // will only iterates for 8 times (from 1 to 8)
            public boolean hasNext() { return number < size; }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}


public class MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        System.out.println(MapData.map(new LettersGeneratorIterable(), 11));

        // Two separate generators:
        System.out.println(MapData.map(new CountingGenerator.Character(),
                new RandomGenerator.String(3), 8));

        // A key Generator and a single value:
        System.out.println(MapData.map(new CountingGenerator.Character(),
                "Value", 6));

        // An Iterable and a value Generator:
        System.out.println(MapData.map(new LettersGeneratorIterable(),
                new RandomGenerator.String(3)));

        // An Iterable and a single value:
        System.out.println(MapData.map(new LettersGeneratorIterable(), "Pop"));

        // Use putAll() of a Map object:
        Map<Integer, String> maptest = new LinkedHashMap<>();
        maptest.putAll(MapData.map(new LettersGeneratorIterable(), 12));
        System.out.println(maptest);
    }
}
