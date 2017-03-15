package com.pinomoreno.curso3tarea1;

import android.os.AsyncTask;

import com.pinomoreno.curso3tarea1.modelo.MensajeContactoVO;


/**
 * Created by mshel on 16/02/2017.
 */

public class SendmailAsyncTask extends AsyncTask<MensajeContactoVO,Void,Boolean>{

    @Override
    protected Boolean doInBackground(MensajeContactoVO... mensajeContacto) {
        GMailSender sender = new GMailSender("joseuber72","joseUber1");
        try {
            sender.sendMail(mensajeContacto[0].getAsunto(),mensajeContacto[0].getMensaje(),
                    mensajeContacto[0].getMailEnvio(),mensajeContacto[0].getMailReceptor());
            System.out.print("enviado");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
