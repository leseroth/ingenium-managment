/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.bos;

import java.util.List;

/**
 *
 * @author marketplace
 */
public class EmailBO {

    private List<String> to;
    private String from;
    private String password;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String message;
    private List<AttachmentBO> attachments;

    public EmailBO(){

    }

    public List<AttachmentBO> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentBO> attachments) {
        this.attachments = attachments;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }
}
