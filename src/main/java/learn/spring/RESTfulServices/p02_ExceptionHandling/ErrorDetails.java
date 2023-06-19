package learn.spring.RESTfulServices.p02_ExceptionHandling;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timestamp;

    private String message;

    private String details;

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
