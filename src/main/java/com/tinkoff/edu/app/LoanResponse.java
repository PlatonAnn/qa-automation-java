package com.tinkoff.edu.app;

public class LoanResponse {
    private LoanResponseType responseType;
    private int requestId;

    public LoanResponse(LoanResponseType responseType, int requestId) {
        this.requestId = requestId;
        this.responseType = responseType;
    }

    public LoanResponseType getResponseType() {
        return responseType;
    }

    public int getRequestId() {
        return requestId;
    }
}
