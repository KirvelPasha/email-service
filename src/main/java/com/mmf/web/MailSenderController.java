package com.mmf.web;


import com.mmf.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mails")
public class MailSenderController {

    private final MailSenderService mailSenderService;

    @Autowired
    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }


    @GetMapping
    public ResponseEntity<Void> sendMessage() {
        mailSenderService.sendMailWithStudentInfo();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
