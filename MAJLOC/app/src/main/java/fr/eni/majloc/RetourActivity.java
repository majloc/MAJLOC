package fr.eni.majloc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.eni.maj_loc_android.AppActivity;
import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.Reservation.NewReservationListeActivity;
import fr.eni.maj_loc_android.fr.eni.models.Voiture;
import fr.eni.maj_loc_android.fr.eni.models.VoitureAdapterList;

public class RetourActivity extends AppActivity implements AdapterView.OnItemClickListener {

    private List<Voiture> myListeVoitures;
    private ListView listViewVoiture;
    private VoitureAdapterList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retour);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" Principal");

        myListeVoitures = new ArrayList<>();
        myListeVoitures.add(new Voiture("Renault", "Clio 4", "AA-880-AA"));

        listViewVoiture = (ListView) findViewById(R.id.listRetour);
        adapter = new VoitureAdapterList(this,0,myListeVoitures);
        listViewVoiture.setAdapter(adapter);
        listViewVoiture.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        Voiture voiture = myListeVoitures.get(i);
        Intent intent = new Intent(RetourActivity.this, EtatLieuxActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("voiture", voiture);
        intent.putExtras(bundle);



        startActivity(intent);
    }
}
