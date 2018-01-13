package rest.pojo;

public class Buy {
    private String developerId;
    private String itemId;

    public Buy(String developerId, String itemId) {
        this.developerId = developerId;
        this.itemId = itemId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
