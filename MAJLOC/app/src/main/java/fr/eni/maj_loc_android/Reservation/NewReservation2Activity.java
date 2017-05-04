package fr.eni.maj_loc_android.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.eni.maj_loc_android.AppActivity;
import fr.eni.maj_loc_android.R;

public class NewReservation2Activity extends AppActivity {

    private Spinner spinType, spinEnergie, spinMarque, spinModele;
    private SeekBar seekPrix;
    private TextView textPrix;
    private List<String> listeTypes, listeEnergies, listeMarques, listeModeles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation2);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewResa");

        listeTypes = new ArrayList<>();
        listeTypes.add("Citadine");
        listeTypes.add("Berline");
        listeTypes.add("Monospace");
        listeTypes.add("Utilitaire");

        listeEnergies = new ArrayList<>();
        //listeEnergies.add(Energie.lesEnergies);
        listeEnergies.add("Essence");
        listeEnergies.add("Diesel");
        listeEnergies.add("Hybride");
        listeEnergies.add("Electrique");

        listeMarques = new ArrayList<>();
        listeMarques.add("Peu importe");
        listeMarques.add("Renault");
        listeMarques.add("Peugeot");
        listeMarques.add("Citroen");
        listeMarques.add("Fiat");
        listeMarques.add("BMW");
        listeMarques.add("Audi");

        listeModeles = new ArrayList<>();
        listeModeles.add("Clio 4");


        textPrix = (TextView) findViewById(R.id.textPrix);
        seekPrix = (SeekBar) findViewById(R.id.seekPrix);
        spinType = (Spinner) findViewById(R.id.spinType);
        spinEnergie = (Spinner) findViewById(R.id.spinEnergie);
        spinMarque = (Spinner) findViewById(R.id.spinMarque);
        //spinModele = (Spinner) findViewById(R.id.spinModele);



        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeTypes);

        ArrayAdapter<String> adapterEnergie = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeEnergies);

        ArrayAdapter<String> adapterMarque = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeMarques);

        //ArrayAdapter<String> adapterModele = new ArrayAdapter<String>(this,
                //android.R.layout.simple_spinner_item, listeModeles);

        spinType.setAdapter(adapterType);
        spinEnergie.setAdapter(adapterEnergie);
        spinMarque.setAdapter(adapterMarque);
        seekPrix.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textPrix.setText((String.valueOf(i*2.5)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //spinModele.setAdapter(adapterModele);


    }

    public void showListePourResa(View view) {

        Intent intent = new Intent(NewReservation2Activity.this, NewReservationListeActivity.class);
        startActivity(intent);
    }
}
