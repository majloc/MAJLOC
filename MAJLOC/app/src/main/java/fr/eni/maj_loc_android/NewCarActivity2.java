package fr.eni.maj_loc_android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fr.eni.maj_loc_android.AppActivity;
import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.Reservation.NewReservation1Activity;
import fr.eni.maj_loc_android.fr.eni.models.Agence;
import fr.eni.maj_loc_android.fr.eni.models.Client;
import fr.eni.maj_loc_android.fr.eni.models.ClientAdapter;
import fr.eni.maj_loc_android.fr.eni.models.Voiture;

public class NewCarActivity2 extends AppActivity {

    private String type, energie, marque, modele, immat, prix, photo, agence, nbPlaces;
    private EditText editImmat, editPrix, editNBPlaces;
    private String messageRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car2);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewCar");

        type = getIntent().getStringExtra("type");
        energie = getIntent().getStringExtra("energie");
        marque = getIntent().getStringExtra("marque");
        modele = getIntent().getStringExtra("modele");

        editImmat = (EditText) findViewById(R.id.editImmatriculation);
        editPrix = (EditText) findViewById(R.id.editPrix);
        editNBPlaces = (EditText) findViewById(R.id.editNbPlaces);

        prix = editPrix.getText().toString();
        immat = editImmat.getText().toString();
        photo = "photo1";
        agence = "LocaWhaa";
        nbPlaces = editNBPlaces.getText().toString();



    }

    public void PrendrePhotos(View view) {
    }



    public void insertCar(View view) {


        RequestQueue queue = Volley.newRequestQueue(NewCarActivity2.this);
        String url = "http://10.4.140.27:8080/WEBMAJLOC/rest/voiture/newcar";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson json = new Gson();

                messageRetour = json.toJson(response, new TypeToken<List<String>>() {
                }.getType());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }
}
