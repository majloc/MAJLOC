package fr.eni.majloc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.eni.maj_loc_android.MainActivity;
import fr.eni.maj_loc_android.NewCarActivity2;
import fr.eni.maj_loc_android.PhotoActivity;
import fr.eni.maj_loc_android.R;
import fr.eni.maj_loc_android.fr.eni.models.Voiture;

public class EtatLieuxActivity extends AppCompatActivity {

    private Voiture tuture;
    private TextView textMarque, textModele, textImmat, textType, textEnergie;
    private ImageView imagePhoto;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    private File mFichier;
    private String mCurrentPhotoPath;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etat_lieux);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" Principal");

        Voiture voiture = (Voiture) getIntent().getExtras().get("voiture");
        mImageView = (ImageView) findViewById(R.id.imgRetour);

        textMarque = (TextView) findViewById(R.id.marque);
        textModele = (TextView) findViewById(R.id.modele);
        //textImmat = (TextView) findViewById(R.id.immatriculation);

        textMarque.setText(voiture.getMarque());
        textModele.setText(voiture.getModele());

    }



    public void PrendrePhotos(View view) {

        Intent takePictureIntent = new Intent(EtatLieuxActivity.this, PhotoActivity.class);
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
            Toast.makeText(EtatLieuxActivity.this, extras, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(EtatLieuxActivity.this, "Permission refusée", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    public void retourAccueil(View view) {




        Toast.makeText(EtatLieuxActivity.this, "Retour enregistré, passer au paiement",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(EtatLieuxActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
