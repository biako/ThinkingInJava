package tij.generics.genericinterface;

/**
 * Created by Xiaolong on 12/29/2016.
 *
 * Pay attention to:
 *  (1) private static long counter = 0;
 * (2) private final long id - counter++;
 */
public class Coffee {
    // Counter is static and will add one upon new instantiation.
    private static long counter = 0;
    // Note! The first ID is 0.
    private final long id = counter++;

    @Override
    public String toString() {
        return id + " " + this.getClass().getSimpleName();
    }
}
