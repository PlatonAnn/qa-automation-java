package com.tinkoff.edu.app;

public class LoanCalcRepository {
    private int requestId = 0;

    /**
     * TODO persists request
     *
     * @return request id
     */
    public int save(LoanRequest request) {
        return ++requestId;
    }
}
