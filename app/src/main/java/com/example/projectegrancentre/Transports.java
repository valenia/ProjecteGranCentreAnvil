package com.example.projectegrancentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class Transports extends AppCompatActivity implements View.OnClickListener {

    Button bus,tren,taxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transports);
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
                        Intent home = new Intent(getApplicationContext(),MainActivity.class);startActivity(home);break;
                    case R.id.nav_business:
                        Intent business = new Intent(getApplicationContext(),business.class);startActivity(business);break;
                    case R.id.nav_movie:
                        Intent movies = new Intent(getApplicationContext(),movies.class);startActivity(movies);break;
                    case R.id.nav_hotels:
                        Intent hotels = new Intent(getApplicationContext(),hotels.class);startActivity(hotels);break;
                    case R.id.nav_parking:
                        Intent parking = new Intent(getApplicationContext(),parking.class);startActivity(parking);break;
                    case R.id.nav_restaurants:
                        Intent restaurant = new Intent(getApplicationContext(),Restaurants.class);startActivity(restaurant);break;
                    case R.id.nav_transport:
                        Intent transport = new Intent(getApplicationContext(),Transports.class);startActivity(transport);break;
                    default:
                        return true;
                }
                return true;
            }
        });

        //Assignació de views a variables tipus Button
        bus = findViewById(R.id.busFilter);
        tren = findViewById(R.id.trenFilter);
        taxi = findViewById(R.id.taxiFilter);

        //Vincular setOnClikListener per cridar al fragment
        bus.setOnClickListener(this);
        tren.setOnClickListener(this);
        taxi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int idRebuda = view.getId();
        FragmentManager fm = getSupportFragmentManager();

        switch (idRebuda)
        {
            case R.id.busFilter:
                {
                    bus busfragment = new bus();
                    fm.beginTransaction().replace(R.id.scrollTransports,busfragment).commit();
                    break;
                }
            case R.id.taxiFilter:
                {
                    taxi taxifragment = new taxi();
                    fm.beginTransaction().replace(R.id.scrollTransports,taxifragment).commit();
                    break;
                }
            case R.id.trenFilter:
            {
                tren trenfragment = new tren();
                fm.beginTransaction().replace(R.id.scrollTransports,trenfragment).commit();
                break;
            }
        }

    }
}