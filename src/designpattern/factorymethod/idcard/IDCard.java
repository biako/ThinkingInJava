package designpattern.factorymethod.idcard;

import designpattern.factorymethod.framework.*;
/**
 * Created by Xiaolong on 12/25/2016.
 */
public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {
        this.owner = owner;
        System.out.format("Making %s's ID Card.\n", owner);
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void use() {
        System.out.format("Using %s's ID Card.\n", owner);
    }
}
