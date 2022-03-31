package com.telecom.systemforcallbilling.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.telecom.systemforcallbilling.entity.Call;

@Repository
public interface SystemforCallBillingRepository
        extends JpaRepository<Call, String> {

    @Query("SELECT v FROM Call WHERE v.clientId:=customerId")
    public List<Call> searchCallsByClient(
            @Param("customerId") String customerId);

}
