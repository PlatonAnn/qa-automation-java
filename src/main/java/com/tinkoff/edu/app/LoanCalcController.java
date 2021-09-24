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
        boolean isPersonApproved = (request.getType() == PersonEmploymentType.PERSON)
                & (request.getAmount() <= 10_000)
                & (request.getMonths() <= 12);
        boolean isOOOApproved = ((request.getType() == PersonEmploymentType.OOO)
                & (request.getAmount() > 10_000)
                & (request.getMonths() < 12));
        boolean isPersonDeclined = ((request.getType() == PersonEmploymentType.PERSON)
                & (request.getAmount() > 10_000)
                & (request.getMonths() > 12));
        boolean isOOODeclined = ((request.getType() == PersonEmploymentType.OOO)
                & (request.getAmount() <= 10_000));
        boolean isOOODeclinedMonths = ((request.getType() == PersonEmploymentType.OOO)
                & (request.getAmount() > 10_000)
                & (request.getMonths() >= 12));
        LoanResponse loanResponse = new LoanResponse(LoanResponseType.ERROR, -1);

        if (request.getMonths() <= 0 || request.getAmount() <= 0) {
            return loanResponse;
        } if (isPersonApproved || isOOOApproved) {
            return loanCalcService.loanCalculation(request, LoanResponseType.APPROVED);
        } if (isPersonDeclined || isOOODeclined || isOOODeclinedMonths
                || (request.getType() == PersonEmploymentType.IP)) {
            return loanCalcService.loanCalculation(request, LoanResponseType.DEСLINED);
        }
        return loanResponse;
    }
}

