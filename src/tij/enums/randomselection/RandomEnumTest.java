package tij.enums.randomselection;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p733
 *
 * Test the Random method in an enum.
 *
 */
enum Activity { SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING }

public class RandomEnumTest {
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++)
            System.out.print(Enums.random(Activity.class) + " ");
    }
}