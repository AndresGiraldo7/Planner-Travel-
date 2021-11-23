package com.andresggiraldo.misiontic.appturismo.model;

import com.andresggiraldo.misiontic.appturismo.mvp.LoginMVP;

import java.util.HashMap;
import java.util.Map;

public class LoginInteractor implements LoginMVP.Model {

    private Map<String, String> users;

    public LoginInteractor(){
        users = new HashMap<>();
        users.put("ag@email.com", "12345678");
        users.put("test@email.com", "87654321");
    }



    @Override
    public void validateCredentials(String email, String password, ValidateCredentialsCallback callback) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(users.get(email) == null) {
            callback.onFailure("Usuario no existe");
        } else if (!users.get(email).equals(password)){
            callback.onFailure("Contraseña incorrecta");
        } else {
            callback.onSuccess();
        }
    }
}