package tij.array.generator;

import tij.generics.genericinterface.Generator;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p548-549
 *
 * Class.getClasses() will return an array for all the classes inside a Class object: Class<?>[]
 *
 * Calling the all the generators for each classes in side CountingGenerator to test all the generators
 *
 */
public class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        // Class.getClasses() will return an array: Class<?>[]
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");
            try {
                Generator g = (Generator) type.newInstance();
                //Generator<?> g = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++)
                    System.out.printf(g.next() + " ");
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);

    }
}