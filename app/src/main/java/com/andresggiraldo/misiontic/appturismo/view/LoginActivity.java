package com.andresggiraldo.misiontic.appturismo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.andresggiraldo.misiontic.appturismo.R;
import com.andresggiraldo.misiontic.appturismo.mvp.LoginMVP;
import com.andresggiraldo.misiontic.appturismo.presenter.LoginPresenter;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {


    private LinearProgressIndicator piWaiting;
    private ImageView ivLogo;
    private TextInputLayout tilEmail;
    private TextInputEditText etEmail;
    private TextInputLayout tilPassword;
    private TextInputEditText etPassword;


    private AppCompatButton btnLogin;
    private AppCompatButton btnFacebook;
    private AppCompatButton btnGoogle;
    private AppCompatButton btnRecuperar;
    private AppCompatButton btnRegistro;

    private LoginMVP.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setTheme(R.style.Theme_AppTurismo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);
        initUI();

    }

    private void initUI() {
        piWaiting = findViewById(R.id.pi_waiting);
        ivLogo = findViewById(R.id.iv_logo);

        tilEmail = findViewById(R.id.til_Email);
        etEmail = findViewById(R.id.et_Email);

        tilPassword = findViewById(R.id.til_password);
        etPassword=findViewById(R.id.et_password);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener((evt)-> presenter.loginWithEmail());

        btnFacebook =findViewById(R.id.btn_facebook);
        btnFacebook.setOnClickListener((evt)-> presenter.loginWithFacebook());

        btnGoogle = findViewById(R.id.btn_google);
        btnGoogle.setOnClickListener((evt)-> presenter.loginWithGoogle());

        btnRegistro = findViewById(R.id.btn_registro);
        btnRegistro.setOnClickListener((evt)->{ onRegistroClick();});

        btnRecuperar = findViewById(R.id.btn_recuperar);
        btnRecuperar.setOnClickListener((evt)->{ onRecuperarClick();});

    }

    private void onRegistroClick() {
        Intent intent =new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    private void onRecuperarClick(){
        Intent intent =new Intent(this, RecuperarContrasenaActivity.class);
        startActivity(intent);

    }

    @Override
    public Activity getActivity() {return this; }

    @Override
    public LoginMVP.LoginInfo getLoginInfo() {
        return new LoginMVP.LoginInfo(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showEmailError(String error) {
        tilEmail.setError(error);
    }

    @Override
    public void showPasswordError(String error) {
        tilPassword.setError(error);
    }

    @Override
    public void showGeneralError(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }




    @Override
    public void clearData() {
        tilEmail.setError("");
        etEmail.setText("");
        tilPassword.setError("");
        etPassword.setText("");
    }

    @Override
    public void openHomeActivity() {
        Intent intent = new Intent( this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void startWaiting() {
        piWaiting.setVisibility(View.VISIBLE);
        btnLogin.setEnabled(false);
        btnFacebook.setEnabled(false);
        btnGoogle.setEnabled(false);
    }

    @Override
    public void stopWaiting() {
        piWaiting.setVisibility(View.GONE);
        btnLogin.setEnabled(true);
        btnFacebook.setEnabled(true);
        btnGoogle.setEnabled(true);
    }
}