package com.tinkoff.edu.app;

public class LoanCalcController {
    private LoanCalculation loanCalcService;

    public LoanCalcController(LoanCalculation loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    /**
     * Validates and logs request
     *
     * @param request
     * @return loanResponse
     */
    public LoanResponse createRequest(LoanRequest request) {
        LoanResponse loanResponse = new LoanResponse(LoanResponseType.ERROR, -1);
        if (request.getMonths() <= 0 || request.getAmount() <= 0) {
            return loanResponse;
        } else if (((request.getType() == PersonEmploymentType.PERSON)
                & (request.getAmount() <= 10_000)
                & (request.getMonths() <= 12))
                || ((request.getType() == PersonEmploymentType.OOO)
                & (request.getAmount() > 10_000)
                & (request.getMonths() < 12))) {
            loanResponse = loanCalcService.createRequest(request, LoanResponseType.APPROVED);
            return loanResponse;
        } else if (((request.getType() == PersonEmploymentType.PERSON)
                & (request.getAmount() > 10_000)
                & (request.getMonths() > 12))
                || ((request.getType() == PersonEmploymentType.OOO)
                & (request.getAmount() <= 10_000))
                || ((request.getType() == PersonEmploymentType.OOO)
                & (request.getAmount() > 10_000)
                & (request.getMonths() >= 12))
                || (request.getType() == PersonEmploymentType.IP)) {
            loanResponse = loanCalcService.createRequest(request, LoanResponseType.DEСLINED);
            return loanResponse;
        }
        return loanResponse;
    }
}

