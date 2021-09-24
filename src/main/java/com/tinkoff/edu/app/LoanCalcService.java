package com.tinkoff.edu.app;

public class LoanCalcService implements LoanCalculation {
    private LoanCalcRepository repo;

    public LoanCalcService(LoanCalcRepository repo) {
        this.repo = repo;
    }

    /**
     * Loan calculation, decision-making
     *
     * @param request
     * @return loanResponse
     */
    public LoanResponse loanCalculation(LoanRequest request, LoanResponseType responseType) {
        int requestId = repo.save(request);
        return new LoanResponse(responseType, requestId);
    }
}
