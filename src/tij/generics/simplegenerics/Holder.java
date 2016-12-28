package tij.generics.simplegenerics;

/**
 * Created by Xiaolong on 12/28/2016.
 *
 * Thinking in Java p441
 */
class Automobile {
    private String model;

    public Automobile() {
        this.model = "unidentified";
    }

    public Automobile(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void printModel() {
        System.out.println(model);
    }

    @Override
    public String toString() {
        return "Automobile" + model;
    }
}

public class Holder<T> {
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder<Automobile> holder = new Holder<>(new Automobile());
        Automobile a = holder.get();
        a.printModel();
        a.setModel("Benz");
        a.printModel();
        holder.set(a);
    }
}
