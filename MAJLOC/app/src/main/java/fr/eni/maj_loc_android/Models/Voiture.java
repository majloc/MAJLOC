package fr.eni.maj_loc_android.Models;

import java.io.Serializable;
import java.util.List;

import fr.eni.maj_loc_android.Models.Agence;
import fr.eni.maj_loc_android.Models.Energie;
import fr.eni.maj_loc_android.Models.Type;


public class Voiture implements Serializable {

    private int id;
    private Agence agence;
    private double prix_jour;
    private String plaque;
    private String marque;
    private String modele;
    private Type type;
    private Energie energie;
    private List<String> photos;
    private int nbPlace;
    private boolean loue;

    public Voiture(int id, Agence agence, double prix_jour, String plaque, String marque, String modele, Type type, Energie energie, List<String> photos, int nbPlaces, boolean loue) {
        this.id = id;
        this.agence = agence;
        this.prix_jour = prix_jour;
        this.plaque = plaque;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.energie = energie;
        this.photos = photos;
        this.nbPlace = nbPlaces;
        this.loue = loue;
    }

    public Voiture() {
    }
//TODO: constructeur TEST, à effacer un jour
    public Voiture(String marque, String modele, String plaque) {
        this.marque = marque;
        this.modele = modele;
        this.plaque = plaque;
    }

    public Voiture(Agence agence, double prix_jour, String plaque, String marque, String modele,
                   Type type, Energie energie, List<String> photos, int nbPlaces) {
        this.agence = agence;
        this.prix_jour = prix_jour;
        this.plaque = plaque;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.energie = energie;
        this.photos = photos;
        this.nbPlace = nbPlaces;
    }

    public Voiture(int id, Agence agence, double prix_jour, String plaque, String marque, String modele,
                   Type type, Energie energie, List<String> photos, int nbPlaces) {
        this.id = id;
        this.agence = agence;
        this.prix_jour = prix_jour;
        this.plaque = plaque;
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.energie = energie;
        this.photos = photos;
        this.nbPlace = nbPlaces;
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

    public List<String>  getPhoto() {
        return photos;
    }

    public void setPhoto(List<String> photos) {
        this.photos = photos;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public boolean isLoue() {
        return loue;
    }

    public void setLoue(boolean loue) {
        this.loue = loue;
    }
}
