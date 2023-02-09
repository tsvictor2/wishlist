package ru.raiffeisen.wishlist.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.raiffeisen.wishlist.model.Status;

import java.util.Set;

@SpringBootTest
@WebAppConfiguration
@ActiveProfiles(profiles = "dev")
class EmailServiceITest {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private EmailService emailService;

    @Test
    //@Disabled
    @SneakyThrows
    void send() {
        var mimeMultipart = templateService.getEmailMessageFromTemplate(Status.DONE);
        emailService.send(Set.of("tsvictor2@gmail.com", "tsvictorr@gmail.com"), mimeMultipart);
    }
}