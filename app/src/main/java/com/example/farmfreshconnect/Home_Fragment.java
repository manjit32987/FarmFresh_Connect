package com.example.farmfreshconnect;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmfreshconnect.databinding.FragmentHomeBinding;

public class Home_Fragment extends Fragment {

    private DrawerLayout drawerLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Access the DrawerLayout through the public method in MainActivity
        if (getActivity() instanceof MainActivity) {
            drawerLayout = ((MainActivity) getActivity()).getDrawerLayout();
        }

        // Handle profile icon click to open the drawer
        binding.profileIcon.setOnClickListener(v -> {
            if (drawerLayout != null) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        return binding.getRoot();
    }
}
