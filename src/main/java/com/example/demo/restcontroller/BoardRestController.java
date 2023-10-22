package com.example.demo.restcontroller;

import com.example.demo.domain.dto.ReplyDto;
import com.example.demo.domain.service.BoardService;
import com.example.demo.domain.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private NotificationService notificationService;

    //-------------------
    //댓글추가
    //-------------------
    @GetMapping("/reply/add")
    public void addReply(Long bno, String content , String nickname){
        log.info("GET /reply/add " + bno + " " + content + " " + nickname);
        boardService.addReply(bno,content, nickname);

        // 댓글이 작성되었음을 해당 게시물의 주인에게 알림으로 전송
        String recipientUsername = boardService.getPostOwnerUsername(bno); // 게시물의 주인의 사용자명을 가져오는 메소드
        String notificationMessage = "누군가 댓글을 달았습니다.";
        notificationService.sendNotification(recipientUsername, notificationMessage);
    }
    //-------------------
    //댓글 조회
    //-------------------
    @GetMapping("/reply/list")
    public List<ReplyDto> getListReply(Long bno){
        log.info("GET /reply/list " + bno);
        List<ReplyDto> list =  boardService.getReplyList(bno);
        return list;
    }
    //-------------------
    //댓글 카운트
    //-------------------
    @GetMapping("/reply/count")
    public Long getCount(Long bno){
        log.info("GET /reply/count " + bno);
        Long cnt = boardService.getReplyCount(bno);

        return cnt;
    }
}