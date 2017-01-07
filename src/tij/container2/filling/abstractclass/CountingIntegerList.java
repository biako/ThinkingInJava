package tij.container2.filling.abstractclass;
import java.util.*;
/**
 * Created by Xiaolong on 1/7/2017.
 * <p>
 * Thinking in Java p578
 *
 * List of any length, containing sample data.
 */


public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    public int size() { return size; }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}