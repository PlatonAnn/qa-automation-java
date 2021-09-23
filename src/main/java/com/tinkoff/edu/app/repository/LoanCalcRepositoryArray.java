package com.tinkoff.edu.app.repository;

import com.tinkoff.edu.app.enums.LoanResponseType;
import com.tinkoff.edu.app.interfaces.LoanCalcRepository;
import com.tinkoff.edu.app.model.LoanRequest;
import com.tinkoff.edu.app.model.LoanResponse;

import java.util.UUID;

public class LoanCalcRepositoryArray implements LoanCalcRepository {
    private UUID requestId;
    LoanResponse[] loanResponseArray = new LoanResponse[100_000];
    LoanRequest[] loanRequestArray = new LoanRequest[100_000];

    public LoanCalcRepositoryArray() {
    }

    public LoanCalcRepositoryArray(UUID requestId) {
        this.requestId = UUID.randomUUID();
    }

    /**
     * Получает статус заявки по UUID
     *
     * @param requestId
     * @return ResponseType
     */

    public LoanResponseType getApplicationStatus(UUID requestId) {
        for (int i = 0; i < loanResponseArray.length; i++) {
            if (loanResponseArray[i] != null) {
                if ((loanResponseArray[i].getRequestId().equals(requestId))) {
                    return loanResponseArray[i].getResponseType();
                }
            }
        }
        return LoanResponseType.ERROR;
    }

    /**
     * Изменяет статус заявки по UUID
     *
     * @param requestId
     * @param responseType
     */

    public void changeApplicationStatus(UUID requestId, LoanResponseType responseType) {
        for (int i = 0; i < loanResponseArray.length; i++) {
            if (loanResponseArray[i] != null) {
                if ((loanResponseArray[i].getRequestId().equals(requestId))) {
                    loanResponseArray[i].setResponseType(responseType);
                }
            }
        }
    }

    /**
     * Сохраняет запрос и ответ в массив
     *
     * @param request
     * @param responseType
     * @return loanResponse
     */

    public LoanResponse save(LoanRequest request, LoanResponseType responseType) {
        requestId = UUID.randomUUID();
        LoanResponse loanResponse = new LoanResponse(responseType, requestId);
        try {
            for (int i = 0; i < loanResponseArray.length; i++) {
                if (loanResponseArray[i] == null) {
                    loanResponseArray[i] = loanResponse;
                    loanRequestArray[i] = request;
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
        return loanResponse;
    }
}
