package com.pinomoreno.curso3tarea1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinomoreno.curso3tarea1.R;
import com.pinomoreno.curso3tarea1.modelo.FotosMascotasVO;
import com.pinomoreno.curso3tarea1.modelo.MascotaVO;

import java.util.ArrayList;

/**
 * Created by mshel on 20/02/2017.
 */

public class FotosMascotasAdapter extends RecyclerView.Adapter<FotosMascotasAdapter.FotosMascotasViewHolder>{

    private ArrayList<FotosMascotasVO> fotosMascotas;

    public FotosMascotasAdapter(ArrayList<FotosMascotasVO> fotosMascotas){
        this.fotosMascotas = fotosMascotas;
    }

    @Override
    public FotosMascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotosmascota,parent,false);
        return new FotosMascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotosMascotasViewHolder holder, int position) {
        final FotosMascotasVO fotoMascota = fotosMascotas.get(position);
        holder.imgFotoMascota.setImageResource(fotoMascota.getFoto());
        holder.tvRaitingFotos.setText(String.valueOf(fotoMascota.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return fotosMascotas.size();
    }

    public class FotosMascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoMascota;
        private TextView tvRaitingFotos;

        public FotosMascotasViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.ivFotoMascota);
            tvRaitingFotos = (TextView) itemView.findViewById(R.id.tvRaitingFotos);
        }
    }
}
