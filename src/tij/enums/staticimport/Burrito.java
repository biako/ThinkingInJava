package tij.enums.staticimport;

// Import static for the enum. Do NOT for get the ".*" in the end!!

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p726
 *
 * An example to show how to statically import the enum
 *
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) { this.degree = degree;}
    public String toString() { return "Burrito is "+ degree;}
    public static void main(String[] args) {
        System.out.println(new Burrito(Spiciness.FLAMING));
        System.out.println(new Burrito(Spiciness.MILD));
        System.out.println(new Burrito(Spiciness.MILD));
    }

}
