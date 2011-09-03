/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.beans;

import co.com.losalpes.marketplace.mailer.exceptions.CorreosInvalidosException;
import co.com.losalpes.marketplace.mailer.exceptions.CorruptedAttachmentException;
import co.com.losalpes.marketplace.mailer.exceptions.InternalMailServerException;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marketplace
 */
@Local
public interface MailerEmailManagementLocal {

    public Boolean sendMail(List<String>to, List<String>cc, List<String>bcc, String subject, String message, String remitente, String password, Collection<String> attachments)throws CorreosInvalidosException, InternalMailServerException, CorruptedAttachmentException;
}
