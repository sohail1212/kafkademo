package com.stackroute.emailservice.service;


import com.google.gson.Gson;
import com.stackroute.emailservice.model.EmailTemplate;

import com.stackroute.emailservice.model.EventDetails;
import com.stackroute.emailservice.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EventRepo repo;



    public void sendEmail(EmailTemplate template){


        SimpleMailMessage msg=new SimpleMailMessage();
        try{
            msg.setTo(template.getSendTo());
            msg.setSubject(template.getSubject());
            msg.setText(template.getBody());
            javaMailSender.send(msg);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @KafkaListener(topics = "topic1", groupId = "group1")
    public EventDetails consume(String message) {
        EventDetails treeObj = new Gson().fromJson(message, EventDetails.class);
        EventDetails details =new EventDetails();
        details.setEventName(treeObj.getEventName());
        details.setUserEmail(treeObj.getUserEmail());
        details.setEventDate(treeObj.getEventDate());
        details.setEndTime(treeObj.getEndTime());
        details.setEventDescription(treeObj.getEventDescription());
        details.setEventAmount(treeObj.getEventAmount());
        details.setEventVenue(treeObj.getEventVenue());
        details.setUserName(treeObj.getUserName());
        details.setStartTime(treeObj.getStartTime());
        return repo.save(details);
    }

}
