package ru.raiffeisen.wishlist.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Set;

import static javax.mail.Message.RecipientType.BCC;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailClient;

    @SneakyThrows({MessagingException.class})
    public void send(Set<String> receivers, MimeMultipart multipart) {
        var subject = "subject";
        var mimeMessage = emailClient.createMimeMessage();
        mimeMessage.setFrom("noreply@raiffeisen.ru");
        mimeMessage.setSentDate(new Date());
        mimeMessage.setSubject(subject);
        mimeMessage.setContent(multipart);
        for (var receiver : receivers) {
            mimeMessage.addRecipient(BCC, new InternetAddress(receiver));
        }
        emailClient.send(mimeMessage);
        log.info("Email has been sent to: {}. Subject: {}", receivers, subject);
    }
}
