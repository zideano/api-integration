package rest.services.impl;

import com.flexionmobile.codingchallenge.integration.Purchase;

import java.util.logging.Logger;

public class PurchaseImpl implements Purchase {
    private static final Logger LOGGER = Logger.getLogger(PurchaseImpl.class.getName());

    public String getId() {
        return BillingIntegrationServicesImpl.ID;
    }

    public boolean getConsumed() {
        return BillingIntegrationServicesImpl.isConsumed;
    }

    public String getItemId() {
        return BillingIntegrationServicesImpl.itemId;
    }
}
