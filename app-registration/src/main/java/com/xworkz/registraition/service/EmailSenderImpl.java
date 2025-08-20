package com.xworkz.registraition.service;

import com.xworkz.registraition.configuration.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderImpl implements EmailSender {
    @Autowired
    private EmailConfig config;


    @Override
    public boolean mailSend(String email, String otp) {
        try {


            System.out.println("mailSend method");
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("Otp to user for verification");
            simpleMailMessage.setText("Otp for verification " + otp);
            config.mailSender().send(simpleMailMessage);
            System.out.println("mail sent to :" + email + " - OTP : " + otp);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

