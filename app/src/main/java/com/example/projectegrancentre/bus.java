package com.example.projectegrancentre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bus extends Fragment implements View.OnClickListener {

    ImageView bus1,bus2,bus3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bus.
     */
    // TODO: Rename and change types and number of parameters
    public static bus newInstance(String param1, String param2) {
        bus fragment = new bus();
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
        View v = inflater.inflate(R.layout.fragment_bus, container, false);

        //Gestionem buttons de link amb horaris
        bus1 = (ImageView) v.findViewById(R.id.bus1);
        bus1.setOnClickListener(this);
        bus2 = (ImageView) v.findViewById(R.id.bus2);
        bus2.setOnClickListener(this);
        bus3 = (ImageView) v.findViewById(R.id.bus3);
        bus3.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        //Nom??s s'han marcat els link per les tres primeres l??nies
        //Anava a fer el link amb els horaris de la web de busos, per?? donen problemes per obrir-los directament

        switch (id)
        {
            case R.id.bus1:
                {
                    Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.transgran.cat/linies"));
                    startActivity(intentWeb);
                }
            case R.id.bus2:
                {
                    Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.transgran.cat/linies"));
                    startActivity(intentWeb);
                }
            case R.id.bus3:
            {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.transgran.cat/linies"));
                startActivity(intentWeb);
            }
        }

    }
}