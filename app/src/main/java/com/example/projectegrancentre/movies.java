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

public class movies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movies);
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
                        Intent Main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(Main);
                        break;
                    case R.id.nav_business:
                        Intent Business = new Intent(getApplicationContext(), business.class);
                        startActivity(Business);
                        break;
                    case R.id.nav_movie:
                        Intent Movies = new Intent(getApplicationContext(), movies.class);
                        startActivity(Movies);
                        break;
                    case R.id.nav_hotels:
                        Intent Hotels = new Intent(getApplicationContext(), hotels.class);
                        startActivity(Hotels);
                        break;
                    case R.id.nav_parking:
                        Intent Parkings = new Intent(getApplicationContext(), parking.class);
                        startActivity(Parkings);
                        break;
                    case R.id.nav_restaurants:
                        Intent restaurants = new Intent(getApplicationContext(), Restaurants.class);
                        startActivity(restaurants);
                        break;
                    case R.id.nav_transport:
                        Intent transports = new Intent(getApplicationContext(), Transports.class);
                        startActivity(transports);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
}