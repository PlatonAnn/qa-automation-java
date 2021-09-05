package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.model.LoanRequest;

public class LoanCalcRepositoryVariable {
    //        implements LoanCalcRepository
    private int requestId = 0;

    public LoanCalcRepositoryVariable() {
    }

    public LoanCalcRepositoryVariable(int requestId) {
        this.requestId = requestId;
    }

    /**
     * Persists request
     *
     * @param request
     * @return request id
     */
    public int save(LoanRequest request) {
        return ++requestId;
    }
}
