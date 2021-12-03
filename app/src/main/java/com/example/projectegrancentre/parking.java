package com.example.projectegrancentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class parking extends AppCompatActivity {
    /* Eva, sols he fet el layout en vertical/protrait, ja que tal i com l'he
    dissenyat el telefon ja mostra be el layout encara que el tombi i el posi en horitzontal
    o landscape, es per aixo que no he creat un altre layout especific */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.lateral_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.nav_home:
                    {
                        Intent Main = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(Main);
                        break;
                    }
                    case R.id.nav_business:
                    {
                        Intent Negocis = new Intent(getApplicationContext(),business.class);
                        startActivity(Negocis);
                        break;
                    }
                    case R.id.nav_movie:
                    {
                        Intent Pelis = new Intent(getApplicationContext(),movies.class);
                        startActivity(Pelis);
                        break;
                    }
                    case R.id.nav_hotels:
                    {
                        Intent Hotels = new Intent(getApplicationContext(),hotels.class);
                        startActivity(Hotels);
                        break;
                    }
                    case R.id.nav_parking:
                    {
                        Intent Parking = new Intent(getApplicationContext(),parking.class);
                        startActivity(Parking);
                        break;
                    }
                    case R.id.nav_restaurants:
                    {
                        Intent Restaurants = new Intent(getApplicationContext(),Restaurants.class);
                        startActivity(Restaurants);
                        break;
                    }
                    case R.id.nav_transport:
                    {
                        Intent Transports = new Intent(getApplicationContext(),Transports.class);
                        startActivity(Transports);
                        break;
                    }
                    default:
                        return true;
                }
                return true;
            }
        });
    }
}