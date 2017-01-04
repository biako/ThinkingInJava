package tij.enums.constantspecific;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Xiaolong on 1/4/2017.
 *
 * Thinking in Java p.740-741
 *
 * Example of constant specific method:
 *
 * Define one or more abstract methods as part of the enum,
 * then define the methods for each enum instance.
 *
 * You can look up and call methods via their associated enum instance.
 * This is often called table-driven code (and note the similarity to
 * the aforementioned Command pattern).
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return
                    DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    // define
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values())
            System.out.println(csm.getInfo());
    }
}
