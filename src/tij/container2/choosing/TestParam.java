package tij.container2.choosing;

/**
 * Created by Xiaolong on 1/21/2017.
 *
 * Thinking in Java p619
 *
 * Each container will undergo a sequence of calls to test( ), each with
 * a different TestParam, so TestParam also contains static array( ) methods
 * that make it easy to create arrays of TestParam objects. The first version
 * of array( ) takes a variable argument list containing alternating size and
 * loops values, and the second version takes the same kind of list except that
 * the values are inside Strings — this way, it can be used to parse commandline
 * arguments.
 *
 *
 */
public class TestParam {
    public final int size;
    public final int loops;

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    // Create an array of TestParam from a varargs sequence:
    public static TestParam[] array(int... values) {
        int size = values.length/2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for(int i = 0; i < size; i++)
            result[i] = new TestParam(values[n++], values[n++]);
        return result;
    }

    // Convert a String array to a TestParam array:
    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for(int i = 0; i < vals.length; i++)
            vals[i] = Integer.decode(values[i]);
        return array(vals);
    }
}
