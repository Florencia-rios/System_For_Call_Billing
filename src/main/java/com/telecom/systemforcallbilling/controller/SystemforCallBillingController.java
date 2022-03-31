package com.telecom.systemforcallbilling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.telecom.systemforcallbilling.service.SystemforCallBillingService;
import com.telecom.systemforcallbilling.service.mock.ClientNotFoundException;

@Controller
public class SystemforCallBillingController {

    @Autowired
    private SystemforCallBillingService systemforCallBillingService;

    public double totalCostOfCalls(String customerId)
            throws ClientNotFoundException {
        return systemforCallBillingService.totalCostOfCalls(customerId);
    }
}
