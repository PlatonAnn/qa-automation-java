package com.tinkoff.edu.app.interfaces;

import com.tinkoff.edu.app.enums.LoanResponseType;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;

public interface LoanCalcRepository {
    LoanResponse save(LoanRequest request, LoanResponseType responseType);
}
