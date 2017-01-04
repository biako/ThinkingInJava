package tij.enums.enummaps;

import tij.enums.enumsets.AlarmPoints;
import java.util.*;
import static tij.enums.enumsets.AlarmPoints.*;

/**
 * Created by Xiaolong on 1/4/2017.
 * <p>
 * Thinking in Java p.738
 *
 * Example to use EnumMap
 *
 * I. instantiate EnumMap by using
 *
 * EnumMap<K, Y> em = new EnumMap<>(K.class);
 *
 * II. To traverse the entries in a map use the following:
 *
 * for (Map.Entry<K, Y> e : em.entrySet()) {
 *        System.out.println(e.getKey() + ": ");
 *        e.getValue().action();
 *   }
 *
 *
 */
interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {

        EnumMap<AlarmPoints, Command> em =
                new EnumMap<>(AlarmPoints.class);

        // Put in the value by anonymous class
        em.put(KITCHEN, new Command() {
            public void action() {
                System.out.println("Kitchen fire!");
            }
        });

        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));


        // To traverse each entries in a map.
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
                System.out.println(e.getKey() + ": ");
            e.getValue().action();
        }

        try { // If there’s no value for a particular key:
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}