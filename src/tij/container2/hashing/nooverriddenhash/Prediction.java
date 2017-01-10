package tij.container2.hashing.nooverriddenhash;

/**
 * Created by Xiaolong on 1/10/2017.
 * <p>
 * Thinking in Java p
 */
import java.util.*;
public class Prediction {
    private static Random rand = new Random(47);

    private boolean shadow = rand.nextDouble() > 0.5;

    public String toString() {
        if(shadow)
            return "Six more weeks of Winter!";
        else
            return "Early Spring!";
    }
}