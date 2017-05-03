package fr.eni.maj_loc_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrateur on 02/05/2017.
 */

public class LoginActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void showHome(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

}
