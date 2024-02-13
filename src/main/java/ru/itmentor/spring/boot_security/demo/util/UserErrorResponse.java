package ru.itmentor.spring.boot_security.demo.util;

public class UserErrorResponse {

    private String message;

    private long timesStamp;

    public UserErrorResponse(String message, long timesStamp) {
        this.message = message;
        this.timesStamp = timesStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(long timesStamp) {
        this.timesStamp = timesStamp;
    }



}
