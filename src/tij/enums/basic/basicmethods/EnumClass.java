package tij.enums.basic.basicmethods;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p725-726
 *
 * Example for the basic methods of Enum
 *
 * I. Enum's methods:
 * (1) values() method:
 * produces an array of the enum constants in the order in which they were declared,
 * so you can use the resulting array in (for example) a foreach loop.
 *
 * II. Enum's elements' methods:
 * (1) ordinal():
 * (2) getDeclaringClass():
 * (3) name() / toString()
 * (4) compareTo(): will return the difference in the ordinal
 * (5) equals()
 * 
 * III. Static methods of Enum
 * (1) public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name)
 *  
 * Produce an enum value from a string name:
 *
 */
enum Shrubbery { GROUND, CRAWLING, HANGING }

public class EnumClass {
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()) {
            // The ordinal( ) method produces an int indicating
            // the declaration order of each enum instance, starting from zero.
            System.out.println(s + " ordinal: " + s.ordinal());

            // The Enum class is Comparable, so there’s a compareTo( ) method, and it is also Serializable.
            System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");

            System.out.println(s.equals(Shrubbery.CRAWLING) + " ");

            // You can always safely compare enum instances using ==,
            // and equals( ) and hashCode( ) are automatically created for you
            System.out.println(s == Shrubbery.CRAWLING);

            // If you call getDeclaringClass( ) on an enum instance, you¡¯ll find out the enclosing enum class.
            System.out.println(s.getDeclaringClass());

            // The name( ) method produces the name exactly as
            // it is declared, and this is what you get with toString( ), as well.
            System.out.println(s.name());

            System.out.println("----------------------");
        }
        
        // Produce an enum value from a string name:
        // "STRING".split(regex) will return a String array:
        for(String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
