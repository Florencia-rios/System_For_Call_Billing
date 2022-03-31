package com.telecom.systemforcallbilling.entity;

import java.time.LocalDateTime;


public interface ICall {

    /**
     * @return the clientId
     */
    String getClientId();

    /**
     * @return the callId
     */
    String getCallId();

    /**
     * @return the dateTime
     */
    LocalDateTime getDateTime();

    /**
     * @return the duration
     */
    int getDuration();

    /**
     * @return the localOrInternational
     */
    String getLocalOrInternational();

}
