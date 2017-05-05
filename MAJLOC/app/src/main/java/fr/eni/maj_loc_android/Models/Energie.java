package fr.eni.maj_loc_android.Models;

/**
 * Created by Administrateur on 03/05/2017.
 */

public class Energie {

    private int id;
    private EnumEnergie energie;





    public Energie() {
        super();
    }

    public Energie(EnumEnergie energie) {
        super();
        this.energie = energie;
    }

    public Energie(int id, EnumEnergie energie) {
        super();
        this.id = id;
        this.energie = energie;
    }

    public EnumEnergie getEnergie() {
        return energie;
    }

    public void setEnergie(EnumEnergie energie) {
        this.energie = energie;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "energie : " + energie ;
    }
}
