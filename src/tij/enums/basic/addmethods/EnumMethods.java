package tij.enums.basic.addmethods;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p727
 *
 */
enum OzWitch {
    // Instances must be defined first, before methods:
    // Using XXX("  ") will call the constructor!!:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy’s house"),
    SOUTH("Good by inference, but missing");

    // Define a private member
    private String description;

    // Constructor must be package or private access:
    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class EnumMethods{
    public static void main(String[] args) {
        for(OzWitch witch : OzWitch.values())
            System.out.println(witch + ": " + witch.getDescription());
    }
}