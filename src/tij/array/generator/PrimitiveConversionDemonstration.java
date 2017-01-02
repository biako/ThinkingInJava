package tij.array.generator;

import java.util.Arrays;

/**
 * Created by Xiaolong on 1/2/2017.
 *
 * Thinking in Java p553
 *
 * ConvertTo with both versions of Generated.array( ):
 *
 */
public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        // Testing the counting generators:
        Integer[] a = GeneratedArray.array(Integer.class,
                new CountingGenerator.Integer(), 15);

        int[] b = ConvertTo.primitive(a);
        System.out.println("a = " + Arrays.toString(b));

        boolean[] c = ConvertTo.primitive(
                GeneratedArray.array(Boolean.class,
                        new CountingGenerator.Boolean(), 7));
        System.out.println("b = " + Arrays.toString(c));


        // Testing the random generators:
        int size = 10;
        boolean[] a1 = ConvertTo.primitive(GeneratedArray.array(
                Boolean.class, new RandomGenerator.Boolean(), size));
        System.out.println("a1 = " + Arrays.toString(a1));

        byte[] a2 = ConvertTo.primitive(GeneratedArray.array(
                Byte.class, new RandomGenerator.Byte(), size));
        System.out.println("a2 = " + Arrays.toString(a2));

        char[] a3 = ConvertTo.primitive(GeneratedArray.array(
                Character.class,
                new RandomGenerator.Character(), size));
        System.out.println("a3 = " + Arrays.toString(a3));

        short[] a4 = ConvertTo.primitive(GeneratedArray.array(
                Short.class, new RandomGenerator.Short(), size));
        System.out.println("a4 = " + Arrays.toString(a4));

        int[] a5 = ConvertTo.primitive(GeneratedArray.array(
                Integer.class, new RandomGenerator.Integer(), size));
        System.out.println("a5 = " + Arrays.toString(a5));

        long[] a6 = ConvertTo.primitive(GeneratedArray.array(
                Long.class, new RandomGenerator.Long(), size));
        System.out.println("a6 = " + Arrays.toString(a6));

        float[] a7 = ConvertTo.primitive(GeneratedArray.array(
                Float.class, new RandomGenerator.Float(), size));
        System.out.println("a7 = " + Arrays.toString(a7));

        double[] a8 = ConvertTo.primitive(GeneratedArray.array(
                Double.class, new RandomGenerator.Double(), size));
        System.out.println("a8 = " + Arrays.toString(a8));
    }

}
