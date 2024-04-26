package com.dao;


import java.sql.*;

/**
 *
 * @author andrianajoro
 */
public class DaoFactory {
    private String url;
    private String username;
    private String password;
    
    
    DaoFactory(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public static DaoFactory getInstance(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        DaoFactory instance = new DaoFactory("jdbc:mysql//localhost:3306/Immobilier_DB", "root", "");
        return instance;
    }
    
    public Connection setConnex() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
    // recupération du Dao
    public UtilisateurDao recupUtilisateurDao(){
        return new UtilisateurDaoImpl(this);
    }
    
}
