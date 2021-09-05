package com.tinkoff.edu.app.model;

import com.tinkoff.edu.app.enums.LoanResponseType;

import java.util.UUID;

public class LoanResponse {
    private LoanResponseType responseType;
    private UUID requestId;

    public LoanResponse(LoanResponseType responseType, UUID requestId) {
        this.requestId = requestId;
        this.responseType = responseType;
    }

    public LoanResponseType getResponseType() {
        return responseType;
    }

    public UUID getRequestId() {
        return requestId;
    }
}
