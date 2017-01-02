package tij.array.generator;

/**
 * Created by Xiaolong on 1/2/2017.
 * <p>
 * Thinking in Java p552
 * <p>
 * Generics don’t work with primitives, and we want to use
 * the generators to fill primitive arrays. To solve the problem,
 * we create a converter that takes any array of wrapper objects
 * and converts it to an array of the associated primitive types.
 * <p>
 * Without this tool, we would have to create special case
 * generators for all the primitives.
 */
public class ConvertTo {
    public static boolean[] primitive(Boolean[] in) {
        boolean[] result = new boolean[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i]; // Autounboxing
        return result;
    }

    public static char[] primitive(Character[] in) {
        char[] result = new char[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }

    public static byte[] primitive(Byte[] in) {
        byte[] result = new byte[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }

    public static short[] primitive(Short[] in) {
        short[] result = new short[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }

    public static int[] primitive(Integer[] in) {
        int[] result = new int[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }

    public static long[] primitive(Long[] in) {
        long[] result = new long[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }

    public static float[] primitive(Float[] in) {
        float[] result = new float[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }

    public static double[] primitive(Double[] in) {
        double[] result = new double[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];
        return result;
    }
}
