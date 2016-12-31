package tij.generics.complexmodels;

import tij.generics.tuple.Vehicle;
import tij.generics.tuple.Amphibian;
import tij.generics.tuple.FourTuple;
import tij.generics.tuple.TupleTest;


import java.util.ArrayList;

/**
 * Created by Xiaolong on 12/31/2016.
 * <p>
 * Thinking in Java p460-461
 *
 */

// Create a list of Tuple, each tuple holding four types A, B, C and D
public class ListofTuples<A, B, C, D>
        extends ArrayList<FourTuple<A, B, C, D>> {

    public static void main(String[] args) {
        ListofTuples<Vehicle, Amphibian, String, Integer> tl =
                new ListofTuples<>();

        // TupleTest.h() will return a FourTuple<Vehicle, Amphibian, String, Integer>
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        int count = 1;
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
            System.out.format("No. %d tuple in the tuple list: %s\n", count, i);
            count++;
        }
    }
}