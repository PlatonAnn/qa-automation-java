package com.tinkoff.edu.app;

import com.tinkoff.edu.app.enums.LoanResponseType;
import com.tinkoff.edu.app.interfaces.LoanCalcRepository;
import com.tinkoff.edu.app.interfaces.LoanCalculation;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;

import java.util.UUID;

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
        LoanResponse loanResponse = repo.save(request, responseType);
        return loanResponse;
    }
}
