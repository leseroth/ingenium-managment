/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.losalpes.marketplace.mailer.bos;

/**
 *
 * @author marketplace
 */
public class AttachmentBO {

    private String url;

    public AttachmentBO(){

    }

    public AttachmentBO(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
