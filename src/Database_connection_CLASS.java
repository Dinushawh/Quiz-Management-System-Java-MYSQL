
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dinus
 */
public class Database_connection_CLASS {
    
    static Connection connection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz management system", "root", "");
            System.out.println("connected");
            return con;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
            System.out.println("error");

        }
        return null;
    }   
    
}
