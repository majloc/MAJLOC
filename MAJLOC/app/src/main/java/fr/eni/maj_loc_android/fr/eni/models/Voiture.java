package fr.eni.maj_loc_android.fr.eni.models;

import java.io.Serializable;


public class Voiture implements Serializable {

    private int id;
    private Agence agence;
    private double prix_jour;
    private String plaque;
    private String marque;
    private String modele;
    private Type type;
    private Energie energie;
    private String photo;
    private int nbPlaces;


    public Voiture() {
    }
//TODO: constructeur TEST, à effacer un jour
    public Voiture(String marque, String modele, String plaque) {
        this.marque = marque;
        this.modele = modele;
        this.plaque = plaque;
    }

    public Voiture(Agence agence, double prix_jour, String plaque, String marque, String modele,
                   Type type, Energie energie, String photo, int nbPlaces) {
        this.agence = agence;
        this.prix_jour = prix_jour;
        this.plaque = plaque;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.energie = energie;
        this.photo = photo;
        this.nbPlaces = nbPlaces;
    }

    public Voiture(int id, Agence agence, double prix_jour, String plaque, String marque, String modele,
                   Type type, Energie energie, String photo, int nbPlaces) {
        this.id = id;
        this.agence = agence;
        this.prix_jour = prix_jour;
        this.plaque = plaque;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.energie = energie;
        this.photo = photo;
        this.nbPlaces = nbPlaces;
    }

    public int getId() {
        return id;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public double getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(double prix_jour) {
        this.prix_jour = prix_jour;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Energie getEnergie() {
        return energie;
    }

    public void setEnergie(Energie energie) {
        this.energie = energie;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }
}
