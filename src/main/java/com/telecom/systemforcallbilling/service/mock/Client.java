package com.telecom.systemforcallbilling.service.mock;

import org.springframework.stereotype.Component;

@Component
public class Client {

    private static final String THE_CUSTOMER_ID_DON_T_EXIST =
            "The customerId don't exist";

    public boolean isNewClient(String customerId)
            throws ClientNotFoundException {
        boolean isNewClient = false;

        if (customerId.equals("1")) {
            isNewClient = true;
        } else if (customerId.equals("2")) {
            isNewClient = false;
        } else {
            throw new ClientNotFoundException(THE_CUSTOMER_ID_DON_T_EXIST);
        }

        return isNewClient;
    }


}
