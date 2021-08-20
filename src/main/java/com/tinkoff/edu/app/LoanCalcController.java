package com.tinkoff.edu.app;

/**
 *
 */
public class LoanCalcController {
    /**
     * TODO Validates and logs request
     */
    public int createRequest(LoanRequest request) {
        LoanCalcService loanCalcService = new LoanCalcService();
        return loanCalcService.createRequest(request);
    }
}
