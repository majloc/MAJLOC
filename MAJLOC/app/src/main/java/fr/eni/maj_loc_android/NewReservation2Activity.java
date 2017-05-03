package fr.eni.maj_loc_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NewReservation2Activity extends AppActivity {

    private Spinner spinType, spinEnergie;
    private List<String> listeTypes, listeEnergies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation2);

        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle("MajLoc");

        listeTypes = new ArrayList<>();
        listeTypes.add("Citadine");
        listeTypes.add("Berline");
        listeTypes.add("Monospace");
        listeTypes.add("Utilitaire");

        listeEnergies = new ArrayList<>();
        listeEnergies.add("Essence");
        listeEnergies.add("Gazoil");
        listeEnergies.add("Hybride");
        listeEnergies.add("Electrique");

        spinType = (Spinner) findViewById(R.id.spinType);
        spinEnergie = (Spinner) findViewById(R.id.spinEnergie);



        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeTypes);

        ArrayAdapter<String> adapterEnergie = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeEnergies);

        spinType.setAdapter(adapterType);
        spinEnergie.setAdapter(adapterEnergie);


    }
}
