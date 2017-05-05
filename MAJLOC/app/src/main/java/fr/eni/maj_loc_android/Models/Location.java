package fr.eni.maj_loc_android.Models;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Location {

    private int id;
    private Date date_debut;
    private Date date_fin;
    private List<String> photos_debut;
    private List<String> photos_fin;
    private Date restitution;
    private double prix;
    private Voiture voiture;
    private Client client;



    public Location() {
    }

    public Location(Date date_debut, Date date_fin, List<String> photos_debut, List<String> photos_fin,
                    Date restitution, double prix, Voiture voiture, Client client) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.photos_debut = photos_debut;
        this.photos_fin = photos_fin;
        this.restitution = restitution;
        this.prix = prix;
        this.voiture = voiture;
        this.client = client;
    }

    public Location(int id, Date date_debut, Date date_fin, List<String> photos_debut, List<String> photos_fin,
                    Date restitution, double prix, Voiture voiture, Client client) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.photos_debut = photos_debut;
        this.photos_fin = photos_fin;
        this.restitution = restitution;
        this.prix = prix;
        this.voiture = voiture;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public List<String> getPhotos_debut() {
        return photos_debut;
    }

    public void setPhotos_debut(List<String> photos_debut) {
        this.photos_debut = photos_debut;
    }

    public List<String> getPhotos_fin() {
        return photos_fin;
    }

    public void setPhotos_fin(List<String> photos_fin) {
        this.photos_fin = photos_fin;
    }

    public Date getRestitution() {
        return restitution;
    }

    public void setRestitution(Date restitution) {
        this.restitution = restitution;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        //TODO: definir le prix en calcul
        this.prix = prix;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
