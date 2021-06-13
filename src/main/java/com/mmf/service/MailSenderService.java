package com.mmf.service;

import com.mmf.service.dto.EmailSendDto;
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

    public void sendMail( EmailSendDto emailSendDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("");


        javaMailSender.send(simpleMailMessage);
    }
}