/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import com.beans.Login;
import com.beans.Publication;
import com.beans.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author andrianajoro
 */
public class Database {
    public Connection connex;
    public PreparedStatement ps;
    public ResultSet resu;
    
    public void loaddatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
        
        try {
            connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/immobilier_DB", "root", "");
        }catch(SQLException e){
        }
    }
    
    public void outdatabase(){
        try {
            if(resu != null){
                resu.close();
            }
            if(ps != null){
                ps.close();
            }
            if (connex != null){
                connex.close();
            }
        } catch (SQLException e) {
        }
    }
    
    public List<Utilisateur> recupererUtilisateurs(){
        loaddatabase();
        
        List<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
        Statement stat = null;
        ResultSet result = null;
        

        try {
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
                
                utilisateur.add(user);
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
        return utilisateur;
    }
    
    public String control(String pseudo){
        loaddatabase();
        
        String rapport = "";
        int eff = 0;
        try {
            PreparedStatement ps = connex.prepareStatement("SELECT count(id) as eff FROM utilisateur WHERE pseudo = ?");
            ps.setString(1,  pseudo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                eff = rs.getInt("eff");
            }
            if (eff != 0){
                rapport = "!match";
            }else{
                rapport = "match";
            }
        }catch(SQLException ex){
        }
        
        outdatabase();
        return rapport;
    }
    
    public boolean seConnecter(Login user){
        loaddatabase();
        boolean allow = false;
        int nbr = 0;
        try{
            ps = connex.prepareStatement("SELECT count(id) as eff FROM utilisateur WHERE pseudo = ? AND password = ?;");
            ps.setString(1, user.getLogName());
            ps.setString(2, user.getLogPass());
            
            resu = ps.executeQuery();
            while(resu.next()){
                nbr = resu.getInt("eff");
            }
            if (nbr != 0){
                allow = true;
            }
        }catch(SQLException ex){
        }
        
        outdatabase();
        return allow;
    }
    
    public List<Utilisateur> userSession(Login user){
        loaddatabase();
        
        List<Utilisateur> session = new ArrayList<Utilisateur>();
        try{
            ps = connex.prepareStatement("SELECT * FROM utilisateur WHERE pseudo = ? AND password = ?;");
            ps.setString(1, user.getLogName());
            ps.setString(2, user.getLogPass());
            
            resu = ps.executeQuery();
            while(resu.next()){
                int id = resu.getInt("id");
                // changer le statut actif.............
                ps = connex.prepareStatement("UPDATE utilisateur set actif=? WHERE id =?");
                ps.setBoolean(1, true);
                ps.setInt(2, id);
                ps.executeUpdate();
                
                String pseudo = resu.getString("pseudo");
                String password = resu.getString("password");
                String nom_util = resu.getString("nom_util");
                String prenom_util = resu.getString("prenom_util");
                String sexe = resu.getString("sexe");
                String mail = resu.getString("mail");
                String telephone = resu.getString("telephone");
                String adresse = resu.getString("adresse");
                String photo = resu.getString("photo");
                boolean actif = true;

                Utilisateur userloged = new Utilisateur();
                userloged.setId(id);
                userloged.setPseudo(pseudo);
                userloged.setPassword(password);
                userloged.setNom_util(nom_util);
                userloged.setPrenom_util(prenom_util);
                userloged.setSexe(sexe);
                userloged.setMail(mail);
                userloged.setTelephone(telephone);
                userloged.setAdresse(adresse);
                userloged.setPhoto(photo);
                userloged.setActif(actif);
                
                session.add(userloged);
            }
        }catch(SQLException e){
        }
        return session;
    }
    
    
    public List<Publication> getPubs (){
        loaddatabase();
        List<Publication> actu = new ArrayList<>();
        
        try{
            ps = connex.prepareStatement("SELECT * FROM publication");
            resu = ps.executeQuery();
            while(resu.next()){
                int id_pub = resu.getInt("id_pub");
                
                String desctiption = resu.getString("description");
                String localisation = resu.getString("lacalisation");
                String loyer = resu.getString("loyer");
                String photo = resu.getString("photo");
                int idu = resu.getInt("id");
                String date = resu.getString("date");
                String heure = resu.getString("heure");
                boolean jaime = resu.getBoolean("jaime");
                boolean disponible = resu.getBoolean("disponible");
                boolean commentaire = resu.getBoolean("commentaire");

                Publication onePub = new Publication();
                onePub.setId(id_pub);
                onePub.setDescription(desctiption);
                onePub.setLocalisation(localisation);
                onePub.setLoyer(loyer);
                onePub.setPhoto(photo);
                onePub.setId(idu);
                onePub.setDate(date);
                onePub.setHeure(heure);
                onePub.setJaime(jaime);
                onePub.setDisponible(disponible);
                onePub.setCommentaire(commentaire);
                
                actu.add(onePub);
            }
        }catch(SQLException e){
        }
        
        outdatabase();
        return actu;
    }
            
    
    public String insererUtilisateur(Utilisateur user){
        loaddatabase();
        
        try {
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
        
        outdatabase();
        return "Création de compte terminé avec succèss";
    }
    
    public void SeDeconnecter(int id) {
        try {
            loaddatabase();
            
            ps = connex.prepareStatement("UPDATE utilisateur set actif =? WHERE id =?;");
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            
            
            outdatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String poster(Publication publication) {
        loaddatabase();
        try {
            ps = connex.prepareStatement("INSERT INTO publication(description,lacalisation,loyer,photo,id,date,heure,jaime,disponible,commentaire)"
                    + "VALUES (?,?,?,?,?,?,?,?,?);");
            
            ps.setString(1, publication.getDescription());
            ps.setString(2, publication.getLocalisation());
            ps.setString(3, publication.getLoyer());
            ps.setString(4, publication.getPhoto());
            ps.setInt(5, publication.getId());
            ps.setString(6, publication.getDate());
            ps.setString(7, publication.getHeure());
            ps.setBoolean(8, publication.isJaime());
            ps.setBoolean(9, publication.isDisponible());
            ps.setBoolean(10, publication.isCommentaire());
            
            ps.executeUpdate();
        } catch (SQLException ezx) {
            ezx.printStackTrace();
            System.out.println(ezx);
        }
        
        outdatabase();
        return "Publication postée";
    }
    
    public String modif(String ch1, String ch2, String key) throws SQLException{
        loaddatabase();
        String rapport = "Error";

            String meury = "UPDATE utilisateur set `pseudo` = '"+ch1+"', `adresse`= '"+ch2+"'  WHERE `id` = '"+key+"';";
            ps = connex.prepareStatement(meury);
            ps.executeUpdate();
            rapport = "Modification terminé";
            
        
        outdatabase();
        
            return rapport;
    }
    
    
}
