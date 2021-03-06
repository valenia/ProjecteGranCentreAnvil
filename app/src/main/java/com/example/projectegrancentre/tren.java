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
 * Use the {@link tren#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tren extends Fragment implements View.OnClickListener {

    ImageView estacio1,estacio2,estacio3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tren() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tren.
     */
    // TODO: Rename and change types and number of parameters
    public static tren newInstance(String param1, String param2) {
        tren fragment = new tren();
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
        View v = inflater.inflate(R.layout.fragment_tren, container, false);

        //Gestionem buttons de link amb horaris
        estacio1 = (ImageView) v.findViewById(R.id.granollerscentre);
        estacio1.setOnClickListener(this);
        estacio2 = (ImageView) v.findViewById(R.id.granollerscanovelles);
        estacio2.setOnClickListener(this);
        estacio3 = (ImageView) v.findViewById(R.id.granollersfranqueses);
        estacio3.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id)
        {
            case R.id.granollerscentre:
                {
                    Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.59988259571443,2.291439091750679?q=Granollers Centre"));
                    startActivity(intentMap);
                }
            case R.id.granollerscanovelles:
            {
                Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.61157862424343,2.276929077861297?q=Granollers-Canovelles"));
                startActivity(intentMap);
            }
            case R.id.granollersfranqueses:
            {
                Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.61724730538478,2.294388486306655?q=Les Franqueses-Granollers Nord"));
                startActivity(intentMap);
            }
        }
    }
}