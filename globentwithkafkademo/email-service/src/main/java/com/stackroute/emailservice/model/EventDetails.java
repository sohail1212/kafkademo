package com.stackroute.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "email")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDetails {

    @Id
    private int eventId;

    private String eventName;


    private String eventDescription;


    private String eventVenue;


    private Object eventDate;

    private String startTime;

    private String endTime;

    private Double eventAmount;

    private Integer eventCapacity;

    private String userName;

    private String userEmail;

}
