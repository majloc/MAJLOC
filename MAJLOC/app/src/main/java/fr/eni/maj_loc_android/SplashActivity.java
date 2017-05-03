package fr.eni.maj_loc_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //lancer activité home
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                //finish si pas de "no history" dans le manifest
                //finish();
            }
        },1000);
    }
}
