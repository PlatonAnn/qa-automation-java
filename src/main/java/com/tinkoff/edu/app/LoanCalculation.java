package com.tinkoff.edu.app;

public interface LoanCalculation {
    LoanResponse loanCalculation(LoanRequest request, LoanResponseType responseType);
}
