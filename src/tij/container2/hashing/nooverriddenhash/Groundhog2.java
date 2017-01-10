package tij.container2.hashing.nooverriddenhash;

/**
 * Created by Xiaolong on 1/10/2017.
 *
 * Thinking in Java p607
 *
 * A revised Groundhog that override hasCode() and equals() to produce correct result.
 *
 */
// A class that’s used as a key in a HashMap
// must override hashCode() and equals().
public class Groundhog2 extends Groundhog {
    // Constructor is the same
    public Groundhog2(int n) { super(n); }

    // Override hashCode(). Simply use number as hashcode
    @Override
    public int hashCode() { return number; }

    // Override equals(). Simply use number to determine and use instanceof to determine the class
    @Override
    public boolean equals(Object o) {
        return o instanceof Groundhog2 &&
                (number == ((Groundhog2)o).number);
    }
}
