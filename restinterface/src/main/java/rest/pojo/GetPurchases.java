package rest.pojo;

public class GetPurchases {
    private String developerId;

    public GetPurchases(String developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }
}
