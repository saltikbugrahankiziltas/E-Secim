package com.example.dnemsonuprojesi;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OyNavi extends AppCompatActivity {

    BottomNavigationView bottomNavim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oynavi);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new CumhurFragment()).commit();
        bottomNavim=findViewById(R.id.bnavim);

        bottomNavim.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Cumhurbaşkanlığı:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new CumhurFragment()).commit();
                        break;
                    case R.id.Parti:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new PartiFragment()).commit();
                        break;

                }
                return true;
            }
        });
        }
}
