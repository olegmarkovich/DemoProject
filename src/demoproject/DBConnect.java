/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import java.sql.*;


/**
 *
 * @author Lenovo
 */
public class DBConnect {
    
   private static Connection conn = null;
   private static final String USR_NAME = "shelluser";
   private static final String PWD = "shelluser";
    
    /**
     * try to connect to the DB, is success then retuns TRUE else retuns FALSE
     * @return boolean
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    private boolean connect() throws SQLException, ClassNotFoundException {
        
        boolean isValid = true;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/MyDB";
            Connection conn = DriverManager.getConnection(url, DBConnect.USR_NAME, DBConnect.PWD);
            DBConnect.conn = conn;
        } catch (SQLException e) {
            new demoproject.Error("Database not found");
            isValid = false;
        } catch (ClassNotFoundException e) {
            new demoproject.Error("DB Driver not found");
            isValid = false;
        } finally {
            return isValid;
        }
    }
    
    /**
     * get connection
     * @return Connection
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException
    {
        this.connect();
        return DBConnect.conn;
    }
    
}
