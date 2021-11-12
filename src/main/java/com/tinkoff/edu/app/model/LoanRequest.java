package com.tinkoff.edu.app.model;

import com.tinkoff.edu.app.enums.PersonEmploymentType;

public class LoanRequest {
    private final PersonEmploymentType type;
    private final int months;
    private final int amount;
    private String firstName;
    private String middleName;
    private String lastName;

    public LoanRequest(PersonEmploymentType type, int months, int amount, String firstName, String middleName, String lastName) {
        this.type = type;
        this.months = months;
        this.amount = amount;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
}