package com.telecom.systemforcallbilling.service.mock;

public class ClientNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
