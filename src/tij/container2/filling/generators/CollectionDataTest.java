package tij.container2.filling.generators;

import tij.array.generator.RandomGenerator;
import tij.generics.genericinterface.Generator;

import java.util.*;

/**
 * Created by Xiaolong on 1/7/2017.
 *
 * Thinking in Java p569-570
 *
 * Example to use CollectionData as an adaptor to using the generator to fill a Collection class
 *
 */
// The TestStrings Generator (implementing the Generator interface)
class StringsGenerator implements Generator<String> {
    // Will return the next word when colling next():
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " + "government").split(" ");
    private int index;
    public String next() { return foundation[index++]; }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        // Using the public constructor of CollectionData:
        // new CollectionData<T>(Generator<T>, int quantity)
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new StringsGenerator(), 5));

        // Using the convenience static method of CollectionData:
        // CollectionData.list(Generator<T>, int quantity)
        // Note: use new StringsGenerator() will return words from the beginning of the foundation String.
        set.addAll(CollectionData.list(new StringsGenerator(), 10));
        System.out.println(set);

        // Using the RandomGenerator as the argument
        System.out.println(new ArrayList<String>(
                CollectionData.list( // Convenience static method of CollectionData
                        new RandomGenerator.String(9), 10)));

        System.out.println(new HashSet<Integer>( // Public constructor of CollectionData
                new CollectionData<Integer>(
                        new RandomGenerator.Integer(), 10)));
    }
}
