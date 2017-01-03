package tij.enums.randomselection;

import java.util.Random;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p732-733
 *
 * Example to create a generic random selector for array of any type and for Enums.
 *
 */
public class Enums {
    private static Random rand = new Random(47);

    // Pass in a class object of an Enum, randomly select an element from the Enum:
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    // Randomly select an element from an array of any type:
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
