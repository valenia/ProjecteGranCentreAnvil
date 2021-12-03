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
 * Use the {@link business_TheFragmentTallers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class business_TheFragmentTallers extends Fragment implements View.OnClickListener {

    Button btnTru1, btnTru2, btnTru3;
    Button btnMap1, btnMap2, btnMap3;
    Button btnWeb1, btnWeb2, btnWeb3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public business_TheFragmentTallers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment business_TheFragmentTallers.
     */
    // TODO: Rename and change types and number of parameters
    public static business_TheFragmentTallers newInstance(String param1, String param2) {
        business_TheFragmentTallers fragment = new business_TheFragmentTallers();
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
        View v = inflater.inflate(R.layout.fragment_business__the_tallers, container, false);

        //region Botones de llamada.
        btnTru1 = (Button) v.findViewById(R.id.btn_telBusinessTaller_1);
        btnTru1.setOnClickListener(this);
        btnTru2 = (Button) v.findViewById(R.id.btn_telBusinessTaller_2);
        btnTru2.setOnClickListener(this);
        btnTru3 = (Button) v.findViewById(R.id.btn_telBusinessTaller_3);
        btnTru3.setOnClickListener(this);
        //endregion
        //region Botones de mapa
        btnMap1 = (Button) v.findViewById(R.id.btn_BusinessMap_1);
        btnMap1.setOnClickListener(this);
        btnMap2 = (Button) v.findViewById(R.id.btn_BusinessMap_2);
        btnMap2.setOnClickListener(this);
        btnMap3 = (Button) v.findViewById(R.id.btn_BusinessMap_3);
        btnMap3.setOnClickListener(this);
        //endregion
        //region Botones de la web
        btnWeb1 = (Button) v.findViewById(R.id.btn_BusinessWeb_1);
        btnWeb1.setOnClickListener(this);
        btnWeb2 = (Button) v.findViewById(R.id.btn_BusinessWeb_2);
        btnWeb2.setOnClickListener(this);
        btnWeb3 = (Button) v.findViewById(R.id.btn_BusinessWeb_3);
        btnWeb3.setOnClickListener(this);
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