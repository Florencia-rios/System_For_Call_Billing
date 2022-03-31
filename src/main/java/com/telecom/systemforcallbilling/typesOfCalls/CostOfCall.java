package com.telecom.systemforcallbilling.typesOfCalls;

import com.telecom.systemforcallbilling.entity.ICall;

public abstract class CostOfCall {

    public abstract double costOfCall(ICall call);

    public double calculateCostForCall(ICall call, double costOfCall) {
        double costForCall = call.getDuration() * costOfCall
                * multiplyingByAdditionalCost(call);
        return costForCall;
    }

    private double multiplyingByAdditionalCost(ICall call) {
        double multiplyingByAdditionalCost = 1;
        if (call.getLocalOrInternational().equals("I")) {
            multiplyingByAdditionalCost = 2;
        }
        return multiplyingByAdditionalCost;
    }

}
