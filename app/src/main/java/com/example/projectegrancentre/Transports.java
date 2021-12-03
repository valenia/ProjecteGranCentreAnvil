package com.example.projectegrancentre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Transports extends AppCompatActivity implements View.OnClickListener {

    Button bus,tren,taxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transports);

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
        switch (idRebuda)
        {
            case R.id.busFilter:
                {
                    FragmentManager fm = getSupportFragmentManager();
                    bus busfrg = new bus();
                    fm.beginTransaction().replace(R.id.scrollTransports,busfrg).commit();
                    break;
                }
            case R.id.trenFilter:
            {
                FragmentManager fm = getSupportFragmentManager();
                tren trenfrg = new tren();
                fm.beginTransaction().replace(R.id.scrollTransports,trenfrg).commit();
                break;
            }
            case R.id.taxiFilter:
            {
                FragmentManager fm = getSupportFragmentManager();
                taxi taxifrg = new taxi();
                fm.beginTransaction().replace(R.id.scrollTransports,taxifrg).commit();
                break;
            }
        }

    }
}