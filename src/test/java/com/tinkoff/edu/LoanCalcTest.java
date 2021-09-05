package com.tinkoff.edu;

import com.tinkoff.edu.app.*;
import com.tinkoff.edu.app.enums.LoanResponseType;
import com.tinkoff.edu.app.enums.PersonEmploymentType;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;
import com.tinkoff.edu.app.repository.LoanCalcRepositoryArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCalcTest {
    private LoanRequest request;
    private LoanCalcController loanCalcController;

    @BeforeEach
    public void init() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 10, 1000, "Лев", "Николаевич", "Толстой");
        loanCalcController = new LoanCalcController(new LoanCalcService(new LoanCalcRepositoryArray()));
    }

    @Test
    public void shouldGetResponseApproveWhenPersonRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.PERSON, 12, 10_000, "Гена", "Петрович", "Пупыркин");
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualResponseType = response.getResponseType();
        LoanResponseType expectedResponseType = LoanResponseType.APPROVED;
        //Then
        assertEquals(expectedResponseType, actualResponseType);
    }

    @Test
    public void shouldGetResponseDeclinedWhenPersonRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.PERSON, 13, 10_001, "Гена", "Петрович", "Пупыркин");
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualResponseType = response.getResponseType();
        LoanResponseType expectedResponseType = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedResponseType, actualResponseType);
    }

    @Test
    public void shouldGetResponseApproveWhenOOORequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 11, 10_001, "Гена", "Петрович", "Пупыркин");
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualResponseType = response.getResponseType();
        LoanResponseType expectedResponseType = LoanResponseType.APPROVED;
        //Then
        assertEquals(expectedResponseType, actualResponseType);
    }

    @Test
    public void shouldGetResponseDeclinedWhenOOORequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 666, 10_000, "Гена", "Петрович", "Пупыркин");
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualResponseType = response.getResponseType();
        LoanResponseType expectedresponseType = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedresponseType, actualResponseType);
    }

    @Test
    public void shouldGetResponseDeclinedWhenOOORequeston12months() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 12, 10_001, "Гена", "Петрович", "Пупыркин");
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualResponseType = response.getResponseType();
        LoanResponseType expectedResponseType = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedResponseType, actualResponseType);
    }

    @Test
    public void shouldGetResponseDeclinedWhenIPRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.IP, 78, 890988, "Гена", "Петрович", "Пупыркин");
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualResponseType = response.getResponseType();
        LoanResponseType expectedResponseType = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedResponseType, actualResponseType);
    }
}

