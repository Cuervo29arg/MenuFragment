package com.pinomoreno.curso3tarea1.modelo;

/**
 * Created by mshel on 19/02/2017.
 */

public class MensajeContactoVO {
    private String asunto;
    private String mensaje;
    private String mailEnvio;
    private String mailReceptor;

    public MensajeContactoVO(String asunto, String mensaje, String mailEnvio, String mailReceptor){
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.mailEnvio = mailEnvio;
        this.mailReceptor = mailReceptor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMailEnvio() {
        return mailEnvio;
    }

    public void setMailEnvio(String mailEnvio) {
        this.mailEnvio = mailEnvio;
    }

    public String getMailReceptor() {
        return mailReceptor;
    }

    public void setMailReceptor(String mailReceptor) {
        this.mailReceptor = mailReceptor;
    }
}
