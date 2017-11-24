/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Histogram;
import Modelo.Mail;
import Modelo.Person;
import Vista.DataBaseList;
import Vista.HistogramBuilder;
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
    
    public static List<Mail> mails;
    public static Histogram<String> histogram;
    public static HistogramDisplay histoDisplay;
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //execute(args[0]);
        String nameFile=args[0];	
        List<Person> people = DataBaseList.read();	
        HistogramBuilder<Person> builder = new HistogramBuilder<>(people);
            
         Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });
         new HistogramDisplay(letters, "Sexo").execute();
         
         Histogram<Float> pesos = builder.build(new Attribute<Person, Float>() {

            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
        });
         new HistogramDisplay(pesos, "Peso").execute();
    }
    
 

    private static void execute(String file) throws FileNotFoundException, IOException {
        input(file);
        process();
        output();
     }

    private static void input(String file) throws FileNotFoundException, IOException {
           mails= new ArrayList<Mail>();
            mails = MailListReader.read(file); }

    private static void process() {
         histogram= MailHistogramBuilder.build(mails);}

    private static void output() {
        //histoDisplay = new HistogramDisplay(histogram);  
        histoDisplay.execute();}
        
    }

