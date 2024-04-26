package com.beans;

/**
 *
 * @author andrianajoro
 */
public class Utilisateur {
    private int id;
    private String nom_util;
    private String prenom_util;
    private String pseudo;
    private String sexe;
    private String mail;
    private String telephone;
    private String adresse;
    private String photo;
    private String password;
    private boolean actif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_util() {
        return nom_util;
    }

    public void setNom_util(String nom_util) {
        this.nom_util = nom_util;
    }

    public String getPrenom_util() {
        return prenom_util;
    }

    public void setPrenom_util(String prenom_util) {
        this.prenom_util = prenom_util;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    

    
}
