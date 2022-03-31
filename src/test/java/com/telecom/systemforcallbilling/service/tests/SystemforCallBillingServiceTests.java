package com.telecom.systemforcallbilling.service.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import com.telecom.systemforcallbilling.entity.Call;
import com.telecom.systemforcallbilling.repository.SystemforCallBillingRepository;
import com.telecom.systemforcallbilling.service.SystemforCallBillingService;
import com.telecom.systemforcallbilling.service.mock.ClientNotFoundException;

@SpringBootTest
@TestPropertySource({"classpath:application.properties"})
public class SystemforCallBillingServiceTests {

    @Autowired
    SystemforCallBillingService systemforCallBillingService;

    @MockBean
    SystemforCallBillingRepository systemforCallBillingRepository;

    @Test
    public void whenIsANewClientThenReturnTotalCostLikeCorrespondingDiscountOnRegularCallAndLocalCall()
            throws ClientNotFoundException {

        // set up
        String customerId = "1";
        double totalCostExpected = 0.2;
        List<Call> customerCalls = new ArrayList<Call>();
        Call regularCall = new Call();

        LocalTime time = LocalTime.of(11, 00, 00);
        LocalDate date = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        regularCall.setClientId(customerId);
        regularCall.setCallId("1");
        regularCall.setDateTime(dateTime);
        regularCall.setDuration(10);
        regularCall.setLocalOrInternational("L");
        customerCalls.add(regularCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsAExistingClientThenReturnTotalCostLikeCorrespondingInRegularAndLocalCall()
            throws ClientNotFoundException {

        // set up
        String customerId = "2";
        double totalCostExpected = 0.5;
        List<Call> customerCalls = new ArrayList<Call>();
        Call regularCall = new Call();

        LocalTime time = LocalTime.of(11, 00, 00);
        LocalDate date = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        regularCall.setClientId(customerId);
        regularCall.setCallId("1");
        regularCall.setDateTime(dateTime);
        regularCall.setDuration(10);
        regularCall.setLocalOrInternational("L");
        customerCalls.add(regularCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsAClientThenReturnTotalCostLikeCorrespondingInNocturnesAndLocalsCalls()
            throws ClientNotFoundException {

        // set up
        String customerId = "1";
        double totalCostExpected = 0.6;
        List<Call> customerCalls = new ArrayList<Call>();
        Call firstNocturneCall = new Call();

        LocalTime timeForAFirstCall = LocalTime.of(4, 00, 00);
        LocalDate dateForAFirstCall = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTimeForAFirstCall =
                LocalDateTime.of(dateForAFirstCall, timeForAFirstCall);

        firstNocturneCall.setClientId(customerId);
        firstNocturneCall.setCallId("1");
        firstNocturneCall.setDateTime(dateTimeForAFirstCall);
        firstNocturneCall.setDuration(10);
        firstNocturneCall.setLocalOrInternational("L");

        Call secondNocturneCall = new Call();

        LocalTime timeForASecondCall = LocalTime.of(23, 00, 00);
        LocalDate dateForASecondCall = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTimeForASecondCall =
                LocalDateTime.of(dateForASecondCall, timeForASecondCall);

        secondNocturneCall.setClientId(customerId);
        secondNocturneCall.setCallId("2");
        secondNocturneCall.setDateTime(dateTimeForASecondCall);
        secondNocturneCall.setDuration(20);
        secondNocturneCall.setLocalOrInternational("L");

        customerCalls.add(firstNocturneCall);
        customerCalls.add(secondNocturneCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsAClientThenReturnTotalCostLikeCorrespondingInWeekendAndLocalCall()
            throws ClientNotFoundException {

        // set up
        String customerId = "1";
        double totalCostExpected = 0.1;
        List<Call> customerCalls = new ArrayList<Call>();
        Call weekendCall = new Call();

        LocalTime time = LocalTime.of(11, 00, 00);
        LocalDate date = LocalDate.of(2022, Month.MARCH, 27);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        weekendCall.setClientId(customerId);
        weekendCall.setCallId("1");
        weekendCall.setDateTime(dateTime);
        weekendCall.setDuration(10);
        weekendCall.setLocalOrInternational("L");
        customerCalls.add(weekendCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsANewClientThenReturnDuplicateTotalCostForRegularAndInternationalCall()
            throws ClientNotFoundException {

        // set up
        String customerId = "1";
        double totalCostExpected = 0.4;
        List<Call> customerCalls = new ArrayList<Call>();
        Call regularCall = new Call();

        LocalTime time = LocalTime.of(11, 00, 00);
        LocalDate date = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        regularCall.setClientId(customerId);
        regularCall.setCallId("1");
        regularCall.setDateTime(dateTime);
        regularCall.setDuration(10);
        regularCall.setLocalOrInternational("I");
        customerCalls.add(regularCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsAExistingClientThenReturnDuplicateTotalCostForRegularAndInternationalCall()
            throws ClientNotFoundException {

        // set up
        String customerId = "2";
        double totalCostExpected = 1;
        List<Call> customerCalls = new ArrayList<Call>();
        Call regularCall = new Call();

        LocalTime time = LocalTime.of(11, 00, 00);
        LocalDate date = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        regularCall.setClientId(customerId);
        regularCall.setCallId("1");
        regularCall.setDateTime(dateTime);
        regularCall.setDuration(10);
        regularCall.setLocalOrInternational("I");
        customerCalls.add(regularCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsAClientThenReturnTotalCostLikeCorrespondingInNocturnesAndInternationalsCalls()
            throws ClientNotFoundException {

        // set up
        String customerId = "1";
        double totalCostExpected = 1.2;
        List<Call> customerCalls = new ArrayList<Call>();
        Call firstNocturneCall = new Call();

        LocalTime timeForAFirstCall = LocalTime.of(4, 00, 00);
        LocalDate dateForAFirstCall = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTimeForAFirstCall =
                LocalDateTime.of(dateForAFirstCall, timeForAFirstCall);

        firstNocturneCall.setClientId(customerId);
        firstNocturneCall.setCallId("1");
        firstNocturneCall.setDateTime(dateTimeForAFirstCall);
        firstNocturneCall.setDuration(10);
        firstNocturneCall.setLocalOrInternational("L");

        Call secondNocturneCall = new Call();

        LocalTime timeForASecondCall = LocalTime.of(23, 00, 00);
        LocalDate dateForASecondCall = LocalDate.of(2022, Month.MARCH, 28);
        LocalDateTime dateTimeForASecondCall =
                LocalDateTime.of(dateForASecondCall, timeForASecondCall);

        secondNocturneCall.setClientId(customerId);
        secondNocturneCall.setCallId("2");
        secondNocturneCall.setDateTime(dateTimeForASecondCall);
        secondNocturneCall.setDuration(20);
        secondNocturneCall.setLocalOrInternational("I");

        customerCalls.add(firstNocturneCall);
        customerCalls.add(secondNocturneCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

    @Test
    public void whenIsAClientThenReturnTotalCostLikeCorrespondingInWeekendAndInternationalCall()
            throws ClientNotFoundException {

        // set up
        String customerId = "1";
        double totalCostExpected = 0.2;
        List<Call> customerCalls = new ArrayList<Call>();
        Call weekendCall = new Call();

        LocalTime timeForASecondCall = LocalTime.of(23, 00, 00);
        LocalDate dateForASecondCall = LocalDate.of(2022, Month.MARCH, 27);
        LocalDateTime dateTimeForASecondCall =
                LocalDateTime.of(dateForASecondCall, timeForASecondCall);

        weekendCall.setClientId(customerId);
        weekendCall.setCallId("1");
        weekendCall.setDateTime(dateTimeForASecondCall);
        weekendCall.setDuration(10);
        weekendCall.setLocalOrInternational("I");
        customerCalls.add(weekendCall);

        // binding
        doReturn(customerCalls).when(systemforCallBillingRepository)
                .searchCallsByClient(customerId);

        // execute
        double totalCostResponse =
                systemforCallBillingService.totalCostOfCalls(customerId);

        // assertions
        assertEquals(totalCostExpected, totalCostResponse);

    }

}
