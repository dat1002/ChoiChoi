package com.example.test.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ISendMailService {
    String sendMailWithText(String sub, String content, String to);
    String sendMailWithAtt(String sub, String content, String to, MultipartFile[] att);

//    void sendMailToAdmin();
//    void sendMailToUserForBirthday(Set<User> users);
//    void sendMailToUserCallLearn();
//    String sendMailWithHTML();//rảnh thì làm thêm
}
