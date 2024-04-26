/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.beans.Utilisateur;
import com.database.Database;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrianajoro
 */
public class UtilisateurDaoImpl implements UtilisateurDao{
    private DaoFactory daoFactory;
    
    UtilisateurDaoImpl(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    
    @Override
    public String ajouter(Utilisateur user) {
        Connection connex = null;
        PreparedStatement ps =null;
        try {
            connex = daoFactory.setConnex();
            ps = connex.prepareStatement("INSERT INTO utilisateur(nom_util,prenom_util,pseudo,sexe,mail,telephone,adresse,photo,password,actif)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1,  user.getNom_util());
            ps.setString(2,  user.getPrenom_util());
            ps.setString(3,  user.getPseudo());
            ps.setString(4,  user.getSexe());
            ps.setString(5,  user.getMail());
            ps.setString(6,  user.getTelephone());
            ps.setString(7,  user.getAdresse());
            ps.setString(8,  user.getPhoto());
            ps.setString(9,  user.getPassword());
            ps.setBoolean(10,  user.isActif());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Success";
    }

    @Override
    public List<Utilisateur> lister() {
        List<Utilisateur> users = new ArrayList<Utilisateur>();
        Connection connex = null;
        Statement stat = null;
        ResultSet result = null;

        try {
            connex = daoFactory.setConnex();
            stat = connex.createStatement();
            //une requête

            result = stat.executeQuery("SELECT * FROM utilisateur;");

            // recupération 

            while (result.next()) {
                String pseudo = result.getString("pseudo");
                String password = result.getString("password");
                String nom_util = result.getString("nom_util");
                String prenom_util = result.getString("prenom_util");
                String sexe = result.getString("sexe");
                String mail = result.getString("mail");
                String telephone = result.getString("telephone");
                String adresse = result.getString("adresse");
                String photo = result.getString("photo");
                boolean actif = result.getBoolean("actif");

                Utilisateur user = new Utilisateur();
                user.setPseudo(pseudo);
                user.setPassword(password);
                user.setNom_util(nom_util);
                user.setPrenom_util(prenom_util);
                user.setSexe(sexe);
                user.setMail(mail);
                user.setTelephone(telephone);
                user.setAdresse(adresse);
                user.setPhoto(photo);
                user.setActif(actif);
                
                users.add(user);
            }
        } catch (SQLException e) { 
        }finally{
            try {
                if(result != null){
                    result.close();
                }
                if(stat != null){
                    stat.close();
                }
                if (connex != null){
                    connex.close();
                }
            } catch (SQLException e) {
            }
        }
        return users;
    }
    
}
