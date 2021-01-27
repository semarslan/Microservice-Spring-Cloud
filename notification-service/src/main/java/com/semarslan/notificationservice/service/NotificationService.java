package com.semarslan.notificationservice.service;


import com.semarslan.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 *
 * @EnableBinding(Sink.class) => kuyruğu dinleyen
 */
@EnableBinding(Sink.class)
public class NotificationService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){

        System.out.println("Notification alındı, Kullanıcılara gönderiliyor");
        System.out.println("Notification -> " +ticketNotification.toString());
    }
}
