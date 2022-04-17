package com.gis.a001043utsga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.gis.a001043utsga.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gantiFragment(new lokasiSaatIniFragment());
        binding.title.setText(getString(R.string.t1));
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.lsi:
                    gantiFragment(new lokasiSaatIniFragment());
                    binding.title.setText(getString(R.string.t1));
                    break;
                case R.id.pl:
                    gantiFragment(new pencarianLokasiFragment());
                    binding.title.setText(getString(R.string.t2));
                    break;
                case R.id.tls:
                    gantiFragment(new titikLokasiFragment());
                    binding.title.setText(getString(R.string.t3));
                    break;
            }

            return true;
        });

    }

    private void gantiFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}