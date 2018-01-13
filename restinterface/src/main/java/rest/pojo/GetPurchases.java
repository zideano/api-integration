package rest.pojo;

import java.io.Serializable;

public class GetPurchases implements Serializable {
    private String developerId;

    public GetPurchases(String developerId) {
        this.developerId = developerId;
    }

    public GetPurchases() {
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    @Override
    public String toString() {
        return "GetPurchases{" +
                "developerId='" + developerId + '\'' +
                '}';
    }
}
