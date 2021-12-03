package com.example.projectegrancentre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link business_MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class business_MainFragment extends Fragment implements View.OnClickListener {

    Button btnTru1, btnTru2, btnTru3, btnTru4, btnTru5, btnTru6, btnTru7, btnTru8, btnTru9;
    Button btnMap1, btnMap2, btnMap3, btnMap4, btnMap5, btnMap6, btnMap7, btnMap8, btnMap9;
    Button btnWeb1, btnWeb2, btnWeb3, btnWeb4, btnWeb5, btnWeb6, btnWeb7, btnWeb8, btnWeb9;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public business_MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment business_MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static business_MainFragment newInstance(String param1, String param2) {
        business_MainFragment fragment = new business_MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_business__main, container, false);

        //region Botones de llamada.
        btnTru1 = (Button) v.findViewById(R.id.btn_telBusinessTaller_1);
        btnTru1.setOnClickListener(this);
        btnTru2 = (Button) v.findViewById(R.id.btn_telBusinessTaller_2);
        btnTru2.setOnClickListener(this);
        btnTru3 = (Button) v.findViewById(R.id.btn_telBusinessTaller_3);
        btnTru3.setOnClickListener(this);
        btnTru4 = (Button) v.findViewById(R.id.btn_telBusinessTaller_4);
        btnTru4.setOnClickListener(this);
        btnTru5 = (Button) v.findViewById(R.id.btn_telBusinessTaller_5);
        btnTru5.setOnClickListener(this);
        btnTru6 = (Button) v.findViewById(R.id.btn_telBusinessTaller_6);
        btnTru6.setOnClickListener(this);
        btnTru7 = (Button) v.findViewById(R.id.btn_telBusinessTaller_7);
        btnTru7.setOnClickListener(this);
        btnTru8 = (Button) v.findViewById(R.id.btn_telBusinessTaller_8);
        btnTru8.setOnClickListener(this);
        btnTru9 = (Button) v.findViewById(R.id.btn_telBusinessTaller_9);
        btnTru9.setOnClickListener(this);
        //endregion
        //region Botones de mapa
        btnMap1 = (Button) v.findViewById(R.id.btn_BusinessMap_1);
        btnMap1.setOnClickListener(this);
        btnMap2 = (Button) v.findViewById(R.id.btn_BusinessMap_2);
        btnMap2.setOnClickListener(this);
        btnMap3 = (Button) v.findViewById(R.id.btn_BusinessMap_3);
        btnMap3.setOnClickListener(this);
        btnMap4 = (Button) v.findViewById(R.id.btn_BusinessMap_4);
        btnMap4.setOnClickListener(this);
        btnMap5 = (Button) v.findViewById(R.id.btn_BusinessMap_5);
        btnMap5.setOnClickListener(this);
        btnMap6 = (Button) v.findViewById(R.id.btn_BusinessMap_6);
        btnMap6.setOnClickListener(this);
        btnMap7 = (Button) v.findViewById(R.id.btn_BusinessMap_7);
        btnMap7.setOnClickListener(this);
        btnMap8 = (Button) v.findViewById(R.id.btn_BusinessMap_8);
        btnMap8.setOnClickListener(this);
        btnMap9 = (Button) v.findViewById(R.id.btn_BusinessMap_9);
        btnMap9.setOnClickListener(this);
        //endregion
        //region Botones de la web
        btnWeb1 = (Button) v.findViewById(R.id.btn_BusinessWeb_1);
        btnWeb1.setOnClickListener(this);
        btnWeb2 = (Button) v.findViewById(R.id.btn_BusinessWeb_2);
        btnWeb2.setOnClickListener(this);
        btnWeb3 = (Button) v.findViewById(R.id.btn_BusinessWeb_3);
        btnWeb3.setOnClickListener(this);
        btnWeb4 = (Button) v.findViewById(R.id.btn_BusinessWeb_4);
        btnWeb4.setOnClickListener(this);
        btnWeb5 = (Button) v.findViewById(R.id.btn_BusinessWeb_5);
        btnWeb5.setOnClickListener(this);
        btnWeb6 = (Button) v.findViewById(R.id.btn_BusinessWeb_6);
        btnWeb6.setOnClickListener(this);
        btnWeb7 = (Button) v.findViewById(R.id.btn_BusinessWeb_7);
        btnWeb7.setOnClickListener(this);
        btnWeb8 = (Button) v.findViewById(R.id.btn_BusinessWeb_8);
        btnWeb8.setOnClickListener(this);
        btnWeb9 = (Button) v.findViewById(R.id.btn_BusinessWeb_9);
        btnWeb9.setOnClickListener(this);
        //endregion

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // TALLERS
        if(id==btnTru1.getId()){
            callNumber();
        }else if(btnMap1.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb1.getId()==id){
            callWeb(Uri.parse("http://www.mototrack.es"));
        }else if(btnTru2.getId()==id){
            callNumber();
        }else if(btnMap2.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb2.getId()==id){
            callWeb(Uri.parse("https://robertsspaceindustries.com/"));
        }else if(btnTru3.getId()==id){
            callNumber();
        }else if(btnMap3.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb3.getId()==id){
            callWeb(Uri.parse("https://robertsspaceindustries.com/"));
        }else if(btnTru4.getId()==id){
            callNumber();

            // PERRUQUERIES
        }else if(btnMap4.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb4.getId()==id){
            callWeb(Uri.parse("https://aduho.com/"));
        }else if(btnTru5.getId()==id){
            callNumber();
        }else if(btnMap5.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb5.getId()==id){
            callWeb(Uri.parse("https://www.xavierarcarons.com/"));
        }else if(btnTru6.getId()==id){
            callNumber();
        }else if(btnMap6.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb6.getId()==id){
            callWeb(Uri.parse("https://brightyandco.com/"));

            // BOTIGUES
        }else if(btnTru7.getId()==id){
            callNumber();
        }else if(btnMap7.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb7.getId()==id){
            callWeb(Uri.parse("https://robertsspaceindustries.com/"));
        }else if(btnTru8.getId()==id){
            callNumber();
        }else if(btnMap8.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb8.getId()==id){
            callWeb(Uri.parse("https://robertsspaceindustries.com/"));
        }else if(btnTru9.getId()==id){
            callNumber();
        }else if(btnMap9.getId()==id){
            callMap(Uri.parse("google.streetview:cbll=41.609037,2.2885568"));
        }else if(btnWeb9.getId()==id){
            callWeb(Uri.parse("https://robertsspaceindustries.com/"));
        }
    }

    public void callNumber(){
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:+34665869374"));
        startActivity(callIntent);
    }

    public void callMap(Uri coordenadas){
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, coordenadas);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void callWeb(Uri direccionWeb){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, direccionWeb);
        startActivity(browserIntent);
    }
}