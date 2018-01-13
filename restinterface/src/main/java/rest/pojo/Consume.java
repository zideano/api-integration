package rest.pojo;

import java.io.Serializable;

public class Consume implements Serializable {
    private String developerId;
    private String purchaseId;

    public Consume(String developerId, String purchaseId) {
        this.developerId = developerId;
        this.purchaseId = purchaseId;
    }

    public Consume() {
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

    @Override
    public String toString() {
        return "Consume{" +
                "developerId='" + developerId + '\'' +
                ", purchaseId='" + purchaseId + '\'' +
                '}';
    }
}
