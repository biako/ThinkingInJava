package tij.typeinformation.nullobjectrobot;

import tij.typeinformation.nullobjectposition.Null;

import java.util.List;

/**
 * Created by Xiaolong on 12/27/2016.
 */
public interface Robot {
    String name();
    String model();
    List<Operation> operations();

    // Include a class for testing. Will list its name, model and operations.
    class Test {
        public static void test(Robot r) {
            // Imported the Null interface.
            if(r instanceof Null)
                System.out.println("[Null Robot]");
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for(Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
