package com.example.projectegrancentre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link taxi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class taxi extends Fragment implements View.OnClickListener {

    ImageView taxi1,taxi2,taxi3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public taxi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment taxi.
     */
    // TODO: Rename and change types and number of parameters
    public static taxi newInstance(String param1, String param2) {
        taxi fragment = new taxi();
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
        View v = inflater.inflate(R.layout.fragment_taxi, container, false);

        //Gestionem els buttons per les trucades
        taxi1 = (ImageView) v.findViewById(R.id.taxigranollers);
        taxi1.setOnClickListener(this);
        taxi2 = (ImageView) v.findViewById(R.id.taxipepe);
        taxi2.setOnClickListener(this);
        taxi3 = (ImageView) v.findViewById(R.id.heretaxi);
        taxi3.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id)
        {
            case R.id.taxigranollers:
                {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
                    startActivity(intentCall);
                }
            case R.id.taxipepe:
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
                startActivity(intentCall);
            }
            case R.id.heretaxi:
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
                startActivity(intentCall);
            }
        }
    }
}