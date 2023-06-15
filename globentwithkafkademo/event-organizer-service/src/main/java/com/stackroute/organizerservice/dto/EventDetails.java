package com.stackroute.organizerservice.dto;


import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Data
public class EventDetails {

    private int eventId;

    private String eventName;


    private String eventDescription;


    private String eventVenue;


    private LocalDate eventDate;

    private String startTime;

    private String endTime;

    private Double eventAmount;

    private Integer eventCapacity;

    private String userName;

    private String userEmail;

}
