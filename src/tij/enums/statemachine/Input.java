package tij.enums.statemachine;

import java.util.Random;

/**
 * Created by Xiaolong on 1/4/2017.
 *
 * Thinking in Java p747
 *
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),

    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },

    STOP { // STOP must be the last instance.

        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value; // In cents

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    int amount() {
        return value;
    }

    // In cents
    static Random rand = new Random(System.nanoTime());

    public static Input randomSelection() {
        //Don’t include STOP (STOP is the last instance):
        return values()[rand.nextInt(values().length - 1)];
        //return values()[rand.nextInt(values().length)];
    }
}