/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beans;

import com.database.PubMethod;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author andrianajoro
 */
public class Actualite {
    private int id_pub;
    private String description;
    private String localisation;
    private String loyer;
    private String photo_pub;
    private int id;
    private String date;
    private String heure;
    private boolean jaime;
    private boolean disponible;
    private boolean commentaire;
    private String duration;
    private String photo;
    private String name;
    private int effJaime;
    private int effComs;

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getLoyer() {
        return loyer;
    }

    public void setLoyer(String loyer) {
        this.loyer = loyer;
    }

    public String getPhoto_pub() {
        return photo_pub;
    }

    public void setPhoto_pub(String photo_pub) {
        this.photo_pub = photo_pub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public boolean isJaime() {
        return jaime;
    }

    public void setJaime(boolean jaime) {
        this.jaime = jaime;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isCommentaire() {
        return commentaire;
    }

    public void setCommentaire(boolean commentaire) {
        this.commentaire = commentaire;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String date, String heure) {
        String text = date+"T"+heure;
        LocalDateTime date_publication = LocalDateTime.parse(text);
        Duration duree = Duration.between(date_publication, LocalDateTime.now());
        String temps_ecoule = formatDuree(duree);
        this.duration = temps_ecoule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto() throws SQLException {
        PubMethod maka = new PubMethod();
        String value = maka.getInfo("photo", this.id);
        this.photo = value;
    }

    public String getName() {
        return name;
    }

    public void setName() throws SQLException {
        PubMethod maka = new PubMethod();
        String value = maka.getInfo("pseudo", this.id);
        this.name = value;
    }

    public int getEffJaime() {
        return effJaime;
    }

    public void setEffJaime(int effJaime) {
        this.effJaime = effJaime;
    }

    public int getEffComs() {
        return effComs;
    }

    public void setEffComs(int effComs) {
        this.effComs = effComs;
    }
    
    public String formatDuree(Duration duree) {
        long secondes = duree.getSeconds();
        if (secondes < 60) {
            return "moins d'une minute";
        } else if (secondes < 60 * 60) {
            long minutes = duree.toMinutes();
            return minutes + " minute" + (minutes > 1 ? "s" : "");
        } else if (secondes < 24 * 60 * 60) {
            long heures = duree.toHours();
            return heures + " heure" + (heures > 1 ? "s" : "");
        } else {
            long jours = duree.toDays();
            return jours + " jour" + (jours > 1 ? "s" : "");
        }
    }

    
}
