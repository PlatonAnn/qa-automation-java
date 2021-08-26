package com.tinkoff.edu.app;

public class LoanCalcService implements LoanCalculation {
    private LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * Loan calculation, decision-making
     * @param request
     * @return loanResponse
     */
    public LoanResponse createRequest(LoanRequest request) {
        int requestId = repo.save(request);
        LoanResponse loanResponse = new LoanResponse(requestId, request);
        return loanResponse;
    }
}
