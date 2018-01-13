package rest.pojo;

public class Consume {
    private String developerId;
    private String purchaseId;

    public Consume(String developerId, String purchaseId) {
        this.developerId = developerId;
        this.purchaseId = purchaseId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }
}
