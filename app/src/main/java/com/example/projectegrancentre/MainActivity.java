package com.example.projectegrancentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton ibHotels,ibParking,ibRestaurants,ibTransports,ibMovies,ibBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assignació de views a variables tipus ImageButtons
        ibHotels=findViewById(R.id.ib_hotels);
        ibParking=findViewById(R.id.ib_parking);
        ibRestaurants=findViewById(R.id.ib_restaurants);
        ibTransports=findViewById(R.id.ib_transports);
        ibMovies=findViewById(R.id.ib_cartellera);
        ibBusiness=findViewById(R.id.ib_business);

        //Vincular setOnClikListener per cridar al intent
        ibHotels.setOnClickListener(this);
        ibParking.setOnClickListener(this);
        ibRestaurants.setOnClickListener(this);
        ibTransports.setOnClickListener(this);
        ibMovies.setOnClickListener(this);
        ibBusiness.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Al fer un implements podem arribar aqui a partir de qualsevol boto. Tenim que filtrar quin hem clickat.
        int idRebuda = view.getId(); // Per fer el codi mes llegible a tots els ifs, guardem la id rebuda en una variable.
        if (ibHotels.getId()==idRebuda){
            Intent hotels = new Intent(this,hotels.class);
            startActivity(hotels);
        }
        else if (ibParking.getId()==idRebuda){
            Intent parking = new Intent(this,parking.class);
            startActivity(parking);
        }
        else if(ibRestaurants.getId()==idRebuda){
            Intent restaurants = new Intent(this,Restaurants.class);
            startActivity(restaurants);
        }
        else if(ibTransports.getId()==idRebuda){
            Intent transports = new Intent(this,Transports.class);
            startActivity(transports);
        }
        else if(ibMovies.getId()==idRebuda){
            Intent movies = new Intent(this,movies.class);
            startActivity(movies);
        }
        else if(ibBusiness.getId()==idRebuda){
            Intent business = new Intent(this,business.class);
            startActivity(business);
        }
    }
}