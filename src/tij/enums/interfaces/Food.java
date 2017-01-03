package tij.enums.interfaces;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p734
 *
 * Example of categorization of enums under the same interface.
 *
 * You can achieve categorization by grouping the elements together
 * inside an interface and creating an enumeration based on that interface.
 *
 *
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO;
    }
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
