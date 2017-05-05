package fr.eni.maj_loc_android.NewCar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import fr.eni.maj_loc_android.utils.AppActivity;
import fr.eni.maj_loc_android.R;

public class NewCarActivity1 extends AppActivity {

    private Spinner spinType, spinEnergie, spinMarque;
    private List<String> listeTypes, listeEnergies, listeMarques;
    private EditText editModele;
    private String type, energie, marque, modele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car1);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewCar");


        listeTypes = new ArrayList<>();
        listeTypes.add("Selectionner un type");
        listeTypes.add("Citadine");
        listeTypes.add("Berline");
        listeTypes.add("Monospace");
        listeTypes.add("Utilitaire");

        listeEnergies = new ArrayList<>();
        listeEnergies.add("Selectionner une energie");
        listeEnergies.add("Essence");
        listeEnergies.add("Diesel");
        listeEnergies.add("Hybride");
        listeEnergies.add("Electrique");

        listeMarques = new ArrayList<>();
        listeMarques.add("Selectionner une marque");
        listeMarques.add("Renault");
        listeMarques.add("Peugeot");
        listeMarques.add("Citroen");
        listeMarques.add("Fiat");
        listeMarques.add("BMW");
        listeMarques.add("Audi");


        spinType = (Spinner) findViewById(R.id.spinType);
        spinEnergie = (Spinner) findViewById(R.id.spinEnergie);
        spinMarque = (Spinner) findViewById(R.id.spinMarque);
        editModele = (EditText) findViewById(R.id.editModele);




        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeTypes);

        ArrayAdapter<String> adapterEnergie = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeEnergies);

        ArrayAdapter<String> adapterMarque = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listeMarques);


        spinType.setAdapter(adapterType);
        spinEnergie.setAdapter(adapterEnergie);
        spinMarque.setAdapter(adapterMarque);

    }

    public void showNewCar2(View view) {


        type = (String) spinType.getSelectedItem();
        energie = (String) spinEnergie.getSelectedItem();
        marque = (String) spinMarque.getSelectedItem();
        modele = editModele.getText().toString();


        Intent intent = new Intent(NewCarActivity1.this, NewCarActivity2.class);
        intent.putExtra("type", type);
        intent.putExtra("energie", energie);
        intent.putExtra("marque", marque);
        intent.putExtra("modele", modele);

        startActivity(intent);
    }
}
