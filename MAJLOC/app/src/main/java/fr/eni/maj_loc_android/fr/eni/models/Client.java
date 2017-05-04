package fr.eni.maj_loc_android.fr.eni.models;

import java.io.Serializable;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Client implements Serializable {

    private int id;
    private String nom;
    private String prennom;
    private String mail;
    private String tel;
    private String adresse;


    public Client() {
    }

    public Client(String nom, String prennom, String email, String tel, String adresse) {
        this.nom = nom;
        this.prennom = prennom;
        this.mail = email;
        this.tel = tel;
        this.adresse = adresse;
    }

    public Client(int id, String nom, String prennom, String email, String tel, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prennom = prennom;
        this.mail = email;
        this.tel = tel;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrennom() {
        return prennom;
    }

    public void setPrennom(String prennom) {
        this.prennom = prennom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
