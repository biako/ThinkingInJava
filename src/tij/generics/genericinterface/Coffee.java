package tij.generics.genericinterface;

/**
 * Created by Xiaolong on 12/29/2016.
 * <p>
 * Pay attention to:
 * <p>
 * (1) private static long counter = 0;
 * <p>
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
