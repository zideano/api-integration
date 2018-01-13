package rest.enums;

public enum HttpResponseCode {
    SUCCESS(200),
    ERROR(404);

    private Integer response;

    HttpResponseCode(Integer response) {
        this.response = response;
    }

    public Integer getResponse() {
        return response;
    }
}
