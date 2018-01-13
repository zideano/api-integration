package rest.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillingIntegrationServicesImpl implements Integration {
    private static final Logger LOGGER = Logger.getLogger(BillingIntegrationServicesImpl.class.getName());

    private static final String POST = "POST";
    private static final String GET = "GET";
    private URL url;

    private String webAddress = "http://sandbox.flexionmobile.com/javachallenge/rest/developer/";

    public static boolean isConsumed = false;
    public static String ID = null;
    public static String itemId = null;

    private Purchase purchase;
    private List<Purchase> purchaseList;
    private ObjectMapper objectMapper;

    public BillingIntegrationServicesImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.purchaseList = new ArrayList<Purchase>();
    }

    public Purchase buy(String s) {
        try {

            // Get a connection object and set default resource parameters
            url = new URL(webAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(POST);
            connection.setRequestProperty("Content-Type", "application/json");

            // Output stream for POSTing data to the REST API
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(1);
            outputStream.flush();

            // Check that a connection have been created
            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Connection failed: " + connection.getResponseCode());
            }

            //


            //  Disconnect
            connection.disconnect();
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE,"URL address format incorrect.");
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Failed HTTPS connection.");
            e.printStackTrace();
        }

        return purchase;
    }

    public List<Purchase> getPurchases() {
        // Read all purchases and return a list of purchases

        return purchaseList;
    }

    public void consume(Purchase purchase) {

        purchaseList.add(purchase);
    }
}
