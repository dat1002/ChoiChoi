package com.example.test.controllers;

import com.example.test.services.imp.SendMailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestMailController {

    @Autowired
    private SendMailServiceImp sendMailServiceImp;
    @Async
    @GetMapping("/send-mail")
    public ResponseEntity<?> sendMail() {
        sendMailServiceImp.sendMailWithText("Hello","Xin chào, đây là nội dung được spam bởi Sáng đẹp trai đến Minh Trym Teo","ngocminhk62@gmail.com");
        return ResponseEntity.status(200).body("send success");
    }
    @GetMapping("/send-mail-att")
    public ResponseEntity<?> sendMailWithAtt(@RequestParam(name = "image", required = false) MultipartFile[] image) {
        sendMailServiceImp.sendMailWithAtt("Hello","Xin chào Minh Trym Teo","ngocminhk62@gmail.com",image);
        return ResponseEntity.status(200).body("send success");
    }

}
