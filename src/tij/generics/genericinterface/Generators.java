package tij.generics.genericinterface;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Xiaolong on 12/31/2016.
 */
public class Generators {
    // Public static untility method to fill n number of type of T objects by using Generate<T> gen
    // by calling next() for n times into Collection<T>

    public static <T> Collection<T>
    fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(
                new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            System.out.println(c);
    }
}