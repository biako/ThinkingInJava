package tij.enums.valuemethod;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p731
 *
 * (1) values() is not part of the interface of Enum
 *
 * (2) enum1.getClass().getEnumConstants(): will return an array of Enum
 *
 * There is a getEnumConstants( ) method in Class,
 * so even if values( ) is not part of the interface of Enum,
 * you can still get the enum instances via the Class object:
 *
 */
enum Search {
    HITHER, YON
}

public class EnumConstants {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast
        // e.values(); // No values() in Enum
        for (Enum en : e.getClass().getEnumConstants())
            System.out.println(en);

        // getEnumConstants is not applicable to Non-enums:
        System.out.println(String.class.getEnumConstants());
    }
}
