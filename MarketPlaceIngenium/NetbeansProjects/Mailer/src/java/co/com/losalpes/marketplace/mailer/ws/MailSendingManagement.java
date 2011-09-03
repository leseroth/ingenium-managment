/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.ws;

import co.com.losalpes.marketplace.mailer.beans.MailerEmailManagementLocal;
import co.com.losalpes.marketplace.mailer.exceptions.CorreosInvalidosException;
import co.com.losalpes.marketplace.mailer.exceptions.CorruptedAttachmentException;
import co.com.losalpes.marketplace.mailer.exceptions.InternalMailServerException;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

/**
 *
 * @author marketplace
 */
@WebService()
@Stateless()
public class MailSendingManagement {
    @EJB
    private MailerEmailManagementLocal ejbRef;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sendMail")
    public Boolean sendMail(@WebParam(name = "to")
    java.util.List<java.lang.String> to, @WebParam(name = "cc")
    java.util.List<java.lang.String> cc, @WebParam(name = "bcc")
    java.util.List<java.lang.String> bcc, @WebParam(name = "subject")
    String subject, @WebParam(name = "message")
    String message, @WebParam(name = "from")
    String from, @WebParam(name = "password")
    String password, @WebParam(name = "attachments")
    java.util.List<java.lang.String> attachments) throws CorreosInvalidosException,
    InternalMailServerException, CorruptedAttachmentException{
        return ejbRef.sendMail(to, cc, bcc, subject, message, from, password, attachments);
    }

}
