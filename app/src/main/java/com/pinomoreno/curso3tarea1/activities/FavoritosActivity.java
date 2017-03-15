package com.pinomoreno.curso3tarea1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.pinomoreno.curso3tarea1.adapter.MascotaAdapter;
import com.pinomoreno.curso3tarea1.R;
import com.pinomoreno.curso3tarea1.modelo.FavoritosTO;
import com.pinomoreno.curso3tarea1.modelo.MascotaVO;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView rvMascotas;
    private ArrayList<MascotaVO> mascotasFavoritas;
    private MascotaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle param = getIntent().getExtras();
        FavoritosTO favoritosTO = (FavoritosTO) param.get("mascotas");
        mascotasFavoritas = favoritosTO.getMascotasFavoritas();

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarAdapter();
    }

    public void inicializarAdapter(){
        adapter = new MascotaAdapter(mascotasFavoritas);
        rvMascotas.setAdapter(adapter);
    }
}
