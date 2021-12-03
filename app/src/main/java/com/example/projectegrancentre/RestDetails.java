package com.example.projectegrancentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class RestDetails extends AppCompatActivity {

    ClRestaurant selectedRest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_details);
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

        getSelectedRestaurant();
        setValues();

        //Intents telf, map and web
        TextView restShowed = (TextView) findViewById(R.id.rest_name);
        String restNameShowed = restShowed.getText().toString();
        String xmlName = restNameShowed.toLowerCase();
        xmlName = xmlName.replace(" ","");

        Integer idarray = getApplicationContext().getResources().getIdentifier(xmlName,"array",getApplicationContext().getPackageName());
        String restData[]=getApplicationContext().getResources().getStringArray(idarray);


        //Call
        ImageView restcall = (ImageView) findViewById(R.id.rest_call);
        restcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+restData[0]));
                startActivity(intentCall);
            }
        });

        //Map
        ImageView restMap = (ImageView) findViewById(R.id.rest_map);
        restMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+restData[1]+"?q="+restNameShowed+" Granollers "));
                startActivity(intentMap);
            }
        });

        //Web
        ImageView restWeb = (ImageView) findViewById(R.id.rest_web);
        restWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(restData[2]));
                startActivity(intentWeb);
            }
        });
    }

    private void getSelectedRestaurant()
    {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedRest = Restaurants.restList.get(Integer.valueOf(parsedStringID));

    }

    private void setValues()
    {
        TextView nameRest = (TextView) findViewById(R.id.rest_name);
        TextView descripRest = (TextView) findViewById(R.id.rest_descrip);
        ImageView imgRest = (ImageView) findViewById(R.id.rest_image);

        nameRest.setText(selectedRest.getName());
        descripRest.setText(selectedRest.getDescrip());
        imgRest.setImageResource(selectedRest.getImg());
    }
}