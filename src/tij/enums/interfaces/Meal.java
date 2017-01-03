package tij.enums.interfaces;

/**
 * Created by Xiaolong on 1/3/2017.
 *
 * Thinking in Java p735
 *
 *
 */
public class Meal {
    public static void main(String[] args) {
        // Altogether 5 meals
        for (int i = 0; i < 5; i++) {
            // Traverse all the 4 courses: APPETIZER, MAINCOURSE, DESSERT and COFFEE
            for (Course course : Course.values()) {
                // Will randomly selection from the foods in each course
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}