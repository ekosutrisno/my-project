package com.xsis.xsis.restapi;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.xsis.xsis.dto.EmailDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmailController
 */
@RestController
public class EmailRencanaAPI {

  @RequestMapping(value = "/sendemail")
  @PostMapping
  public void sendEmail(@RequestBody EmailDto emailDto) throws AddressException, MessagingException, IOException {

    String penerima = emailDto.getPenerima();
    String subjek = emailDto.getJudul();
    String konten = emailDto.getKonten();
    sendmail(penerima, subjek, konten);
  }

  private void sendmail(String penerima, String subjek, String konten)
      throws AddressException, MessagingException, IOException {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("xsisappv2.0@gmail.com", "aku12345678");
        // return new PasswordAuthentication("mediapembelajaran.mtk15@gmail.com",
        // "AkuCintaKamu801");
      }
    });

    Message msg = new MimeMessage(session);
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(penerima));
    msg.setSubject(subjek);
    msg.setContent(konten, "text/html");
    msg.setSentDate(new Date());
    Transport.send(msg);
  }

}