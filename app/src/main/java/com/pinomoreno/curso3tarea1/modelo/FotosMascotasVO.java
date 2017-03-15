package com.pinomoreno.curso3tarea1.modelo;

/**
 * Created by mshel on 20/02/2017.
 */

public class FotosMascotasVO {

    private int foto;
    private int raiting;

    public FotosMascotasVO(int foto, int raiting){
        this.foto = foto;
        this.raiting = raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}
