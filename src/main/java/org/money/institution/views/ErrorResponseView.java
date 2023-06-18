package org.money.institution.views;

public class ErrorResponseView implements IResponseView {

    private String message;

    public ErrorResponseView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorResponseView from(String message) {
        return new ErrorResponseView(message);
    }

}
