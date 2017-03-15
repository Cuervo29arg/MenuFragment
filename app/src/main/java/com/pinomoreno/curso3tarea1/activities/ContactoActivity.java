package com.pinomoreno.curso3tarea1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pinomoreno.curso3tarea1.R;
import com.pinomoreno.curso3tarea1.SendmailAsyncTask;
import com.pinomoreno.curso3tarea1.modelo.MensajeContactoVO;

public class ContactoActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etMail;
    EditText etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etMail = (EditText) findViewById(R.id.etMail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        Button enviarButton = (Button) findViewById(R.id.btnEnviar);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("enviando");
                MensajeContactoVO mensajeContacto = new MensajeContactoVO("Mail de contacto",
                        "De: "+etNombre.getText().toString()+"\n"+"mail: "+etMail.getText()+
                        "\n"+etMensaje.getText().toString(),"joseuber72@gmail.com",
                        etMail.getText().toString());
                new SendmailAsyncTask().execute(mensajeContacto);            }
        });
    }


}
