package fr.eni.maj_loc_android.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.eni.maj_loc_android.utils.AppActivity;
import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.Models.Voiture;
import fr.eni.maj_loc_android.Models.VoitureAdapterList;

public class NewReservationListeActivity extends AppActivity implements AdapterView.OnItemClickListener{

    private List<Voiture> myListeVoitures;
    private ListView listViewVoitures;
    private VoitureAdapterList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation_liste);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewResaListe");


        myListeVoitures = new ArrayList<>();


        listViewVoitures = (ListView) findViewById(R.id.listVoituresResa);
        adapter = new VoitureAdapterList(this,0,myListeVoitures);
        listViewVoitures.setAdapter(adapter);
        listViewVoitures.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Voiture voiture = myListeVoitures.get(i);
        Intent intent = new Intent(NewReservationListeActivity.this, NewReservationDetailsActivity.class);

        Log.i("oo", "passe dans 1er");

        Bundle bundle = new Bundle();
        bundle.putSerializable("voiture", voiture);
        intent.putExtras(bundle);



        startActivity(intent);
    }
}
