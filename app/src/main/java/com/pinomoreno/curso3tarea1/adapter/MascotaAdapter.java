package com.pinomoreno.curso3tarea1.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinomoreno.curso3tarea1.R;
import com.pinomoreno.curso3tarea1.modelo.MascotaVO;

import java.util.ArrayList;

/**
 * Created by mshel on 13/02/2017.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    private ArrayList<MascotaVO> mascotaVOs;
    private ArrayList<MascotaVO> mascotasFavoritas = new ArrayList<MascotaVO>();

    public MascotaAdapter(ArrayList<MascotaVO> mascotaVOs){
        this.mascotaVOs = mascotaVOs;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final MascotaVO mascotaVO = mascotaVOs.get(position);
        holder.imgFoto.setImageResource(mascotaVO.getFoto());
        holder.tvNombreMascotaCV.setText(mascotaVO.getNombreMascota());
        holder.tvRaitingCV.setText(String.valueOf(mascotaVO.getRaiting()));
        holder.imgBone.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               actualizarRaiting(mascotaVO,holder);
            }
        });
    }

    public void actualizarRaiting(MascotaVO mascotaVO, MascotaViewHolder holder){
        boolean noEncontrado = true;
        int raiting = mascotaVO.getRaiting() + 1;
        mascotaVO.setRaiting(raiting);
        holder.tvRaitingCV.setText(String.valueOf(mascotaVO.getRaiting()));
        if(mascotasFavoritas.size()==0){
            mascotasFavoritas.add(mascotaVO);
        }else {
            for (MascotaVO mascta : mascotasFavoritas) {
                if (mascta.getNombreMascota().compareTo(mascotaVO.getNombreMascota()) == 0) {
                    noEncontrado = false;
                }
            }
            if(noEncontrado){
                mascotasFavoritas.add(mascotaVO);
            }
        }


    }

    public ArrayList<MascotaVO> getMascotasFavoritas() {
        return mascotasFavoritas;
    }

    @Override
    public int getItemCount() {
        return mascotaVOs.size();
    }

    public static class MascotaViewHolder extends ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreMascotaCV;
        private TextView tvRaitingCV;
        private ImageView imgBone;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto             = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreMascotaCV   = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvRaitingCV         = (TextView) itemView.findViewById(R.id.tvRaiting);
            imgBone             = (ImageView) itemView.findViewById(R.id.ivBone);

        }
    }
}
