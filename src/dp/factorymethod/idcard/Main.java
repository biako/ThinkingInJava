package dp.factorymethod.idcard;

import dp.factorymethod.framework.Factory;
import dp.factorymethod.framework.Product;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class Main {
    public static void test() {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Owner1");
        Product card2 = factory.create("Owner2");
        Product card3 = factory.create("Owner3");
        card1.use();
        card2.use();
        card3.use();
        System.out.println(((IDCardFactory)factory).getOwnerList());
    }
}

