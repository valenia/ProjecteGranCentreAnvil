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
 * Use the {@link business_TheFragmentPerruqueries#newInstance} factory method to
 * create an instance of this fragment.
 */
public class business_TheFragmentPerruqueries extends Fragment implements View.OnClickListener{

    Button btnTru4, btnTru5, btnTru6;
    Button btnMap4, btnMap5, btnMap6;
    Button btnWeb4, btnWeb5, btnWeb6;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public business_TheFragmentPerruqueries() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment business_TheFragmentPerruqueries.
     */
    // TODO: Rename and change types and number of parameters
    public static business_TheFragmentPerruqueries newInstance(String param1, String param2) {
        business_TheFragmentPerruqueries fragment = new business_TheFragmentPerruqueries();
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
        View v = inflater.inflate(R.layout.fragment_business__the_perruqueries, container, false);

        //region Botones de llamada.
        btnTru4 = (Button) v.findViewById(R.id.btn_telBusinessTaller_4);
        btnTru4.setOnClickListener(this);
        btnTru5 = (Button) v.findViewById(R.id.btn_telBusinessTaller_5);
        btnTru5.setOnClickListener(this);
        btnTru6 = (Button) v.findViewById(R.id.btn_telBusinessTaller_6);
        btnTru6.setOnClickListener(this);
        //endregion
        //region Botones de mapa
        btnMap4 = (Button) v.findViewById(R.id.btn_BusinessMap_4);
        btnMap4.setOnClickListener(this);
        btnMap5 = (Button) v.findViewById(R.id.btn_BusinessMap_5);
        btnMap5.setOnClickListener(this);
        btnMap6 = (Button) v.findViewById(R.id.btn_BusinessMap_6);
        btnMap6.setOnClickListener(this);
        //endregion
        //region Botones de la web
        btnWeb4 = (Button) v.findViewById(R.id.btn_BusinessWeb_4);
        btnWeb4.setOnClickListener(this);
        btnWeb5 = (Button) v.findViewById(R.id.btn_BusinessWeb_5);
        btnWeb5.setOnClickListener(this);
        btnWeb6 = (Button) v.findViewById(R.id.btn_BusinessWeb_6);
        btnWeb6.setOnClickListener(this);
        //endregion

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // PERRUQUERIES
        if(id==btnTru4.getId()){
            callNumber();
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