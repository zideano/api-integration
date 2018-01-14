package rest.services.impl;

import com.flexionmobile.codingchallenge.integration.Purchase;

import java.util.logging.Logger;

public class PurchaseImpl implements Purchase {
    private static final Logger LOGGER = Logger.getLogger(PurchaseImpl.class.getName());

    private String id;
    private boolean consumed;
    private String itemId;
//
//    public PurchaseImpl(String id, boolean consumed, String itemId) {
//        this.id = id;
//        this.consumed = consumed;
//        this.itemId = itemId;
//    }

    public void setId(String id) {
        this.id = id;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public void setItemID(String itemID) {
        this.itemId = itemID;
    }

    public String getId() {
        return id;
    }

    public boolean getConsumed() {
        return consumed;
    }

    public String getItemId() {
        return itemId;
    }
}
