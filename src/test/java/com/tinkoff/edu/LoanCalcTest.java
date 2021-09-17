package com.tinkoff.edu;

import com.tinkoff.edu.app.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCalcTest {
    private LoanRequest request;
    private LoanCalcController loanCalcController;

    @BeforeEach
    public void init() {
        //Given
        loanCalcController = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository()));
    }

    @Test
    public void shouldGetId1WhenFirstCall() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 10, 1000);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int requestId = response.getRequestId();
        //Then
        assertEquals(1, requestId);
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 10, 1000);
        loanCalcController = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository(5)));
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int requestId = response.getRequestId();
        //Then
        assertEquals(6, requestId);
    }

    @Test
    public void shouldGetErrorWhenApplyNullRequest() {
        //Given
        request = new LoanRequest(null, 0, 0);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int actualrequestId = response.getRequestId();
        //Then
        assertEquals(-1, actualrequestId);
    }

    @Test
    public void shouldGetErrorWhenApplyZeroOrNegativeAmountRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 12, -500);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int actualrequestId = response.getRequestId();
        //Then
        assertEquals(-1, actualrequestId);
    }

    @Test
    public void shouldGetErrorWhenApplyZeroOrNagativeMonthsRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, -5, 25_000);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int actualrequestId = response.getRequestId();
        //Then
        assertEquals(-1, actualrequestId);
    }

    @Test
    public void shouldGetResponseApproveWhenPersonRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.PERSON, 12, 10_000);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualresponsetype = response.getResponseType();
        LoanResponseType expectedresponsetype = LoanResponseType.APPROVED;
        //Then
        assertEquals(expectedresponsetype, actualresponsetype);
    }

    @Test
    public void shouldGetResponseDeclinedWhenPersonRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.PERSON, 13, 10_001);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualresponsetype = response.getResponseType();
        LoanResponseType expectedresponsetype = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedresponsetype, actualresponsetype);
    }

    @Test
    public void shouldGetResponseApproveWhenOOORequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 11, 10_001);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualresponsetype = response.getResponseType();
        LoanResponseType expectedresponsetype = LoanResponseType.APPROVED;
        //Then
        assertEquals(expectedresponsetype, actualresponsetype);
    }

    @Test
    public void shouldGetResponseDeclinedWhenOOORequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 666, 10_000);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualresponsetype = response.getResponseType();
        LoanResponseType expectedresponsetype = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedresponsetype, actualresponsetype);
    }

    @Test
    public void shouldGetResponseDeclinedWhenOOORequeston12months() {
        //Given
        request = new LoanRequest(PersonEmploymentType.OOO, 12, 10_001);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualresponsetype = response.getResponseType();
        LoanResponseType expectedresponsetype = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedresponsetype, actualresponsetype);
    }

    @Test
    public void shouldGetResponseDeclinedWhenIPRequest() {
        //Given
        request = new LoanRequest(PersonEmploymentType.IP, 78, 890988);
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        LoanResponseType actualresponsetype = response.getResponseType();
        LoanResponseType expectedresponsetype = LoanResponseType.DEСLINED;
        //Then
        assertEquals(expectedresponsetype, actualresponsetype);
    }
}

