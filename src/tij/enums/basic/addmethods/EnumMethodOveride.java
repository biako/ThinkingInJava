package tij.enums.basic.addmethods;

/**
 * Created by Xiaolong on 1/3/2017.
 * <p>
 * Thinking in Java p728
 * <p>
 * Example to show how to override methods
 */
enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    // toString() of the entire enum is overridden:
    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

}

public class EnumMethodOveride {
    public static void main(String[] args) {
        for (SpaceShip s : SpaceShip.values()) {
            System.out.println(s);
        }
    }
}
