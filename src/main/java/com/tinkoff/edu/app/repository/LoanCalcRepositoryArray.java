package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.interfaces.LoanCalcRepository;
import com.tinkoff.edu.app.model.LoanRequest;

import java.util.UUID;

public class LoanCalcRepositoryArray implements LoanCalcRepository {
    private UUID requestId;
    LoanRequest[] loanRequestArray = new LoanRequest[100_000];

    public LoanCalcRepositoryArray() {
    }

    public LoanCalcRepositoryArray(UUID requestId) {
        this.requestId = UUID.randomUUID();
    }

    /**
     * Persists request
     *
     * @param request
     * @return request id
     */
    public UUID save(LoanRequest request) {
        loanRequestArray[0] = request;
        return requestId;
    }
}
