/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Katyelen
 */
public class DatabaseLocator {

    private static DatabaseLocator instance = new DatabaseLocator();

    public static DatabaseLocator getInstance() {
        return instance;
    }

    private DatabaseLocator() {
    }

    ;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
        return con;
    }
    
    public ResultSet getResultado(String sql) throws ClassNotFoundException, SQLException {
        return getConnection().prepareStatement(sql).executeQuery();
    }
    
    public void executaSql(String sql) throws ClassNotFoundException, SQLException {
        getConnection().createStatement().execute(sql);
    }
}
