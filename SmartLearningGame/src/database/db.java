/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmamm
 */
public class db {
    public static Connection getConnection(){
        Connection con=null;
        try {
            String userName = "root"; // Database server username
            String password = "1234"; // server password
            String host = "localhost"; // server location
            String port = "3306"; // communication port. default 3306
            String dbName = "smart_learning"; // name of the database
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String url = "jdbc:mysql://" + host + ":"+port+"/" + dbName; // database URL

            con= DriverManager.getConnection(url,userName,password);
        } catch (InstantiationException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
