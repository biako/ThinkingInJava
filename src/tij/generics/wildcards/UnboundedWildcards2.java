package tij.generics.wildcards;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Thinking in Java p489
 *
 * When you are dealing with multiple generic parameters,
 * it’s sometimes important to allow one parameter to be any type while
 * establishing a particular type for the other parameter.
 *
 */

import java.util.*;

public class UnboundedWildcards2 {
    static Map map1;
    //when you have all unbounded wildcards, as seen in Map<?,?>,
    // the compiler doesn't seem to distinguish it from a raw Map.
    static Map<?,?> map2;
    static Map<String,?> map3;
    static void assign1(Map map) { map1 = map; }
    static void assign2(Map<?,?> map) { map2 = map; }
    static void assign3(Map<String,?> map) { map3 = map; }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        // assign3(new HashMap()); // Warning:
        // Unchecked conversion. Found: HashMap
        // Required: Map<String,?>
        assign1(new HashMap<String,Integer>());
        assign2(new HashMap<String,Integer>());
        assign3(new HashMap<String,Integer>());
    }
}