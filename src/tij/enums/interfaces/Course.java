package tij.enums.interfaces;

import tij.enums.randomselection.Enums;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p734
 *
 * Example of creating enum of enums by using private constructors:
 *
 * Taking the subtypes as private arrays, initializing by private constructor:
 * Each of the above enums takes the corresponding Class object
 * as a constructor argument, from which it can extract and store
 * all the enum instances using getEnumConstants( ).
 *
 * These instances are later used in randomSelection( )
 *
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    // Initialize each element's values using this private constructor:
    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        // public static <T> T random(T[] values)
        // Will pass in an array, and return a random selection from the array.
        return Enums.random(values);

    }
}