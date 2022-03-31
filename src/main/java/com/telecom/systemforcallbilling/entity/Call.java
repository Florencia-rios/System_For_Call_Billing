package com.telecom.systemforcallbilling.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CALL")
public class Call implements ICall {

	// buscar el constrain de usuario
    @Column(name = "CLIENT_ID")
    private String clientId;
    @Id
    @Column(name = "CALL_ID")
    private String callId;
    
    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime;
    @Column(name = "DURATION")
    private int duration;
    @Column(name = "LOCAL_OR_INTERNATIONAL")
    private String localOrInternational;

    /**
     * 
     */
    public Call() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.telecom.systemforcallbilling.call.ICall#getClientId()
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.telecom.systemforcallbilling.call.ICall#getCallId()
     */
    public String getCallId() {
        return callId;
    }

    /**
     * @param callId the callId to set
     */
    public void setCallId(String callId) {
        this.callId = callId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.telecom.systemforcallbilling.call.ICall#getDateTime()
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.telecom.systemforcallbilling.call.ICall#getDuration()
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.telecom.systemforcallbilling.call.ICall#getLocalOrInternational()
     */
    public String getLocalOrInternational() {
        return localOrInternational;
    }

    /**
     * @param localOrInternational the localOrInternational to set
     */
    public void setLocalOrInternational(String localOrInternational) {
        this.localOrInternational = localOrInternational;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((callId == null) ? 0 : callId.hashCode());
        result = prime * result
                + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = prime * result + duration;
        result = prime * result + ((localOrInternational == null) ? 0
                : localOrInternational.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Call other = (Call) obj;
        if (callId == null) {
            if (other.callId != null) {
                return false;
            }
        } else if (!callId.equals(other.callId)) {
            return false;
        }
        if (dateTime == null) {
            if (other.dateTime != null) {
                return false;
            }
        } else if (!dateTime.equals(other.dateTime)) {
            return false;
        }
        if (duration != other.duration) {
            return false;
        }
        if (localOrInternational == null) {
            if (other.localOrInternational != null) {
                return false;
            }
        } else if (!localOrInternational.equals(other.localOrInternational)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Call [callId=" + callId + ", dateTime=" + dateTime
                + ", duration=" + duration + ", localOrInternational="
                + localOrInternational + "]";
    }

}
