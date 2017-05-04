package fr.eni.maj_loc_android.fr.eni.models;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import fr.eni.maj_loc_android.ListAllCarsActivity;
import fr.eni.maj_loc_android.R;


public class ListCarsLouesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars_loues);


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


}
}
