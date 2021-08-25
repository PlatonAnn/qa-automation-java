package com.tinkoff.edu.app;

public class LoanCalcService {
    /**
     * Loan calculation
     */
    public int createRequest(LoanRequest request) {
        LoanCalcRepository loanCalcRepository = new LoanCalcRepository();
        return loanCalcRepository.save(request);
    }
}
