/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

/**
 *
 * @author Sparrow
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class dbconn {
    public static Connection cn;
    public static void MyConnection(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "");
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    PreparedStatement prepareStatement(String querysales2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
