package com.mmf.web;


import com.mmf.service.MailSenderService;
import com.mmf.service.dto.EmailSendDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/emails")
public class MailSenderController {

    private final MailSenderService mailSenderService;

    @Autowired
    public MailSenderController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }


    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody EmailSendDto emailSendDto) {
        mailSenderService.sendMail(emailSendDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
