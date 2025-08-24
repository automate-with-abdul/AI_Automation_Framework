package com.automation.framework.frameworkengine;

import com.automation.framework.utils.PropertyReader;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Utility class for sending email notifications
 */
public class SendMail {
    public static void sendReportEmail() {
        Properties mailProps = PropertyReader.loadProperties("mail.properties");
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailProps.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", mailProps.getProperty("mail.smtp.port"));

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    mailProps.getProperty("mail.user"),
                    mailProps.getProperty("mail.password")
                );
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailProps.getProperty("mail.from")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailProps.getProperty("mail.to")));
            message.setSubject("Automation Test Results");
            
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Please find attached the test execution report.");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile("allure-results.zip");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
