package com.tinkoff.edu.app;

public class LoanResponse {
    private LoanResponseType responseType;
    private int requestId;
    private LoanRequest request;

    public LoanResponse(int requestId, LoanRequest request) {
        this.requestId = requestId;
        this.request = request;
        this.responseType = LoanResponseType.APPROVED;
    }

    public LoanResponseType getResponseType() {
        return responseType;
    }

    public int getRequestId() {
        return requestId;
    }

    public LoanRequest getRequest() {
        return request;
    }
}
