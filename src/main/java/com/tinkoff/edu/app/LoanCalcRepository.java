package com.tinkoff.edu.app;

public class LoanCalcRepository {
    private static int requestId;

    /**
     * TODO persists request
     *
     * @return request id
     */
    public static int save() {
        return ++requestId;
    }
}
