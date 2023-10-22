package com.example.demo.controller;

import com.example.demo.domain.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat") // 클라이언트에서 /app/chat 경로로 메시지를 보낼 때 이 핸들러가 처리
    @SendTo("/topic/messages") // 서버에서 /topic/messages 경로로 메시지를 보내 클라이언트에게 전달
    public MessageDto sendMessage(MessageDto message) {
        return message;
    }
}