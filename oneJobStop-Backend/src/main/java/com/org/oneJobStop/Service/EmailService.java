package com.org.oneJobStop.Service;

import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendOTP(String email, String otp) {
        try {
            String subject = "Please verify your OTP";
            String body = "Your OTP is: " + otp + " your OTP is valid for next 10 minutes";
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
        }
        catch (MailException e) {
            throw new RuntimeException("Failed to send OTP email", e);
        }
    }
}
