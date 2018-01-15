package rest.pojo;

import java.io.Serializable;
import java.util.Map;

public class Purchases implements Serializable {
    private Map<String, String> purchases;

    public Map<String, String> getPurchases() {
        return purchases;
    }

    public void setPurchases(Map<String, String> purchases) {
        this.purchases = purchases;
    }
}
