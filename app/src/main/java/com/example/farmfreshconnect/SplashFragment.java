package com.example.farmfreshconnect;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_splash); // Ensure this layout file exists

        // Delay of 3 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity, e.g., MainActivity
                Intent intent = new Intent(SplashFragment.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the splash screen activity
            }
        }, 3000); // 3000 milliseconds = 3 seconds
    }
}
