package com.example.TP_OO2_Turnos.services.implementation;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.services.IEmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service("emailService")
public class EmailService implements IEmailService{

    @Value("${email.sender}")
    private String emailUser;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String[] toUser, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(emailUser);
        mailMessage.setTo(toUser);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

    @Override
    public void sendEmailWithFile(String[] toUser, String subject, String message, File file) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

            mimeMessageHelper.setFrom(emailUser);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(message);
            mimeMessageHelper.addAttachment(file.getName(), file);

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}