package com.pinomoreno.curso3tarea1.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinomoreno.curso3tarea1.R;
import com.pinomoreno.curso3tarea1.adapter.FotosMascotasAdapter;
import com.pinomoreno.curso3tarea1.modelo.FotosMascotasVO;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragment extends Fragment {


    private ArrayList<FotosMascotasVO> fotosMascotas;
    private FotosMascotasAdapter adapter;
    private RecyclerView rvFotosMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);
        rvFotosMascotas = (RecyclerView) v.findViewById(R.id.rvFotosMascotas);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        rvFotosMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdapter();

        return v;
    }

    public void inicializarListaMascotas(){
        fotosMascotas = new ArrayList<FotosMascotasVO>();
        FotosMascotasVO foto1 = new FotosMascotasVO(R.drawable.malinois1,5);
        FotosMascotasVO foto2 = new FotosMascotasVO(R.drawable.malinois2,10);
        FotosMascotasVO foto3 = new FotosMascotasVO(R.drawable.malinois3,2);
        FotosMascotasVO foto4 = new FotosMascotasVO(R.drawable.malinois4,20);
        FotosMascotasVO foto5 = new FotosMascotasVO(R.drawable.malinois5,3);
        FotosMascotasVO foto6 = new FotosMascotasVO(R.drawable.malinois6,50);

        fotosMascotas.add(foto1);
        fotosMascotas.add(foto2);
        fotosMascotas.add(foto3);
        fotosMascotas.add(foto4);
        fotosMascotas.add(foto5);
        fotosMascotas.add(foto6);
    }

    public void inicializarAdapter(){
        adapter = new FotosMascotasAdapter(fotosMascotas);
        rvFotosMascotas.setAdapter(adapter);
    }

}
