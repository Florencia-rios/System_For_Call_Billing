package com.telecom.systemforcallbilling.service;

import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.systemforcallbilling.entity.Call;
import com.telecom.systemforcallbilling.entity.ICall;
import com.telecom.systemforcallbilling.repository.SystemforCallBillingRepository;
import com.telecom.systemforcallbilling.service.mock.Client;
import com.telecom.systemforcallbilling.service.mock.ClientNotFoundException;
import com.telecom.systemforcallbilling.typesOfCalls.CostOfCall;
import com.telecom.systemforcallbilling.typesOfCalls.CostOfNocturneCall;
import com.telecom.systemforcallbilling.typesOfCalls.CostOfRegularCall;
import com.telecom.systemforcallbilling.typesOfCalls.CostOfWeekendCall;

@Service
public class SystemforCallBillingService {

    private static final int _7 = 7;

    private static final int _6 = 6;

    @Autowired
    private Client clientService;

    @Autowired
    private SystemforCallBillingRepository systemforCallBillingRepository;

    CostOfCall costOfCall;

    public double totalCostOfCalls(String customerId)
            throws ClientNotFoundException {

        boolean isNewClient = clientService.isNewClient(customerId);
        double totalCost = 0;

        List<Call> callsOfCustomerId =
                systemforCallBillingRepository.searchCallsByClient(customerId);

        for (ICall call : callsOfCustomerId) {
            initializeCostCalculatorForCall(call, isNewClient);
            totalCost = totalCost + costOfCall.costOfCall(call);
        }

        return totalCost;
    }

    // TODO ver si es necesario hacer una clase factory para darle la
    // responsabilidad de inicializar la subclase correspondiente
    private void initializeCostCalculatorForCall(ICall call,
            boolean isNewClient) {
        int numberOfday =
                call.getDateTime().toLocalDate().getDayOfWeek().getValue();
        LocalTime timeOfCall = call.getDateTime().toLocalTime();

        if (numberOfday == _6 || numberOfday == _7) {
            costOfCall = new CostOfWeekendCall();
        } else if (verifyTimeOfCall(timeOfCall)) {
            costOfCall = new CostOfNocturneCall();
        } else {
            if (isNewClient) {
                costOfCall = new CostOfNocturneCall();
            } else {
                costOfCall = new CostOfRegularCall();
            }
        }
    }

    private boolean verifyTimeOfCall(LocalTime timeOfCall) {
        LocalTime forKnowIFItIsBelow = LocalTime.of(4, 00, 00);
        LocalTime forKnowIFItIsAbove = LocalTime.of(22, 00, 00);

        boolean itIsNight = timeOfCall.isBefore(forKnowIFItIsBelow)
                || timeOfCall.isAfter(forKnowIFItIsAbove);

        return itIsNight;
    }

}
