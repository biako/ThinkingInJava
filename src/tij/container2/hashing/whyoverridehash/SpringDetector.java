package tij.container2.hashing.whyoverridehash;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created by Xiaolong on 1/10/2017.
 *
 * Thinking in Java p605-606
 *
 * I. Example to demonstrate that a key cannot be found if hashCode() and equal() are not overridden.
 *
 * The problem is that Groundhog is automatically inherited from the common root class Object,
 * and it is Object's hashCode( ) method that is used to generate the hash code for each object.
 * By default this just uses the address of its object.
 *
 * Thus, the first instance of Groundhog(3) does not produce a hash code equal to the hash code
 * for the second instance of Groundhog(3) that we tried to use as a lookup.
 *
 *
 * II. Creating new instance using reflection
 *
 * (1) Get the constructor with formal parameter and use the Constructor with formal parameters
 *   Constructor<T> getConstruct(Class<?>... parameterTypes): parameterTypes is an array of Class objects that
 *  identify the constructor's formal parameter types, in declared order.
 *
 *      // Get the constructor with an int formal parameter
 *      Constructor<T> typeconstructor = ClassName.class.getConstructor(int.class);
 *      T instance = typeconstructor.newInstance(1);
 *
 * (2) Directly use class object but cannot use formal parameter. only can use defaul constructor
 *
 *      T instance = ClassName.class.newInstance();
 *
 * III. A proper equals() must satisfy the following five conditions:
 *
 * (1) Reflexive: For any x, x.equals(x) should return true.
 * (2) Symmetric: For any x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
 * (3) Transitive: For any x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
 * (4) Consistent: For any x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the object is modified.
 * (5) Null: For any non-null x, x.equals(null) should return false.
 *
 */
public class SpringDetector {
    // Uses a Groundhog or class derived from Groundhog: Pass in a Class object
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        // Get the constructor:
        // Constructor<T> getConstruct(Class<?>... parameterTypes): parameterTypes is an array of Class objects that
        // identify the constructor's formal parameter types, in declared order.
        Constructor<T> ghog = type.getConstructor(int.class); // Get the constructor with an int formal parameter

        // Groundhod as the key and Prediction as the value:
        Map<Groundhog,Prediction> map = new HashMap<>();

        // put due Groundhod as key and new Prediction as value:
        for(int i = 0; i < 10; i++)
            map.put(ghog.newInstance(i), new Prediction());
        System.out.println("map = " + map); // Note: HashMap will not produce according to insertion order

        Groundhog gh = ghog.newInstance(3); // If using this constructor, the hashcode would be a new address
        System.out.println("\nLooking up prediction for " + gh);

        if(map.containsKey(gh))
            System.out.println("Key found:" + map.get(gh));
        else
            System.out.println("Key not found: " + gh);
    }
    
    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
        detectSpring(Groundhog2.class);
    }
}
