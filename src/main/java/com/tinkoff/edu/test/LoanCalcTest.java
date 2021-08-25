package com.tinkoff.edu.test;

import com.tinkoff.edu.app.LoanCalcController;
import com.tinkoff.edu.app.LoanRequest;
import com.tinkoff.edu.app.PersonEmployment;

/**
 * Loan Calc Test
 */
public class LoanCalcTest {
    public static void main(String... args) {
        LoanRequest request = new LoanRequest(PersonEmployment.SELF_EMPLOYMENT, 10, 1000);
        LoanCalcController loanCalcController = new LoanCalcController();
        int requestId = loanCalcController.createRequest(request);
        System.out.println(request);
        System.out.println(requestId + " must be 1");
    }
}
