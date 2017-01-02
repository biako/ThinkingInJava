package tij.array.basics;

import java.util.Arrays;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p541
 *
 */
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                { new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere() },
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}