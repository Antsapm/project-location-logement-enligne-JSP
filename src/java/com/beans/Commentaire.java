/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beans;

import com.database.PubMethod;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author andrianajoro
 */
public class Commentaire {
    private String contenu;
    private String pseudo;
    private String photo_use;
    private String date_com;
    private String heure_com;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPhoto_use() {
        return photo_use;
    }

    public void setPhoto_use(String photo_use) {
        this.photo_use = photo_use;
    }
    

    public String getDate_com() {
        return date_com;
    }

    public void setDate_com(String date, String heure) {
        String text = date+"T"+heure;
        LocalDateTime date_publication = LocalDateTime.parse(text);
        Duration duree = Duration.between(date_publication, LocalDateTime.now());
        Actualite actuel = new Actualite();
        String duration = actuel.formatDuree(duree);
        this.date_com = duration;
    }

    public String getHeure_com() {
        return heure_com;
    }

    public void setHeure_com(String heure_com) {
        this.heure_com = heure_com;
    }
    
    
    
}
