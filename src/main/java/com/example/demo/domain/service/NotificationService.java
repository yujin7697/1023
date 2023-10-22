package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendNotification(String recipient, String message){
        System.out.println("sendNotification's recipient : " + recipient);
        messagingTemplate.convertAndSendToUser(recipient,"/topic/notification",message);

    }
}
