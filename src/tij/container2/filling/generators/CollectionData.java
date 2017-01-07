package tij.container2.filling.generators;

import tij.generics.genericinterface.Generator;

import java.util.*;
/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p569
 *
 * CollectionData is a Collection filled with data using a Generator object.
 *
 * Design Pattern: Adapter design pattern; it adapts a Generator to the constructor / addAll() method for a Collection.
 *
 * CollectionData can be used by calling:
 * (1) public constructor;
 *       new CollectionData<T>(Generator<T>, int quantity)
 * or
 * (2) static method list()
 *       CollectionData.list(Generator<T>, int quantity)
 *
 * The constructor or static method takes arguments of a Generator and a quantity value.
 * The Generator is an interface with a method next(), which will return a new object of its type.
 * A type-specific Generator will implement the next() method.
 * next() will be called for the times set by the quantity value in CollectionData's constructor / static method list ().
 * The resulting container can then be passed to the constructor or the addAll() method for any Collection,
 *
 *
 */

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i = 0; i < quantity; i++)
            add(gen.next());
    }

    // A generic convenience static method: also calling the public constructor
    // Pass in a Generator and the quantity
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}