package tij.enums.switchcase;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p728-729
 *
 * Using switch statements for enums
 *
 */

enum Signal {
    GREEN, YELLOW, RED
}

public class TrafficLight {
    private Signal color = Signal.RED;

    public void change() {
        switch (color) {
            // Note that you don't have to say Signal.RED
            // in the case statement:
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is: " + color;
    }

    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        for (int i = 0; i < 10; i++) {
            System.out.println(tl);

            // Similar effect here:
            System.out.println(tl.color);
            tl.change();

        }
    }


}
