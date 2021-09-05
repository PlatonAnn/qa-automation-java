package com.tinkoff.edu.app.model;

import com.tinkoff.edu.app.enums.PersonEmploymentType;

public class LoanRequest {
    private final PersonEmploymentType type;
    private final int months;
    private final int amount;
    private String firstname;
    private String middlename;
    private String lastname;

    public LoanRequest(PersonEmploymentType type, int months, int amount, String firstname, String middlename, String lastname) {
        this.type = type;
        this.months = months;
        this.amount = amount;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public int getMonths() {
        return months;
    }

    public int getAmount() {
        return amount;
    }

    public PersonEmploymentType getType() {
        return type;
    }
}