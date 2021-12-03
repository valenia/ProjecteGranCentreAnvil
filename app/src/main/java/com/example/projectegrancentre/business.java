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
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import android.widget.AdapterView.OnItemSelectedListener;

public class business extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_business);
        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.lateral_menu);

        FragmentManager fm = getSupportFragmentManager();
        business_MainFragment fragment = new business_MainFragment();
        fm.beginTransaction().replace(R.id.idBusinessMainFragment, fragment).commit();

        Spinner spinnerNegoci = (Spinner) findViewById(R.id.spinnerNegoci);
        spinnerNegoci.setOnItemSelectedListener(this);

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
                if(id==R.id.nav_home){
                    Intent Main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(Main);
                }else if(id==R.id.nav_business){
                    Intent Business = new Intent(getApplicationContext(), business.class);
                    startActivity(Business);
                }else if(id==R.id.nav_movie){
                    Intent Movies = new Intent(getApplicationContext(), movies.class);
                    startActivity(Movies);
                }else if(id==R.id.nav_hotels){
                    Intent Hotels = new Intent(getApplicationContext(), hotels.class);
                    startActivity(Hotels);
                }else if(id==R.id.nav_parking){
                    Intent Parkings = new Intent(getApplicationContext(), parking.class);
                    startActivity(Parkings);
                }else if(id==R.id.nav_restaurants){
                    Intent restaurants = new Intent(getApplicationContext(), Restaurants.class);
                    startActivity(restaurants);
                }else if(id==R.id.nav_transport){
                    Intent transports = new Intent(getApplicationContext(), Transports.class);
                    startActivity(transports);
                }
                return true;
            }
        });
    }

    @Override
    public void onItemSelected (AdapterView <?> parent, View v,int pos, long id)
    {
        FragmentManager fm = getSupportFragmentManager();
        String item = parent.getItemAtPosition(pos).toString();

        switch (item) {
            case "Seleccionar categories": {
                business_MainFragment fragment = new business_MainFragment();
                fm.beginTransaction().replace(R.id.idBusinessMainFragment, fragment).commit();
                break;
            }
            case "Tallers": {
                business_TheFragmentTallers fragment = new business_TheFragmentTallers();
                fm.beginTransaction().replace(R.id.idBusinessMainFragment, fragment).commit();
                break;
            }
            case "Perruqueries": {
                business_TheFragmentPerruqueries fragment = new business_TheFragmentPerruqueries();
                fm.beginTransaction().replace(R.id.idBusinessMainFragment, fragment).commit();
                break;
            }
            case "Botigues": {
                business_TheFragmentButigues fragment = new business_TheFragmentButigues();
                fm.beginTransaction().replace(R.id.idBusinessMainFragment, fragment).commit();
                break;
            }
        }
    }

    @Override
    public void onNothingSelected (AdapterView <?> arg0){
      
    }
}