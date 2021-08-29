package com.tinkoff.edu.app;

public class StaticVariableLoanCalcRepository implements LoanCalcRepository {
    private int requestId = 0;

    public StaticVariableLoanCalcRepository() {

    }
    public StaticVariableLoanCalcRepository(int requestId) {
        this.requestId = requestId;
    }

    /**
     * Persists request
     * @param request
     * @return request id
     */
    public int save(LoanRequest request) {
        return ++requestId;
    }
}
