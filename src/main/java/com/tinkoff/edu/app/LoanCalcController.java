package com.tinkoff.edu.app;

public class LoanCalcController {
    private LoanCalculation loanCalcService;

    public LoanCalcController(LoanCalculation loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    /**
     * Validates and logs request
     * @param request
     * @return loanResponse
     */
    public LoanResponse createRequest(LoanRequest request) {
        return loanCalcService.createRequest(request);
    }
}

