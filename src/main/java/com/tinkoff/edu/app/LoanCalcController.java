package com.tinkoff.edu.app;

import com.tinkoff.edu.app.enums.LoanResponseType;
import com.tinkoff.edu.app.exception.AmountDataValidationException;
import com.tinkoff.edu.app.exception.FioLengthsDataValidationException;
import com.tinkoff.edu.app.interfaces.LoanCalculation;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;

import java.util.UUID;

public class LoanCalcController {
    private LoanCalculation loanCalcService;

    public LoanCalcController(LoanCalculation loanCalcService) {
        this.loanCalcService = loanCalcService;
    }

    public void requestValidation(LoanRequest request) throws FioLengthsDataValidationException, AmountDataValidationException {
        if (request.getFirstName().length() + request.getMiddleName().length() + request.getLastName().length() <= 10 ||
                request.getFirstName().length() + request.getMiddleName().length() + request.getLastName().length() >= 100)
            throw new FioLengthsDataValidationException("Некорректная длина ФИО");
        if (request.getAmount() <= 0.01 || request.getAmount() >= 999_999.999)
            throw new AmountDataValidationException("Неверно указана сумма");
        if (request.getMonths() == 0)
            throw new NullPointerException("Не указан срок выдачи кредита");
    }

    /**
     * Validates and logs request
     *
     * @param request
     * @return loanResponse
     */

    public LoanResponse createRequest(LoanRequest request) {
        try {
            requestValidation(request);
        } catch (FioLengthsDataValidationException | AmountDataValidationException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        LoanResponse loanResponse = new LoanResponse(LoanResponseType.ERROR, UUID.randomUUID());
        switch (request.getType()) {
            case PERSON:
                if ((request.getAmount() <= 10_000) & (request.getMonths() <= 12)) {
                    return loanCalcService.loanCalculation(request, LoanResponseType.APPROVED);
                }
                if ((request.getAmount() > 10_000) & (request.getMonths() > 12)) {
                    return loanCalcService.loanCalculation(request, LoanResponseType.DEСLINED);
                }
                break;
            case OOO:
                if (request.getAmount() <= 10_000) {
                    return loanCalcService.loanCalculation(request, LoanResponseType.DEСLINED);
                }
                if ((request.getAmount() > 10_000) & (request.getMonths() < 12)) {
                    return loanCalcService.loanCalculation(request, LoanResponseType.APPROVED);
                }
                if ((request.getAmount() > 10_000) & (request.getMonths() >= 12)) {
                    return loanCalcService.loanCalculation(request, LoanResponseType.DEСLINED);
                }
                break;
            case IP:
                return loanCalcService.loanCalculation(request, LoanResponseType.DEСLINED);
            default:
                throw new IllegalStateException("Unexpected value: " + request.getType());
        }
        return loanResponse;
    }
}


