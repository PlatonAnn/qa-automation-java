package com.tinkoff.edu.app;

public class StaticVariableLoanCalcRepository implements LoanCalcRepository {
    private int requestId = 0;

    /**
     * Persists request
     * @param request
     * @return request id
     */
    public int save(LoanRequest request) {
        return ++requestId;
    }
}
