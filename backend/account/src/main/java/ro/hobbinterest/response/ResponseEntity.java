package ro.hobbinterest.response;

public class ResponseEntity<T> {

    private T response;
    private int status;

    public ResponseEntity(final int status) {
        this.status = status;
    }

     public ResponseEntity(final int status, final T response) {
        this.response = response;
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public int getStatus() {
        return status;
    }

}
