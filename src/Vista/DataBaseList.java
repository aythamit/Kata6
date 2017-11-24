
package Vista;

import Modelo.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBaseList {
    
    
    public static List<Person> read(){
        try {
            List<Person> listPerson = new ArrayList<>();
            Class.forName("org.sqlite.JDBC");
            Connection connect = DriverManager.getConnection("jdbc:sqlite:../db/KATA.sDB");
            Statement st = connect.createStatement();
            String query =  "SELECT * FROM PEOPLE";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                Character gender = rs.getString(3).charAt(0);
                String birth = rs.getString(4);
                Float peso = rs.getFloat(5);
                String mail = rs.getString(6);
                listPerson.add(new Person(id,name,gender,birth,peso,mail));
                
            }
            return listPerson;
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
