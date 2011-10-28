package co.com.losalpes.marketplace.transact.util;

import com.ecocoma.service.shipping.fedex.Postage;
import java.util.Comparator;

/**
 *
 * @author Erik
 */
public class PostageComparator implements Comparator<Postage> {

    public int compare(Postage postage1, Postage postage2) {
        int compare = Util.getFedexTime(postage2.getMailService()) - Util.getFedexTime(postage1.getMailService());
        if (compare == 0) {
            compare = postage2.getMailService().compareToIgnoreCase(postage1.getMailService());
        }
        return compare;
    }
}
