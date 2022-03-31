package com.telecom.systemforcallbilling.typesOfCalls;

import com.telecom.systemforcallbilling.entity.ICall;

public class CostOfWeekendCall extends CostOfCall {

    @Override
    public double costOfCall(ICall call) {
        calculateCostForCall(call, 0.01);
        return 0;
    }

}
