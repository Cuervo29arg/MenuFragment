package com.pinomoreno.curso3tarea1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.pinomoreno.curso3tarea1.R;
import com.pinomoreno.curso3tarea1.adapter.MascotaAdapter;
import com.pinomoreno.curso3tarea1.modelo.FavoritosTO;
import com.pinomoreno.curso3tarea1.modelo.MascotaVO;

import java.util.ArrayList;

/**
 * Created by mshel on 19/02/2017.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<MascotaVO> mascotaVOs;
    private MascotaAdapter adapter;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdapter();

        ImageView starImage = (ImageView) getActivity().findViewById(R.id.ivStar);
        starImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mostrarFavoritos();
            }
        });

        return v;
    }


    public void inicializarAdapter(){
        adapter = new MascotaAdapter(mascotaVOs);
        listaMascotas.setAdapter(adapter);
    }

    public void mostrarFavoritos(){
        ArrayList<MascotaVO> mascotasFavoritas = adapter.getMascotasFavoritas();
        if(mascotasFavoritas.size()>0) {
            Intent intent = new Intent(getActivity(), FavoritosActivity.class);
            FavoritosTO favoritosTO = new FavoritosTO(mascotasFavoritas);
            intent.putExtra("mascotas", favoritosTO);
            startActivity(intent);
        }else{
            Toast.makeText(getActivity(),"Necesita rankear alguna mascota por lo menos",Toast.LENGTH_LONG).show();
        }
    }

    public void inicializarListaMascotas(){
        mascotaVOs = new ArrayList<MascotaVO>();
        mascotaVOs.add(new MascotaVO("Pluto",5,R.drawable.perro_pastor_belga_malinois));
        mascotaVOs.add(new MascotaVO("Bolt",1,R.drawable.salchicha_negro));
        mascotaVOs.add(new MascotaVO("Bethoven",3,R.drawable.perros_san_bernardo_opt_compressor_1));
        mascotaVOs.add(new MascotaVO("Rin tin tin",4,R.drawable.weimaraner_perro));
        mascotaVOs.add(new MascotaVO("Einstein",10,R.drawable.shar_pei_opt_1));
    }
}
