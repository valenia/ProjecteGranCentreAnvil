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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class hotels extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    /* Eva, sols he fet el layout en vertical/protrait, ja que tal i com l'he
    dissenyat el telefon ja mostra be el layout encara que el tombi i el posi en horitzontal
    o landscape, es per aixo que no he creat un altre layout especific */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
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
        Spinner spinner = (Spinner) findViewById(R.id.spinner_hotels);
        // Carrego l'array adapter amb l'array que he definit a Resources. I un layout per defecte
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.hotels_array,android.R.layout.simple_spinner_item);
        // Especifico el layout que es te que carregar quan es mostra la llista
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplico l'adaptador al spinner
        spinner.setAdapter(adapter);
        // Activo el listener
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String categoria = (String)adapterView.getItemAtPosition(i);
        if (categoria!="Escull una opció")
        {
            // Ojo, sols estan implementades com cal les categories de 2, 3, 4 estrelles. La de 1 i la de 5
            // Sols son plantilles molt bàsiques.
            switch(categoria){
                case "1 estrella":{
                    FragmentManager fm = getSupportFragmentManager();
                    //No poso l'if ja que m'es igual el contingut, el machacaré quan la opció canvii, sempre.
                    hotels1 hotels1 = new hotels1();
                    fm.beginTransaction().replace(R.id.container,hotels1).commit();
                    break;
                }
                case "2 estrelles":{
                    FragmentManager fm = getSupportFragmentManager();
                    hotels2 hotels2 = new hotels2();
                    fm.beginTransaction().replace(R.id.container,hotels2).commit();
                    break;
                }
                case "3 estrelles":{
                    FragmentManager fm = getSupportFragmentManager();
                    hotels3 hotels3 = new hotels3();
                    fm.beginTransaction().replace(R.id.container,hotels3).commit();
                    break;
                }
                case "4 estrelles":{
                    FragmentManager fm = getSupportFragmentManager();
                    hotels4 hotels4 = new hotels4();
                    fm.beginTransaction().replace(R.id.container,hotels4).commit();
                    break;
                }
                case "5 estrelles":{
                    FragmentManager fm = getSupportFragmentManager();
                    hotels5 hotels5 = new hotels5();
                    fm.beginTransaction().replace(R.id.container,hotels5).commit();
                    break;
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Decideixo deixar en blanc si no hi ha cap selecció.
    }
}