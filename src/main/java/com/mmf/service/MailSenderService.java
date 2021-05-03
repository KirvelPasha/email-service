package com.mmf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    private final String subject = "MMF";
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSenderService(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMailWithStudentInfo() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("kirvelpasha99@gmail.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Test");


        javaMailSender.send(simpleMailMessage);
    }
}