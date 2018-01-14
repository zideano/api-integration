package rest.enums;

public enum HttpResponseCode {
    SUCCESS(200),
    ERROR(404);

    private int response;

    HttpResponseCode(int response) {
        this.response = response;
    }

    public int getResponse() {
        return response;
    }
}
