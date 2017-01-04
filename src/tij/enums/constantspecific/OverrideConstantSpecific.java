package tij.enums.constantspecific;

/**
 * Created by Xiaolong on 1/4/2017.
 *
 * Thinking in Java p.740-741
 *
 * Example of override constant specific method:
 *
 */
public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER {
        void f() { System.out.println("Overridden method"); }
    };
    void f() { System.out.println("default behavior"); }
    public static void main(String[] args) {
        for(OverrideConstantSpecific ocs : values()) {
            System.out.println(ocs + ": ");
            ocs.f();
        }
    }
}