package fr.eni.maj_loc_android.Reservation;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import fr.eni.maj_loc_android.AppActivity;
import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.fr.eni.models.Client;
import fr.eni.maj_loc_android.fr.eni.models.ClientAdapter;
import fr.eni.maj_loc_android.fr.eni.models.Voiture;

public class NewReservation1Activity extends AppActivity implements AdapterView.OnItemClickListener{

    private List<Client> myListeClients = new ArrayList<>();
    private ListView listViewClients;
    private ClientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation1);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewResa");

        //permet de virer le focus automatique sur la barre de recherche (qui empeche de voir la liste)
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        RequestQueue queue = Volley.newRequestQueue(NewReservation1Activity.this);
        String url = "http://10.4.140.27:8080/WEBMAJLOC/rest/client/allclients";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson json = new Gson();

                Log.i("f", "onresponse");

                listViewClients = (ListView) findViewById(R.id.listClients);

                myListeClients = json.fromJson(response, new TypeToken<List<Client>>() {
                }.getType());
                adapter = new ClientAdapter(NewReservation1Activity.this, 0, myListeClients);

                listViewClients.setAdapter(adapter);
                listViewClients.setOnItemClickListener(NewReservation1Activity.this);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("h", "onerror");
            }
        });

        queue.add(stringRequest);

        /*myListeClients = new ArrayList<>();
        myListeClients.add(new Client("Sam", "Gratte", "samgratte@gmail.com", "0200000000", "20 rue des acacias"));
        myListeClients.add(new Client("Yvan", "Dubois", "yvandubois@gmail.com", "0200000000", "10 rue des mimosas"));
        myListeClients.add(new Client("Eva", "Pabien", "evapabien@gmail.com", "0200000000", "5 rue des tulipes"));
        myListeClients.add(new Client("Anne", "Homalie", "annehomalie@gmail.com", "0200000000", "50 rue des roses"));

        listViewClients = (ListView) findViewById(R.id.listClients);
        adapter = new ClientAdapter(NewReservation1Activity.this,0,myListeClients);
        listViewClients.setAdapter(adapter);
        listViewClients.setOnItemClickListener(this);*/

    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_reservation_1, menu);
        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Client client = myListeClients.get(i);
        Intent intent = new Intent(NewReservation1Activity.this, NewReservation2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("client", client);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_ajout) {

            //passage sur la fenetre de creation du client
            Intent intent = new Intent(NewReservation1Activity.this, NewReservation1_creationActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
