package tij.enums.enumsets;

import java.util.EnumSet;

import static tij.enums.enumsets.AlarmPoints.*;

/**
 * Created by Xiaolong on 1/4/2017.
 *
 * Thinking in Java p.738
 *
 * Example to use EnumSet

 *
 * I. Instantiate EnumSet by using
 * EnumSet<K> points =
 *      EnumSet.noneOf(K.class); // Empty set
 *
 * EnumSet is an abstract class. Cannot Instantiate by using "new."
 *
 * II. Static Methods below will return an EnumSet.
 * To be used together with add(), addAll(), remove(), removeAll().
 *
 * (1) EnumSet.noneOf() / EnumSet.allOf()
 *      public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType)
 * (2) EnumSet.of()
 *     e.g.: enumset1.addAll(EnumSet.of())
 * (3) EnumSet.range()
 * (4) EnumSet.complementOf()
 *
 */
public class EnumSets {
    public static void main(String[] args) {
        // Pass in a class object
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty set

        points.add(BATHROOM);
        System.out.println(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points.addAll(EnumSet.allOf(AlarmPoints.class));
        // points = EnumSet.allOf(AlarmPoints.class); is the same

        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);

        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}