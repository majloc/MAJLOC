package fr.eni.maj_loc_android.fr.eni.models;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Type {

    private int id;
    private String libelle;


    public Type() {
    }

    public Type(String libelle) {
        this.libelle = libelle;
    }

    public Type(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }






}
