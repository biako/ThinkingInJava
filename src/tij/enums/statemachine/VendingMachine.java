package tij.enums.statemachine;

import tij.generics.genericinterface.Generator;

import java.util.*;

import static tij.enums.statemachine.Input.*;

/**
 * Created by Xiaolong on 1/4/2017.
 *
 * Thinking in Java p747-750
 *
 * Because selecting among enum instances is most often accomplished with a switch statement (notice the extra effort that the language goes to in order to make a switch on enums easy), one of the most common questions to ask when you are organizing multiple enums is "What do I want to switch on?" Here, it’s easiest to work back from the VendingMachine by noting that in each State, you need to switch on the basic categories of input action: money being inserted, an item being selected, the transaction being aborted, and the machine being turned off. However, within those categories, you have different types of money that can be inserted and different items that can be selected. The Category enum groups the different types of Input so that the categorize( ) method can produce the appropriate Category inside a switch. This method uses an EnumMap to efficiently and safely perform the lookup.
 *
 *
 */
// Creating enum holding the enums by categories:
// Creating a static EnumMap reflecting the mapping relationship
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    // Creating a static EnumMap reflecting the mapping relationship
    // Initializing and putting the enums in the categories into the EnumMap
    private static EnumMap<Input, Category> categories =
            new EnumMap<>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants())
            for (Input type : c.values)
                categories.put(type, c);
    }

    // Will return the category of a given Input by looking up in the EnumMap
    public static Category categorize(Input input) {
        return categories.get(input);
    }
}


/**
 * If you study class VendingMachine, you can see how each state is different, and responds differently to input. Also note the two transient states; in run( ) the machine waits for an Input and doesn't stop moving through states until it is no longer in a transient state.
 The VendingMachine can be tested in two ways, by using two different Generator objects.
 * */
public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT} // Tagging enum

    enum State {
        RESTING {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount())
                            System.out.println("Insufficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println(amount);
        }
    }

    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        // Commenting out the part that reads inputs from a file.
        //if (args.length == 1)
        //    gen = new FileInputGenerator(args[0]);
        run(gen);
    }
}

// For a basic sanity check:
/**
 * The RandomInputGenerator just keeps producing inputs,
 * everything except SHUT_DOWN. By running this for a long
 * time you get a kind of sanity check to help ensure that
 * the machine will not wander into a bad state.
 * */
class RandomInputGenerator implements Generator<Input> {
    public Input next() {
        return Input.randomSelection();
    }
}

/**
 *
 * The FilelnputGenerator takes a file describing inputs in text form,
 * turns them into enum instances, and creates Input objects. Here’s
 * the text file used to produce the output shown above:
 QUARTER; QUARTER; QUARTER; CHIPS;
 DOLLAR; DOLLAR; TOOTHPASTE;
 QUARTER; DIME; ABORT_TRANSACTION;
 QUARTER; DIME; SODA;
 QUARTER; DIME; NICKEL; SODA;
 ABORT_TRANSACTION;
 STOP;
 ///:~
 * */
// Commenting out the part that reads inputs from a file.
// Create Inputs from a file of ‘;’-separated strings:
/*
class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;

    public FileInputGenerator(String fileName) {
        input = new TextFile(fileName, ";").iterator();
    }

    public Input next() {
        if (!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}*/
