/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;

import com.beans.Actualite;
import com.beans.Commentaire;
import com.beans.Publication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrianajoro
 */
public class PubMethod {
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
    
    
    public List<Actualite> getPubs () throws SQLException{
        loaddatabase();
        List<Actualite> actu = new ArrayList<>();
        
            ps = connex.prepareStatement("SELECT * FROM publication ORDER BY(id_pub) DESC; ");
            resu = ps.executeQuery();
            while(resu.next()){
                int effComs = 0;
                int effJaime = 5;
                
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

                Actualite onePub = new Actualite();
                onePub.setId_pub(id_pub);
                onePub.setDescription(desctiption);
                onePub.setLocalisation(localisation);
                onePub.setLoyer(loyer);
                onePub.setPhoto_pub(photo);
                onePub.setId(idu);
                onePub.setDate(date);
                onePub.setHeure(heure);
                onePub.setJaime(jaime);
                onePub.setDisponible(disponible);
                onePub.setCommentaire(commentaire);
                onePub.setDuration(date, heure);
                onePub.setPhoto();
                onePub.setName();
                
                String queryComs = "SELECT count(numero) as effComs FROM commentaire WHERE '"+id_pub+"'; ";
                ps = connex.prepareStatement(queryComs);
                resu = ps.executeQuery();
                while(resu.next()){
                    effComs = resu.getInt("effComs");
                }
                
                String queryJaime = "SELECT count(numerotation) as effJaime FROM jaime WHERE id_pub = '"+id_pub+"'; ";
                ps = connex.prepareStatement(queryJaime);
                resu = ps.executeQuery();
                while(resu.next()){
                    effJaime = resu.getInt("effJaime");
                }
                onePub.setEffComs(effComs);
                onePub.setEffJaime(effJaime);
                
                actu.add(onePub);
            }
        
        outdatabase();
        return actu;
    }
    
    
    public List<Actualite> searchPubs (String val) throws SQLException{
        loaddatabase();
        List<Actualite> actu = new ArrayList<>();
            String search = "SELECT * FROM publication WHERE description LIKE ? OR lacalisation LIKE ? OR loyer LIKE ? ORDER BY(id_pub) DESC; ";
            
            ps = connex.prepareStatement(search);
            ps.setString(1, "%"+val+"%");
            ps.setString(2, "%"+val+"%");
            ps.setString(3, "%"+val+"%");
            resu = ps.executeQuery();
            while(resu.next()){
                int effComs = 0;
                int effJaime = 5;
                
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

                Actualite onePub = new Actualite();
                onePub.setId_pub(id_pub);
                onePub.setDescription(desctiption);
                onePub.setLocalisation(localisation);
                onePub.setLoyer(loyer);
                onePub.setPhoto_pub(photo);
                onePub.setId(idu);
                onePub.setDate(date);
                onePub.setHeure(heure);
                onePub.setJaime(jaime);
                onePub.setDisponible(disponible);
                onePub.setCommentaire(commentaire);
                onePub.setDuration(date, heure);
                onePub.setPhoto();
                onePub.setName();
                
                String queryComs = "SELECT count(numero) as effComs FROM commentaire WHERE id_pub = '"+id_pub+"'; ";
                ps = connex.prepareStatement(queryComs);
                resu = ps.executeQuery();
                while(resu.next()){
                    effComs = resu.getInt("effComs");
                }
                
                String queryJaime = "SELECT count(numerotation) as effJaime FROM jaime WHERE id_pub = '"+id_pub+"'; ";
                ps = connex.prepareStatement(queryJaime);
                resu = ps.executeQuery();
                while(resu.next()){
                    effJaime = resu.getInt("effJaime");
                }
                onePub.setEffComs(effComs);
                onePub.setEffJaime(effJaime);
                
                actu.add(onePub);
            }
        
        outdatabase();
        return actu;
    }
    
    public String poster(Publication publication) throws SQLException {
        loaddatabase();
            ps = connex.prepareStatement("INSERT INTO publication(description,lacalisation,loyer,photo,id,date,heure,jaime,disponible,commentaire) VALUES (?,?,?,?,?,?,?,?,?,?);");
            
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
        outdatabase();
        return "Publication postée";
    }
    
