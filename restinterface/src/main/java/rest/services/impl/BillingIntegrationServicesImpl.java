package rest.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import rest.enums.HttpResponseCode;
import rest.pojo.Purchases;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
    private HttpURLConnection connection;

    private String webAddress = "http://sandbox.flexionmobile.com/javachallenge/rest/developer/";

    private boolean isConsumed;
    private static String devID = "jermaine";
    private static String itemId;

    private PurchaseImpl purchase;
    private Purchases purchases;
    private List<Purchase> purchaseList;
    private ObjectMapper objectMapper;

    public BillingIntegrationServicesImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.purchaseList = new ArrayList<Purchase>();
        isConsumed = false;
        purchase = new PurchaseImpl();
        purchases= new Purchases();
    }

    public Purchase buy(String s) {
        itemId = s;

        try {
            // Get a connection object and set default resource parameters
            url = new URL(webAddress + devID + "/" + "buy" + "/" + itemId);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(POST);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // Initiate POST request
            connection.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.writeBytes(devID + "/" + "buy" + "/" + itemId);
            writer.flush();
            writer.close();

            if (connection.getResponseCode() == HttpResponseCode.ERROR.getResponse())  {
                LOGGER.log(Level.INFO, "Connection error: " + connection.getResponseMessage());
                throw new RuntimeException("Connection failed: " + connection.getResponseCode());
            } else if (connection.getResponseCode() == HttpResponseCode.SUCCESS.getResponse()) {
                LOGGER.info("Connection successful: " + connection.getResponseCode());
            }

            // Return json payload from REST API
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String result;
            LOGGER.info("Reading data from server [POST]: " + connection.getURL());

            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);

                purchase = objectMapper.readValue(result, PurchaseImpl.class);
            }

            //  Disconnect???
            connection.disconnect();
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE,"URL address format incorrect: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }

        return purchase;
    }

    public List<Purchase> getPurchases() {
        // Read all purchases and return a list of purchases

        try {
            // Get a connection object and set default resource parameters
            url = new URL(webAddress + devID + "/" + "all");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GET);
            connection.setRequestProperty("Accept", "application/json");

            // Check that a connection have been created
            if (connection.getResponseCode() != HttpResponseCode.SUCCESS.getResponse()) {
                throw new RuntimeException("Connection failed: " + connection.getResponseCode());
            } else if (connection.getResponseCode() == HttpResponseCode.ERROR.getResponse())  {
                LOGGER.log(Level.INFO, connection.getResponseMessage());
            }

            // Return json payload from REST API
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String result;
            LOGGER.info("Reading data from server [GET]: " + connection.getURL());

            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);

                purchases = objectMapper.readValue(result, Purchases.class);
            }

            //  Disconnect???
            connection.disconnect();
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE,"URL address format incorrect: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }

        return purchaseList;
    }

    public void consume(Purchase purchase) {
        itemId = purchase.getItemId();

        try {
            // Get a connection object and set default resource parameters
            url = new URL(webAddress + devID + "/" + "consume" + "/" + purchase.getId());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(POST);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // Initiate post request
            connection.setDoOutput(true);
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
            writer.writeBytes(devID + "/" + "buy" + "/" + itemId);
            writer.flush();
            writer.close();

            if (connection.getResponseCode() == HttpResponseCode.ERROR.getResponse())  {
                LOGGER.log(Level.INFO, "Connection error: " + connection.getResponseMessage());
                throw new RuntimeException("Connection failed: " + connection.getResponseCode());
            } else if (connection.getResponseCode() == HttpResponseCode.SUCCESS.getResponse()) {
                LOGGER.info("Connection successful: " + connection.getResponseCode());
            }

            //  Disconnect???
            connection.disconnect();
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE,"URL address format incorrect.");
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
