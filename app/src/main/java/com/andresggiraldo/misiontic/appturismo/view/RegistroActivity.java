package com.andresggiraldo.misiontic.appturismo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.andresggiraldo.misiontic.appturismo.R;
import com.andresggiraldo.misiontic.appturismo.mvp.RegistroMVP;
import com.andresggiraldo.misiontic.appturismo.presenter.RegistroPresenter;
import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity  implements RegistroMVP.View{

    private TextInputEditText reg_nombre;
    private TextInputEditText reg_apellido;
    private TextInputEditText reg_edad;
    private TextInputEditText reg_cuidad;
    private TextInputEditText reg_email;
    private TextInputEditText reg_password;
    private TextInputEditText reg_confirmar;


    private AppCompatButton reg_registrarse;


    private RegistroMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        presenter = new RegistroPresenter(this);

        ImageView background = findViewById(R.id.background);


        Glide.with(this)
                .load(getImage("bakground"))
                .centerCrop()
                .into(background);

        presenter=new RegistroPresenter(this);
        initUI();




}


    public int getImage(String imageName) {

        int drawableResourceId = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());

        return drawableResourceId;

    }

    private void initUI() {
        reg_nombre=findViewById(R.id.reg_nombre);
        reg_apellido=findViewById(R.id.reg_apellido);
        reg_edad=findViewById(R.id.reg_edad);
        reg_cuidad=findViewById(R.id.reg_ciudad);
        reg_email=findViewById(R.id.reg_email);
        reg_password=findViewById(R.id.reg_password);
        reg_confirmar=findViewById(R.id.reg_confirmar);
        reg_registrarse = findViewById(R.id.reg_registrarse);
        reg_registrarse.setOnClickListener(evt -> presenter.registrarse());

    }


    @Override
    public RegistroMVP.RegistroInfo getRegistroInfo() {

        return new RegistroMVP.RegistroInfo(reg_nombre.getText().toString(),
                reg_apellido.getText().toString(),
                reg_edad.getText().toString(),
                reg_cuidad.getText().toString(),
                reg_email.getText().toString(),
                reg_confirmar.getText().toString(),
                reg_password.getText().toString());
    }

    @Override
    public void showNombresError(String error) {reg_nombre.setError(error);}

    @Override
    public void showApellidosError(String error) {
            reg_apellido.setError(error);
    }

    @Override
    public void showEdadError(String error) { reg_edad.setError(error);}

    @Override
    public void showCuidadError(String error) {
        reg_cuidad.setError(error);
    }

    @Override
    public void showEmailError(String error) {
        reg_email.setError(error);
    }

    @Override
    public void showContraseñaError(String error) { reg_password.setError(error); }

    @Override
    public void showConfirmarContraseñaError(String error) { reg_confirmar.setError(error); }

    @Override
    public void showGeneralError(String error) {
        Toast.makeText(RegistroActivity.this, error, Toast.LENGTH_SHORT).show();}

    @Override
    public void clearData() {
        reg_nombre.setError("");
        reg_nombre.setText("");
        reg_apellido.setError("");
        reg_apellido.setText("");
        reg_edad.setError("");
        reg_edad.setText("");
        reg_cuidad.setError("");
        reg_cuidad.setText("");
        reg_email.setError("");
        reg_email.setText("");
        reg_password.setError("");
        reg_password.setText("");
        reg_confirmar.setText("");
        reg_confirmar.setText("");
    }



    @Override
    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
}