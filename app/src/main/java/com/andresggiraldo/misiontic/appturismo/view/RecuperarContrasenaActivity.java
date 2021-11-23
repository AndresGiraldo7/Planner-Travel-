package com.andresggiraldo.misiontic.appturismo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.andresggiraldo.misiontic.appturismo.R;
import com.bumptech.glide.Glide;

public class RecuperarContrasenaActivity extends AppCompatActivity {
    Button reg_registrarse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);
        ImageView background = findViewById(R.id.background);
        reg_registrarse=(Button)findViewById(R.id.reg_registrarse);
        reg_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( RecuperarContrasenaActivity.this, MensajeActivity.class);
                startActivity(i);
            }
        });
        Glide.with(this)
                .load(getImage("bakground"))
                .centerCrop()
                .into(background);
    }


    public int getImage(String imageName) {

        return this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());

    }



}

