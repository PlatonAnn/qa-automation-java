package com.tinkoff.edu.app.interfaces;

import com.tinkoff.edu.app.model.LoanRequest;

import java.util.UUID;

public interface LoanCalcRepository {
    UUID save(LoanRequest request);
}
