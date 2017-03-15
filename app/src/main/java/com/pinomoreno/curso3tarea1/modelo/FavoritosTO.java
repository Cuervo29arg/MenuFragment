package com.pinomoreno.curso3tarea1.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by mshel on 14/02/2017.
 */

public class FavoritosTO implements Parcelable {

    private ArrayList<MascotaVO> mascotasFavoritas;

    public FavoritosTO(ArrayList<MascotaVO> mascotasFavoritas){
        this.mascotasFavoritas = mascotasFavoritas;
    }

    public ArrayList<MascotaVO> getMascotasFavoritas() {
        return mascotasFavoritas;
    }

    public void setMascotasFavoritas(ArrayList<MascotaVO> mascotasFavoritas) {
        this.mascotasFavoritas = mascotasFavoritas;
    }

    protected FavoritosTO(Parcel in) {
        if (in.readByte() == 0x01) {
            mascotasFavoritas = new ArrayList<MascotaVO>();
            in.readList(mascotasFavoritas, MascotaVO.class.getClassLoader());
        } else {
            mascotasFavoritas = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mascotasFavoritas == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mascotasFavoritas);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FavoritosTO> CREATOR = new Parcelable.Creator<FavoritosTO>() {
        @Override
        public FavoritosTO createFromParcel(Parcel in) {
            return new FavoritosTO(in);
        }

        @Override
        public FavoritosTO[] newArray(int size) {
            return new FavoritosTO[size];
        }
    };
}