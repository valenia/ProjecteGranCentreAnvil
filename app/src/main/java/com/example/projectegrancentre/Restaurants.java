package com.example.projectegrancentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Locale;

public class Restaurants extends AppCompatActivity {

    public static ArrayList<ClRestaurant> restList = new ArrayList<ClRestaurant>();
    private ListView restListView;

    private String selectedFilter = "all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
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

        //Assignació botons de filtre
        //All
        Button allFilter = (Button) findViewById(R.id.allFilter);
        allFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedFilter = "all";
                RestAdapter adapter = new RestAdapter(getApplicationContext(),0,restList);
                restListView.setAdapter(adapter);
            }
        });

        //Mediterrania
        Button meditFilter = (Button) findViewById(R.id.meditFilter);
        meditFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterList("mediterrani");
            }
        });

        //Catalana
        Button catalanFilter = (Button) findViewById(R.id.catalanFilter);
        catalanFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterList("catalana");
            }
        });

        //Japonès
        Button japanFilter = (Button) findViewById(R.id.japanFilter);
        japanFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterList("japonès");
            }
        });

        //GastroBar
        Button gastroFilter = (Button) findViewById(R.id.gastroFilter);
        gastroFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterList("gastrobar");
            }
        });

        //Italià
        Button italianFilter = (Button) findViewById(R.id.italianFilter);
        italianFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterList("italià");
            }
        });

        initSearchWidget();
        setupData();
        setupList();
        setupOnclickListener();
    }

    private void initSearchWidget()
    {
        SearchView searchRest = (SearchView) findViewById(R.id.restSearchView);

        searchRest.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<ClRestaurant> filteredRest = new ArrayList<ClRestaurant>();
                for(ClRestaurant restaurant: restList )
                {
                    if(restaurant.getName().toLowerCase(Locale.ROOT).contains(s.toLowerCase()))
                    {
                        filteredRest.add(restaurant);
                    }
                }

                RestAdapter restAdapter = new RestAdapter(getApplicationContext(),0,filteredRest);
                restListView.setAdapter(restAdapter);

                return false;
            }
        });
    }

    private void  setupData()
    {
        if(restList.isEmpty()){
            ClRestaurant cangallina = new ClRestaurant("0","Can Gallina","Noves experiències culinàries que no deixaran indiferent.","GastroBar",R.drawable.cangallina);
            restList.add(cangallina);

            ClRestaurant canpalau = new ClRestaurant("1","La Rectoria de Palou","Cuina catalana en una preciosa masia.","Catalana",R.drawable.canpalau);
            restList.add(canpalau);

            ClRestaurant cityrestaurant = new ClRestaurant("2","City Restaurant","Tast de la millor cuina mediterrània.","Mediterrani",R.drawable.cityrestaurant);
            restList.add(cityrestaurant);

            ClRestaurant eltrull = new ClRestaurant("3","El Trull","Tapes i plats al centre de Granollers.","Mediterrani",R.drawable.el_trull);
            restList.add(eltrull);

            ClRestaurant kodama = new ClRestaurant("4","Kodama","Un tast interessant a la cuina japonesa.","Japonès",R.drawable.kodama);
            restList.add(kodama);

            ClRestaurant naguabo = new ClRestaurant("5","Naguabo","Menjar italià de qualitat juntament amb propostes locals.","Italià",R.drawable.naguabo);
            restList.add(naguabo);

            ClRestaurant portalvell = new ClRestaurant("6","Portal Vell","Un lloc per sentir-se com a casa amb la millor cuina tradicional.","Catalana",R.drawable.portalvell);
            restList.add(portalvell);

            ClRestaurant vinyam = new ClRestaurant("7","Vinyam","Fusions al paladar per experimentar nous gustos.","GastroBar",R.drawable.vinyam);
            restList.add(vinyam);
        }

    }

    private void  setupList()
    {
        restListView = (ListView) findViewById(R.id.rest_listview);
        RestAdapter adapter = new RestAdapter(getApplicationContext(),0,restList);
        restListView.setAdapter(adapter);
    }

    private void  setupOnclickListener()
    {
        restListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ClRestaurant selectedRest = (ClRestaurant) (restListView.getItemAtPosition(position));
                Intent showDetailRest = new Intent(getApplicationContext(),RestDetails.class);
                showDetailRest.putExtra("id",selectedRest.getId());
                startActivity(showDetailRest);
            }
        });
    }

    private void filterList(String status)
    {
        selectedFilter = status;
        ArrayList<ClRestaurant> filteredStatus = new ArrayList<ClRestaurant>();

        for(ClRestaurant restaurant : restList)
        {
            if(restaurant.getType().toLowerCase().contains(status))
            {
                filteredStatus.add(restaurant);
            }
        }

        RestAdapter adapter = new RestAdapter(getApplicationContext(),0,filteredStatus);
        restListView.setAdapter(adapter);
    }
}