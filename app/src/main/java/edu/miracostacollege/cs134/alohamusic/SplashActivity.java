package edu.miracostacollege.cs134.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Wait 2-3 seconds, then fire Intent to MainActivity
        // TimerTask waits a period of time before performing a task
        TimerTask task = new TimerTask() {
            /**
             * The action to be performed by this timer task.
             */
            @Override
            public void run() {
                // Create an Intent to go to MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Let's close (finish) the SplashActivity
                finish();
            }
        };

        // Let's define a Timer for when the task should happen
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
