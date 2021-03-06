package fr.eni.maj_loc_android;

import android.os.Bundle;
import android.view.View;
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

import fr.eni.maj_loc_android.Models.Voiture;
import fr.eni.maj_loc_android.Models.VoitureAdapterList;
import fr.eni.maj_loc_android.utils.AppActivity;

public class ListAllCarsActivity extends AppActivity implements AdapterView.OnItemClickListener {

    List<Voiture> listallcars = new ArrayList<>();
    private ListView listViewAllCars;
    private VoitureAdapterList voitureadapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_cars);



        listViewAllCars = (ListView) findViewById(R.id.listViewAllCars);



        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(ListAllCarsActivity.this);
        String url = "http://10.4.140.27:8080/WEBMAJLOC/rest/voiture/allcars";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { // 200

                        Gson gson = new Gson();

                        listallcars = gson.fromJson(response, new TypeToken<List<Voiture>>(){}.getType());
                        voitureadapter = new VoitureAdapterList(ListAllCarsActivity.this,0,listallcars);

                        listViewAllCars.setAdapter(voitureadapter);
                        listViewAllCars.setOnItemClickListener(ListAllCarsActivity.this);

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                    if (error.networkResponse != null) {
                    String response = new String(error.networkResponse.data);


                }

            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);



    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
