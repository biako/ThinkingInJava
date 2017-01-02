package tij.array.basics;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p537
 *
 * Example to compare ArrayList and array
 *
 */
import java.util.*;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
}

public class ContainerComparison {public static void main(String[] args) {
    // use array
    BerylliumSphere[] spheres = new BerylliumSphere[10];
    for(int i = 0; i < 5; i++)
        spheres[i] = new BerylliumSphere();
    System.out.println(Arrays.toString(spheres));
    System.out.println(spheres[4]);

    // use container ArrayList
    List<BerylliumSphere> sphereList =
            new ArrayList<>();
    for(int i = 0; i < 5; i++)
        sphereList.add(new BerylliumSphere());
    System.out.println(sphereList);
    System.out.println(sphereList.get(4));

    // use array
    int[] integers = { 0, 1, 2, 3, 4, 5 };
    System.out.println(Arrays.toString(integers));
    System.out.println(integers[4]);

    // use container ArrayList
    List<Integer> intList = new ArrayList<>(
            Arrays.asList(0, 1, 2, 3, 4, 5));
    intList.add(97);
    System.out.println(intList);
    System.out.println(intList.get(4));
    }
}