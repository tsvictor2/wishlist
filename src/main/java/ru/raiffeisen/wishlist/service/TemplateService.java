package ru.raiffeisen.wishlist.service;

import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.org.apache.commons.io.output.StringBuilderWriter;
import ru.raiffeisen.wishlist.model.Status;

import javax.activation.DataHandler;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Map;

import static javax.mail.Part.INLINE;

@Setter
@Service
@RequiredArgsConstructor
@ConfigurationProperties("templates")
public class TemplateService {

    private final Template statusTemplate;

    @SneakyThrows
    public MimeMultipart getEmailMessageFromTemplate(Status status) {
        var imageName = status.name();
        var templateParameters = Map.of("status", imageName);
        String text;
        try (var stringBuffer = new StringBuilderWriter()) {
            statusTemplate.process(templateParameters, stringBuffer);
            text = stringBuffer.toString();
        }
        var htmlPart = new MimeBodyPart();
        htmlPart.setText(text, "UTF-8", "html");
        var multipart = new MimeMultipart("related");
        multipart.addBodyPart(htmlPart);
        var fileName = status.name() + ".png";
        var resourceBytes = new ClassPathResource("email/images/" + fileName).getInputStream().readAllBytes();
        var dataHandler = new DataHandler(new ByteArrayDataSource(resourceBytes, "image/png"));
        var imagePart = new MimeBodyPart();
        imagePart.setDataHandler(dataHandler);
        imagePart.setFileName(fileName);
        imagePart.setContentID("<" + imageName + ">");
        imagePart.setDisposition(INLINE);
        multipart.addBodyPart(imagePart);
        return multipart;
    }
}
