package tij.generics.genericmethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaolong on 12/30/2016.
 * <p>
 * Thinking in Java p.452
 */
public class GenericVarargs {

    // Perform similar function as Arrays.asList(T e)
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args)
            result.add(item);
        return result;
    }


    public static void main (String[] args){
        List<String> a = makeList ("avc", "adr");
        System.out.println(a);
    }

}
