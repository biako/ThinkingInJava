package tij.generics.complexmodels;

import tij.generics.genericinterface.Generator;
import tij.generics.genericinterface.Generators;

import java.util.*;

/**
 * Created by Xiaolong on 12/31/2016.
 *
 * Thinking in Java p461-462
 */


class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        this.price = price;
        //System.out.println(toString());
    }

    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator =
            new Generator<Product>() {
                private Random rand = new Random(47);

                public Product next() {
                    return new Product(rand.nextInt(1000), "Test",
                            Math.round(rand.nextDouble() * 1000.0) + 0.99);
                }
            };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++)
            add(new Shelf(nProducts));
    }
}

class CheckoutStand {
}

class Office {
}


public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts =
            new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++)
            add(new Aisle(nShelves, nProducts));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        int aisleNo = 0, shelfNo = 0, productNo = 0;
        for (Aisle a : this) {
            aisleNo++;
            for (Shelf s : a) {
                shelfNo++;
                for (Product p : s) {
                    productNo++;
                    result.append(aisleNo + "-" + shelfNo + "-" + productNo + ": ");
                    result.append(p);
                    result.append("\n");
                }
                productNo = 0;
            }
            shelfNo = 0;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
    }
}
