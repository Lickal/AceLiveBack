/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Benjamin
 */
public class mail {
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "objet")
    private String objet;
    @Size(max = 255)
    @Column(name = "destinataire")
    private String destinataire;
    @Size(max = 65535)
    @Column(name = "message")
    private String message;
    
    
    public void sendMessage() {
        // Sender's email ID needs to be mentioned
        String from = "newsletter@acelive.com";
        final String username = "root@acelive.com"; //change accordingly
        final String password = "acelive"; //change accordingly
        
        // 1 -> Création de la session
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "192.168.1.30");
        properties.setProperty("mail.smtp.user", "root@acelive.com");
        properties.setProperty("mail.from", "root");
        
        Session session = Session.getInstance(properties,null);
        
        // 2 -> Création du message
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            //message.setText(text);
            message.setSubject(this.getObjet());
            message.setContent(this.getMessage(), "text/html; charset=utf-8");
            
            //Address[] myList = new InternetAddress[destinataires.length];
          
                message.addRecipients(Message.RecipientType.BCC,InternetAddress.parse(this.getDestinataire()));
            
            
            // 3 -> Envoi du message
            Transport.send(message,username,password);
            
            System.out.println("Message envoyé !");
        } catch (MessagingException e) {
            e.printStackTrace();
        }}

    /**
     * @return the objet
     */
    public String getObjet() {
        return objet;
    }

    /**
     * @param objet the objet to set
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

    /**
     * @return the destinataire
     */
    public String getDestinataire() {
        return destinataire;
    }

    /**
     * @param destinataire the destinataire to set
     */
    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}