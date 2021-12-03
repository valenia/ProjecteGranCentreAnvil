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
 * Use the {@link hotels4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotels4 extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hotels4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hotels4.
     */
    // TODO: Rename and change types and number of parameters
    public static hotels4 newInstance(String param1, String param2) {
        hotels4 fragment = new hotels4();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hotels4, container, false);
        Button tlf0,web0,tlf1,web1,tlf2,web2;
        tlf0=v.findViewById(R.id.tlf0);
        tlf0.setOnClickListener(this);
        web0=v.findViewById(R.id.web0);
        web0.setOnClickListener(this);
        tlf1=v.findViewById(R.id.tlf1);
        tlf1.setOnClickListener(this);
        web1=v.findViewById(R.id.web1);
        web1.setOnClickListener(this);
        tlf2=v.findViewById(R.id.tlf2);
        tlf2.setOnClickListener(this);
        web2=v.findViewById(R.id.web2);
        web2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        int idRebuda = view.getId();
        String tlf[]=getResources().getStringArray(R.array.tlf4estrelles);
        String web[]=getResources().getStringArray(R.array.web4estrelles);

        switch(idRebuda){
            case R.id.tlf0:{
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tlf[0]));
                startActivity(intent);
                break;
            }
            case R.id.web0:{
                Uri uri = Uri.parse(web[0]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            }
            case R.id.tlf1:{
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tlf[1]));
                startActivity(intent);
                break;
            }
            case R.id.web1:{
                Uri uri = Uri.parse(web[1]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            }
            case R.id.tlf2:{
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+tlf[2]));
                startActivity(intent);
                break;
            }
            case R.id.web2:{
                Uri uri = Uri.parse(web[2]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            }

        }
    }
}