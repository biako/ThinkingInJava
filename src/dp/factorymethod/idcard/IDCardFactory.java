package dp.factorymethod.idcard;

import dp.factorymethod.framework.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaolong on 12/25/2016.
 */
public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List<String> getOwnerList (){
        return owners;
    }
}
