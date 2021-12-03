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
 * Use the {@link business_TheFragmentButigues#newInstance} factory method to
 * create an instance of this fragment.
 */
public class business_TheFragmentButigues extends Fragment implements View.OnClickListener{

    Button btnTru7, btnTru8, btnTru9;
    Button btnMap7, btnMap8, btnMap9;
    Button btnWeb7, btnWeb8, btnWeb9;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public business_TheFragmentButigues() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment business_TheFragmentButigues.
     */
    // TODO: Rename and change types and number of parameters
    public static business_TheFragmentButigues newInstance(String param1, String param2) {
        business_TheFragmentButigues fragment = new business_TheFragmentButigues();
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
        View v = inflater.inflate(R.layout.fragment_business__the_butigues, container, false);

        //region Botones de llamada.
        btnTru7 = (Button) v.findViewById(R.id.btn_telBusinessTaller_7);
        btnTru7.setOnClickListener(this);
        btnTru8 = (Button) v.findViewById(R.id.btn_telBusinessTaller_8);
        btnTru8.setOnClickListener(this);
        btnTru9 = (Button) v.findViewById(R.id.btn_telBusinessTaller_9);
        btnTru9.setOnClickListener(this);
        //endregion
        //region Botones de mapa
        btnMap7 = (Button) v.findViewById(R.id.btn_BusinessMap_7);
        btnMap7.setOnClickListener(this);
        btnMap8 = (Button) v.findViewById(R.id.btn_BusinessMap_8);
        btnMap8.setOnClickListener(this);
        btnMap9 = (Button) v.findViewById(R.id.btn_BusinessMap_9);
        btnMap9.setOnClickListener(this);
        //endregion
        //region Botones de la web
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

        // BOTIGUES
        if(btnTru7.getId()==id){
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