package com.stackroute.emailservice.consumer;

import com.google.gson.Gson;
import com.stackroute.emailservice.model.EmailTemplate;
import com.stackroute.emailservice.model.EventDetails;
import com.stackroute.emailservice.repository.EventRepo;
import com.stackroute.emailservice.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@Configuration
public class KafkaListener1 {

    @Autowired
    IEmailService service;







    public void Eventlistener(EventDetails eventDetails) {
        EmailTemplate template = new EmailTemplate();

        template.setSubject("Congratulations you are enroll to " + eventDetails.getEventName());
        template.setSendTo(eventDetails.getUserEmail());
        template.setBody("Hello " + eventDetails.getUserName() + "\n" + "Your Reservation for the event " + eventDetails.getEventName()
                + ". We are Looking forward to provide you with best service \n\n" +
                "Event Id: " + eventDetails.getEventId() +
                "\nEvent Name: " + eventDetails.getEventName() +
                "\nEvent Description: " + eventDetails.getEventDescription() +
                "\nEvent Venue: " + eventDetails.getEventVenue() +
                "\nEvent Date: " + eventDetails.getEventDate() +
                "\nEvent Start Time: " + eventDetails.getStartTime() +
                "\nEvent End Time: " + eventDetails.getEndTime() +
                "\nEvent Capacity: " + eventDetails.getEventCapacity() +
                "\nEvent Amount: " + eventDetails.getEventAmount() +
                "\n\nGet Directions    \n\n\n\n" +
                "Thanks and Regards  \n" +
                "Event Organizing Team"
        );

        service.sendEmail(template);
        System.out.println("Msg Gaya");
    }

//    @RabbitListener(queues = MQConfigPayment.QUEUE)
//    public void Paymentlistener(PaymentDetails details) {
//        EmailTemplate template = new EmailTemplate();
//        template.setSubject("Thank You for the Payment with Payment Id: "+details.getPaymentId());
//        template.setSendTo(details.getUserEmailID());
//        template.setBody("Hello sir/mam\nPlease Note that Payment has been Receive for particepent id:."+details.getParticipantID()+
//                " of Amount Rs:"+details.getAmount()+
//                "\nwith payment Id of receiver :\n"+details.getRazorpayOrderId()+
//                "\nwith status "+details.getStatus()+" \n Get Directions"+
//                "\n\n\n\nThanks and Regards \nEvent Organizing Team"
//        );
//        service.sendEmail(template);
//    }

}
