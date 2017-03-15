package com.pinomoreno.curso3tarea1.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class MascotaVO implements Parcelable {

    private String nombreMascota;
    private int raiting;
    private int foto;

    public MascotaVO(String nombreMascota, int raiting, int foto){
        this.nombreMascota = nombreMascota;
        this.raiting = raiting;
        this.foto = foto;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    protected MascotaVO(Parcel in) {
        nombreMascota = in.readString();
        raiting = in.readInt();
        foto = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombreMascota);
        dest.writeInt(raiting);
        dest.writeInt(foto);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MascotaVO> CREATOR = new Parcelable.Creator<MascotaVO>() {
        @Override
        public MascotaVO createFromParcel(Parcel in) {
            return new MascotaVO(in);
        }

        @Override
        public MascotaVO[] newArray(int size) {
            return new MascotaVO[size];
        }
    };
}