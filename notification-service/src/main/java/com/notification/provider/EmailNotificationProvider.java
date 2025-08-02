package com.notification.provider;

import com.notification.model.Notification;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationProvider implements NotificationProvider{

    private final JavaMailSender mailSender;

    public EmailNotificationProvider(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(Notification notification) {
        SimpleMailMessage message= new SimpleMailMessage();
        System.out.println("📧 Sending email to " + notification.getRecipient());
        System.out.println("Subject: "+ notification.getSubject());
        System.out.println("Body: " + notification.getBody());

        message.setTo(notification.getRecipient());
        message.setSubject(notification.getSubject());
        message.setText(notification.getBody());

        mailSender.send(message);
        System.out.println("📧 email sent to " + notification.getRecipient());
    }
}
