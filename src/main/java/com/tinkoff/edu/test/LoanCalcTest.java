package com.tinkoff.edu.test;

import com.tinkoff.edu.app.*;

public class LoanCalcTest {

    /**
     * Loan Calc Test
     * @param args
     */
    public static void main(String... args) {
        LoanRequest request = new LoanRequest(PersonEmploymentType.SELF_EMPLOYMENT, 10, 1000);
        LoanCalcController loanCalcController = new LoanCalcController(new LoanCalcService(new StaticVariableLoanCalcRepository()));
        LoanResponse response = loanCalcController.createRequest(request);
        int requestId = response.getRequestId();
        System.out.println(request);
        System.out.println(requestId + " must be 1");
    }
}
