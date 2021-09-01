package com.tinkoff.edu;

import com.tinkoff.edu.app.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCalcTest {
    private LoanRequest request;
    private LoanCalcController loanCalcController;
    @BeforeEach
    public void init() {
        //Given
        request = new LoanRequest(PersonEmploymentType.SELF_EMPLOYMENT, 10, 1000);
    }

    @Test
    public void shouldGetId1WhenFirstCall() {
        //Given
        loanCalcController = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository()));
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int requestId = response.getRequestId();
        //Then
        assertEquals(1, requestId);
    }

    @Test
    public void shouldGetIncrementedIdWhenAnyCall() {
        //Given
        loanCalcController = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository(5)));
        //When
        LoanResponse response = loanCalcController.createRequest(request);
        int requestId = response.getRequestId();
        //Then
        assertEquals(6, requestId);
    }
}
