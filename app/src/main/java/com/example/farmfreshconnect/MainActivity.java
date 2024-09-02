package com.example.farmfreshconnect;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.farmfreshconnect.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawerLayout = binding.drawerLayout;

        // Set up bottom navigation item selection listener
        binding.bottomnavigation.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_nav_home) {
                selectedFragment = new Home_Fragment();
            } else if (itemId == R.id.bottom_nav_cart) {
                selectedFragment = new Home_Fragment();
            } else if (itemId == R.id.bottom_nav_order) {
                selectedFragment = new Home_Fragment();
            } else if (itemId == R.id.bottom_nav_setting) {
                selectedFragment = new Home_Fragment();
            }

            if (selectedFragment != null) {
                replaceFragment(selectedFragment);
            }
            return true;
        });

        // Handle Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("SELECTED_MENU_ITEM")) {
            int selectedItemId = intent.getIntExtra("SELECTED_MENU_ITEM", -1);
            if (selectedItemId != -1) {
                binding.bottomnavigation.setSelectedItemId(selectedItemId);
            }
        }

        // Load the default fragment
        if (savedInstanceState == null) {
            replaceFragment(new Home_Fragment());
        }
    }

    // Public method to access DrawerLayout
    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
