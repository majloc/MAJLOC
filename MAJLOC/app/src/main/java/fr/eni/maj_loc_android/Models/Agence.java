package fr.eni.maj_loc_android.Models;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Agence {

    private int id;
    private String nom_responsable;
    private String prenom_responsable;
    private String nom_agence;
    private String login;
    private String mdp;
    private String email;
    private String tel;
    private String CA;


    public Agence() {
    }

    public Agence(String nom_responsable, String prenom_responsable, String nom_agence,
                  String login, String mdp, String email, String tel, String CA) {
        this.nom_responsable = nom_responsable;
        this.prenom_responsable = prenom_responsable;
        this.nom_agence = nom_agence;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.tel = tel;
        this.CA = CA;
    }

    public Agence(int id, String nom_responsable, String prenom_responsable, String nom_agence, String login,
                  String mdp, String email, String tel, String CA) {
        this.id = id;
        this.nom_responsable = nom_responsable;
        this.prenom_responsable = prenom_responsable;
        this.nom_agence = nom_agence;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.tel = tel;
        this.CA = CA;
    }

    public int getId() {
        return id;
    }

    public String getNom_responsable() {
        return nom_responsable;
    }

    public void setNom_responsable(String nom_responsable) {
        this.nom_responsable = nom_responsable;
    }

    public String getPrenom_responsable() {
        return prenom_responsable;
    }

    public void setPrenom_responsable(String prenom_responsable) {
        this.prenom_responsable = prenom_responsable;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }
}
