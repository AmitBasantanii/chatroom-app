package com.chat.app.controllers;

import com.chat.app.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/message")

    // to subscribe so that we can receive messages : /topic/return-to
    @SendTo("/topic/return-to")
    public Message getContent (@RequestBody Message message) {

        try {
            // processing
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
