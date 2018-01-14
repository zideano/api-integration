package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexionmobile.codingchallenge.integration.Purchase;
import org.w3c.dom.stylesheets.LinkStyle;
import rest.pojo.Buy;
import rest.pojo.Consume;
import rest.pojo.GetPurchases;
import rest.services.impl.BillingIntegrationServicesImpl;
import rest.services.impl.PurchaseImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Start {
    private static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    private static final String developerId = "jermaine";
    private static final String itemId = "sword";
    private static final String purchaseId = "result from buy";

    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger("main");

        // Buy
        Buy buy = new Buy(developerId, itemId);
        buy.setDeveloperId(developerId);
        buy.setItemId(itemId);

        // Consume
        Consume consume = new Consume(developerId, purchaseId);
        consume.setDeveloperId(developerId);

        // Get purchases
        GetPurchases getPurchases = new GetPurchases(developerId);
        getPurchases.setDeveloperId(developerId);

        Purchase purchase;
        List<Purchase> purchaseList;

        ObjectMapper objectMapper = new ObjectMapper();
        BillingIntegrationServicesImpl integrationServices =
                new BillingIntegrationServicesImpl(objectMapper);

        LOGGER.info("Inside main...");

        purchase = integrationServices.buy(itemId);
        System.out.println("Purchase ID from buy operation: " + purchase.getId());

        integrationServices.consume(purchase);
        consume.setPurchaseId(purchase.getId());
        System.out.println("Consuming a single purchase...");

        purchaseList = integrationServices.getPurchases();
        System.out.println("Returning a list of all purchases made on the network...");
        System.out.println(purchaseList);
    }
}
