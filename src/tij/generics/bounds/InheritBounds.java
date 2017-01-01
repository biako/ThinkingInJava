package tij.generics.bounds;

/**
 * Created by Xiaolong on 1/1/2017.
 *
 * Simplified version of BasicBounds using inheritance.
 *
 * Holdltem simply holds an object, so this behavior is inherited
 * into Colored2, which also requires that its parameter conforms
 * to HasColor.
 *
 * ColoredDimension2 and Solid2 further extend the hierarchy
 * and add bounds at each level. Now the methods are inherited
 * and they don’t have to be repeated in each class.
 */

class HoldItem<T> {
    T item;
    HoldItem(T item) { this.item = item; }
    T getItem() { return item; }
}

class Colored2<T extends HasColor> extends HoldItem<T> {
    Colored2(T item) { super(item); }
    java.awt.Color color() { return item.getColor(); }
}

class ColoredDimension2<T extends Dimension & HasColor>
        extends Colored2<T> {
    ColoredDimension2(T item) { super(item); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}

class Solid2<T extends Dimension & HasColor & Weight>
        extends ColoredDimension2<T> {
    Solid2(T item) { super(item); }
    int weight() { return item.weight(); }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 =
                new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}