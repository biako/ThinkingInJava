package tij.enums.valuemethod;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Example to show that there is values( ) is a hidden static method that is added by the compiler.
 *
 */

import java.lang.reflect.*;
import java.util.*;


enum Explore {HERE, THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("----- Analyzing " + enumClass + " -----");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces())
            System.out.println(t);
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        System.out.println();
        System.out.println("Explore.containsAll(Enum)? " +
                exploreMethods.containsAll(enumMethods));
        System.out.println();
        System.out.print("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        
        // Decompile the code for the enum:
        //OSExecute.command("javap Explore");
    }
}