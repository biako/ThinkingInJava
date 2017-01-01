package tij.generics.wildcards;
import java.util.*;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p486
 *
 * The argument apples is a List of some type that is the base type of Apple;
 * thus you know that it is safe to add an Apple or a subtype of Apple.
 * Since the lower bound is Apple, however, you don’t know that it is safe
 * to add Fruit to such a List, because that would allow the List to be
 * opened up to the addition of non-Apple types, which would violate static type safety.
 *
 * You can thus begin to think of subtype and supertype bounds in terms
 * of how you can "write" (pass into a method) to a generic type, and
 * "read" (return from a method) from a generic type.
 *
 */

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
}