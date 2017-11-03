/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Histogram;
import Modelo.Mail;
import Vista.HistogramDisplay;
import Vista.MailHistogramBuilder;
import Vista.MailListReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<Mail> mails = new ArrayList<Mail>();
        mails = MailListReader.read(args[0]);
        
        Histogram<String> histogram = MailHistogramBuilder.build(mails);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        
        histoDisplay.execute();
        }
        
    }

