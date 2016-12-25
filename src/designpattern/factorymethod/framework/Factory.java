package designpattern.factorymethod.framework;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);


}
