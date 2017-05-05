package fr.eni.maj_loc_android.NewCar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.maj_loc_android.LoginActivity;
import fr.eni.maj_loc_android.utils.AppActivity;
import fr.eni.maj_loc_android.MainActivity;
import fr.eni.maj_loc_android.utils.PhotoActivity;
import fr.eni.maj_loc_android.R;

public class NewCarActivity2 extends AppActivity {

    private String type, energie, marque, modele, immat, prix, photo, agence, nbPlaces;
    private EditText editImmat, editPrix, editNBPlaces;
    private String messageRetour;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    private File mFichier;
    private String mCurrentPhotoPath;

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


        photo = "photo1;";
        agence = "LocaWhaa";




    }

    public void PrendrePhotos(View view) {

        Intent takePictureIntent = new Intent(NewCarActivity2.this, PhotoActivity.class);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    //check de condition si l'appareil est en android API23+
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 10);
                    }

                    return;
                }
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile("photo",".jpg"
                /*imageFileName,  *//* prefix *//*
                ".jpg",         *//* suffix *//*
                storageDir      *//* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("p", "onactivity");
        if (requestCode == REQUEST_IMAGE_CAPTURE ) {
            String extras = data.getStringExtra("truc");
            Toast.makeText(NewCarActivity2.this, extras, Toast.LENGTH_SHORT).show();
            /*Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);*/
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 10){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){ //accordée
                PrendrePhotos(null);
            }else{ //refuséé
                Toast.makeText(NewCarActivity2.this, "Permission refusée", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



    public void insertCar(View view) {

        prix = editPrix.getText().toString();
        immat = editImmat.getText().toString();
        nbPlaces = editNBPlaces.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(NewCarActivity2.this);
        String url = "http://10.4.140.27:8080/WEBMAJLOC/rest/voiture/newcar";

        StringRequest jsonObjRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(NewCarActivity2.this, "Voiture OK!", Toast.LENGTH_LONG).show();
            }


                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewCarActivity2.this, "Voiture PAS!", Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("marque", marque);
                params.put("modele", modele);
                params.put("type", type);
                params.put("energie", energie);
                params.put("plaque", immat);
                params.put("prixParJour", prix);
                params.put("nbPlace", nbPlaces);
                params.put("photos", photo);
                params.put("agence", agence);
                return params;
            }

        };



        //AppController.getInstance().addToRequestQueue(jsonObjRequest);

        queue.add(jsonObjRequest);

        //TODO: enregistrer la voiture comme etant Créée

        Toast.makeText(NewCarActivity2.this, "Voiture enregistrée",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(NewCarActivity2.this, MainActivity.class);
        startActivity(intent);

    }
}
