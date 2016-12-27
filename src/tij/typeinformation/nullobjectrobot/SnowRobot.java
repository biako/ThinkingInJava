package tij.typeinformation.nullobjectrobot;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiaolong on 12/27/2016.
 */
public class SnowRobot implements Robot {

    private String name;

    public SnowRobot(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public String model() {
        return "SnowBot Series 11";
    }

    public List<Operation> operations() {
        // Will return a List of operation
        return Arrays.asList(
                // Use anonymous classes here to implement the Operation interface,
                // overriding the two methods description() and command().
                new Operation() {
                    public String description() {
                        return name + " can shovel snow";
                    }

                    public void command() {
                        System.out.println(name + " shoveling snow");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + " can chip ice";
                    }

                    public void command() {
                        System.out.println(name + " chipping ice");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + " can clear the roof";
                    }

                    public void command() {
                        System.out.println(name + " clearing roof");
                    }
                }
        );
    }

    public static void main(String[] args) {
        // Use the class static method.
        Robot.Test.test(new SnowRobot("Slusher"));

    }
}
