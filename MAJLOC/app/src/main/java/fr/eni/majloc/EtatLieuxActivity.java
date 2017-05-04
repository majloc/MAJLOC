package fr.eni.majloc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.fr.eni.models.Voiture;

public class EtatLieuxActivity extends AppCompatActivity {

    private Voiture tuture;
    private TextView textMarque, textModele, textImmat, textType, textEnergie;
    private ImageView imagePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etat_lieux);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" Principal");

        Voiture voiture = (Voiture) getIntent().getExtras().get("voiture");

        textMarque = (TextView) findViewById(R.id.marque);
        textModele = (TextView) findViewById(R.id.modele);
        //textImmat = (TextView) findViewById(R.id.immatriculation);

        textMarque.setText(voiture.getMarque());
        textModele.setText(voiture.getModele());

    }
}
