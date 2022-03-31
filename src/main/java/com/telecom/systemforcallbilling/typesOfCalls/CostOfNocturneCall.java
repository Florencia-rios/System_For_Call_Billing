package com.telecom.systemforcallbilling.typesOfCalls;

import com.telecom.systemforcallbilling.entity.ICall;

public class CostOfNocturneCall extends CostOfCall {

    @Override
    public double costOfCall(ICall call) {
        return calculateCostForCall(call, 0.02);
    }
}
