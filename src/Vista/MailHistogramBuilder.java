
package Vista;

import Modelo.Histogram;
import Modelo.Mail;
import java.util.List;


public class MailHistogramBuilder {
    
    public static Histogram<String> build (List<Mail> mail){
        
        Histogram<String> histo = new Histogram<String>();
        for (Mail mail1 : mail) {
            histo.increment(mail1.getDomain());
        }
        return histo;
    }
 
        
    }
    

