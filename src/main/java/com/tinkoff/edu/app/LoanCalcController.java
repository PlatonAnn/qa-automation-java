package com.tinkoff.edu.app;

import com.tinkoff.edu.app.enums.LoanResponseType;
import com.tinkoff.edu.app.interfaces.LoanCalculation;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;

import java.util.UUID;

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
        LoanResponse loanResponse = new LoanResponse(LoanResponseType.ERROR, UUID.randomUUID());
        switch (request.getType()) {
            case PERSON:
                if ((request.getAmount() <= 10_000) & (request.getMonths() <= 12)) {
                    loanResponse = loanCalcService.createRequest(request, LoanResponseType.APPROVED);
                    return loanResponse;
                } else if ((request.getAmount() > 10_000) & (request.getMonths() > 12)) {
                    loanResponse = loanCalcService.createRequest(request, LoanResponseType.DEСLINED);
                    return loanResponse;
                }
                break;
            case OOO:
                if (request.getAmount() <= 10_000) {
                    loanResponse = loanCalcService.createRequest(request, LoanResponseType.DEСLINED);
                    return loanResponse;
                } else if ((request.getAmount() > 10_000) & (request.getMonths() < 12)) {
                    loanResponse = loanCalcService.createRequest(request, LoanResponseType.APPROVED);
                    return loanResponse;
                } else if ((request.getAmount() > 10_000) & (request.getMonths() >= 12)) {
                    loanResponse = loanCalcService.createRequest(request, LoanResponseType.DEСLINED);
                    return loanResponse;
                }
                break;
            case IP:
                loanResponse = loanCalcService.createRequest(request, LoanResponseType.DEСLINED);
                return loanResponse;
            default:
                throw new IllegalStateException("Unexpected value: " + request.getType());
        }
        return loanResponse;
    }
}