    public String getInfo(String info, int id) throws SQLException{
        loaddatabase();
        String value = null;
        String query = "SELECT "+info+" FROM utilisateur WHERE id="+id;
        ps = connex.prepareStatement(query);
        resu = ps.executeQuery();
        while(resu.next()){
            value = resu.getString(info);
        }
        
        outdatabase();
        return value;
    }
    
    
    // JAIME+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void like(String id, String id_pub) throws SQLException{
        loaddatabase();
        //String testeo = "SELECT count(`id_pub`) as efa FROM `jaime` WHERE  `id_pub` = '"+id_pub+"' AND `id` = '"+id+"';";
        //ps = connex.prepareStatement(testeo);
        //resu = ps.executeQuery();
        //while(resu.next()){
        //    int misy = resu.getInt("efa");
        //    if (misy == 0){
                String query = "INSERT INTO `jaime` (`id_pub`, `id`) VALUES ('"+id_pub+"', '"+id+"');";
                ps = connex.prepareStatement(query);
                ps.executeUpdate();
        //    }else{
        //        String fafao = "DELETE FROM `jaime` WHERE  `id_pub` = "+id_pub+" AND `id` = "+id+";";
        //        ps = connex.prepareStatement(fafao);
        //        ps.executeUpdate();
        //    }
        //}
        String isao = "SELECT count(`id_pub`) as aove FROM `jaime` WHERE  `id_pub` = '"+id_pub+"';";
        ps = connex.prepareStatement(isao);
        resu = ps.executeQuery();
        while(resu.next()){
            int nisy = resu.getInt("aove");
            int bol;
            if (nisy > 0){
                bol = 1;
            }else{
                bol = 0;
            }
            String isjaime = "UPDATE `publication` set `jaime` = '"+bol+"' WHERE `id_pub` = '"+id_pub+"';";
            ps = connex.prepareStatement(isjaime);
            ps.executeUpdate();
        }
        outdatabase();
    }
    
    
    public void dislike(String id, String id_pub) throws SQLException{
        loaddatabase();
        //String testeo = "SELECT count(`id_pub`) as efa FROM `jaime` WHERE  `id_pub` = '"+id_pub+"' AND `id` = '"+id+"';";
        //ps = connex.prepareStatement(testeo);
        //resu = ps.executeQuery();
        //while(resu.next()){
        //    int misy = resu.getInt("efa");
        //    if (misy == 0){
        //        String query = "INSERT INTO `jaime` (`id_pub`, `id`) VALUES ('"+id_pub+"', '"+id+"');";
        //        ps = connex.prepareStatement(query);
        //        ps.executeUpdate();
        //    }else{
                String fafao = "DELETE FROM `jaime` WHERE  `id_pub` = "+id_pub+" AND `id` = "+id+";";
                ps = connex.prepareStatement(fafao);
                ps.executeUpdate();
        //    }
        //}
        String isao = "SELECT count(`id_pub`) as aove FROM `jaime` WHERE  `id_pub` = '"+id_pub+"';";
        ps = connex.prepareStatement(isao);
        resu = ps.executeQuery();
        while(resu.next()){
            int nisy = resu.getInt("aove");
            int bol;
            if (nisy > 0){
                bol = 1;
            }else{
                bol = 0;
            }
            String isjaime = "UPDATE `publication` set `jaime` = '"+bol+"' WHERE `id_pub` = '"+id_pub+"';";
            ps = connex.prepareStatement(isjaime);
            ps.executeUpdate();
        }
        outdatabase();
    }
    
    
    // COMMENTAIRE++++++++++++++++++++++++++++++++++++++++++++++++++++
    public List<Commentaire> getComments(String id_pub) throws SQLException{
        List<Commentaire> commentaire = new ArrayList<Commentaire>();
        loaddatabase();
        
        String testeo = "SELECT `commentaire`.`contenu` as contenu, `commentaire`.`date_com` as date, `commentaire`.`heure_com` as heure, `utilisateur`.`pseudo` as pseudo ,`utilisateur`.`photo` as photo "
                +"FROM `commentaire`,`publication`, `utilisateur` "
                +"WHERE `commentaire`.`id_pub` = `publication`.`id_pub` AND `commentaire`.`id` = `utilisateur`.`id` AND `publication`.`id_pub` ='"+id_pub+"' ;";
        ps = connex.prepareStatement(testeo);
        resu= ps.executeQuery();
        while(resu.next()){
                
                String contenu = resu.getString("contenu");
                String pseudo = resu.getString("pseudo");
                String date_com = resu.getString("date");
                String photo_use = resu.getString("photo");
                String heure_com = resu.getString("heure");
                
                Commentaire onePub = new Commentaire();
                onePub.setContenu(contenu);
                onePub.setPseudo(pseudo);
                onePub.setPhoto_use(photo_use);
                onePub.setDate_com(date_com, heure_com);
                onePub.setHeure_com(heure_com);
                commentaire.add(onePub);
        }
        
        outdatabase();
        return commentaire;
    }
    
    public void insertCom(String id_pub, String id, String contenu, String date_com, String heure_com)throws SQLException{
        loaddatabase();
            String query = "INSERT INTO commentaire(contenu,id_pub,id,date_com,heure_com)VALUES ('"+contenu+"','"+id_pub+"','"+id+"','"+date_com+"','"+heure_com+"');";
            ps = connex.prepareStatement(query);
            
            ps.executeUpdate();
        outdatabase();
    }
    
    
    public List<Actualite> getSelfPubs (int id) throws SQLException{
        loaddatabase();
        List<Actualite> actu = new ArrayList<>();
            String meo = "SELECT * FROM `publication` WHERE `id` = '"+id+"' ORDER BY(id_pub) DESC; ";
            ps = connex.prepareStatement(meo);
            resu = ps.executeQuery();
            while(resu.next()){
                
                int effComs = 0;
                int effJaime = 5;
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

                Actualite onePub = new Actualite();
                onePub.setId_pub(id_pub);
                onePub.setDescription(desctiption);
                onePub.setLocalisation(localisation);
                onePub.setLoyer(loyer);
                onePub.setPhoto_pub(photo);
                onePub.setId(idu);
                onePub.setDate(date);
                onePub.setHeure(heure);
                onePub.setJaime(jaime);
                onePub.setDisponible(disponible);
                onePub.setCommentaire(commentaire);
                onePub.setDuration(date, heure);
                onePub.setPhoto();
                onePub.setName();
                String queryComs = "SELECT count(numero) as effComs FROM commentaire WHERE '"+id_pub+"'; ";
                ps = connex.prepareStatement(queryComs);
                resu = ps.executeQuery();
                while(resu.next()){
                    effComs = resu.getInt("effComs");
                }
                
                String queryJaime = "SELECT count(numerotation) as effJaime FROM jaime WHERE id_pub = '"+id_pub+"'; ";
                ps = connex.prepareStatement(queryJaime);
                resu = ps.executeQuery();
                while(resu.next()){
                    effJaime = resu.getInt("effJaime");
                }
                onePub.setEffComs(effComs);
                onePub.setEffJaime(effJaime);
                
                actu.add(onePub);
            }
        
        outdatabase();
        return actu;
    }
    
}
