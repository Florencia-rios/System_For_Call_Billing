package com.telecom.systemforcallbilling.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.systemforcallbilling.controller.SystemforCallBillingController;
import com.telecom.systemforcallbilling.service.mock.ClientNotFoundException;

@RequestMapping(value = "api/", produces = "application/json;charset=UTF-8")
@RestController
public class SystemforCallBillingRestController {

    @Autowired
    private SystemforCallBillingController systemforCallBillingController;

    @GetMapping("api/system-call-billing-of-customer/{customerId}")
    public double totalCostOfCalls(
            @PathVariable("customerId") String customerId)
            throws ClientNotFoundException {
        return systemforCallBillingController.totalCostOfCalls(customerId);
    }
}
