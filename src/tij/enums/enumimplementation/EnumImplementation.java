package tij.enums.enumimplementation;

import tij.generics.genericinterface.Generator;

import java.util.Random;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p732
 *
 * An example for an enum to implement an interface.
 *
 * All enums extend java.lang.Enum. Since Java does not support multiple inheritance,
 * this means that you cannot create an enum via inheritance
 *
 * This implement interface Generator<T> (which has a method T next())
 *
 */
enum CartoonCharacter
        implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i = 0; i < 10; i++)
            printNext(cc);
    }
}