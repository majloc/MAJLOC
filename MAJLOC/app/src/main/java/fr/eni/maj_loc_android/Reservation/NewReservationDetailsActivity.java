package fr.eni.maj_loc_android.Reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.Models.Voiture;

public class NewReservationDetailsActivity extends AppCompatActivity {

    private Voiture tuture;
    private TextView textMarque, textModele, textImmat, textType, textEnergie;
    private ImageView imagePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation_details);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewResaDetails");

        Log.i("pp", "passe dans 2eme");

        Voiture obj = (Voiture) getIntent().getExtras().get("voiture");

        Log.i("oo", obj.getMarque());

        textMarque = (TextView) findViewById(R.id.marque);
        textModele = (TextView) findViewById(R.id.modele);
        //textImmat = (TextView) findViewById(R.id.immatriculation);

        textMarque.setText(obj.getMarque());
        textModele.setText(obj.getModele());
    }
}
