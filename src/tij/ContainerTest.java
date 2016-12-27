package tij;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Xiaolong on 12/24/2016.
 */
public class ContainerTest {

    public static void test(){
    ArrayList<Integer> collection1 = new ArrayList<>();
    Collection<Integer> collection2 = new ArrayList<>();

        Collections.addAll(collection1, 1, 2, 3, 4,3,5);
        Collections.addAll(collection2, 1, 2);
        collection1.add(4);
        System.out.println(collection1.isEmpty());
        System.out.println(collection1.contains(4));
        System.out.println(collection1.containsAll(collection2));
        System.out.println(collection1);
        System.out.println(collection1);
        System.out.println(collection1);
    }
}
