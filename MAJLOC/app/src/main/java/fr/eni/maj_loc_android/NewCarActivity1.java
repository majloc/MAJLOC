package fr.eni.maj_loc_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewCarActivity1 extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car1);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setIcon(R.drawable.logolokacarpetit);
        this.getSupportActionBar().setTitle(" NewCar");


    }

    public void showNewCar2(View view) {

        Intent intent = new Intent(NewCarActivity1.this, NewCarActivity2.class);
        startActivity(intent);
    }
}
