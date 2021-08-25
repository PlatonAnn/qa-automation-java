package com.tinkoff.edu.app;

public class LoanRequest {
    private final PersonEmployment type;
    private final int months;
    private final int amount;

    public LoanRequest(PersonEmployment type, int months, int amount) {
        this.type = type;
        this.months = months;
        this.amount = amount;
    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        return "RQ: {"
                + this.type + ", "
                + this.getAmount()
                + " for " + getMonths() +
                "}";
    }

}
