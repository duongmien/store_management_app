/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoiSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class JDBCConnection {
     public static Connection getJDBCConnection() {
        
        final String url = "jdbc:sqlserver://localhost:1433;databasename=SieuThiMini;";
        final String user = "mien";
        final String password = "12345";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }

}
