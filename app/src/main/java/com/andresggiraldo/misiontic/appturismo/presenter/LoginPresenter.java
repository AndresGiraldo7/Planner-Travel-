package com.andresggiraldo.misiontic.appturismo.presenter;

import com.andresggiraldo.misiontic.appturismo.model.LoginInteractor;
import com.andresggiraldo.misiontic.appturismo.mvp.LoginMVP;

public class LoginPresenter implements LoginMVP.Presenter {

    private LoginMVP.View view;
    private LoginMVP.Model model;

    public LoginPresenter(LoginMVP.View view) {
        this.view = view;
        this.model = new LoginInteractor();
    }

    @Override
    public void loginWithEmail() {
        boolean error = false;

        view.showEmailError("");
        view.showPasswordError("");

        LoginMVP.LoginInfo loginInfo = view.getLoginInfo();
        // Validate filds
        if (loginInfo.getEmail().trim().isEmpty()) {
            view.showEmailError("Correo electrónico es obligatorio");
            error = true;
        } else if (!isEmailValid(loginInfo.getEmail().trim())) {
            view.showEmailError("Correo electrónico no es válido");
            error = true;
        }

        if (loginInfo.getPassword().trim().isEmpty()) {
            view.showPasswordError("Contraseña es obligatoria");
            error = true;
        } else if (!isPasswordValid(loginInfo.getPassword().trim())) {
            view.showPasswordError("Contraseña no cumple criterios de seguridad");
            error = true;
        }

        if (!error) {
            view.startWaiting();
            // validar que el usuario/contraseña sean correctos
            new Thread(() -> {
                model.validateCredentials(loginInfo.getEmail().trim(),
                        loginInfo.getPassword().trim(),
                        new LoginMVP.Model.ValidateCredentialsCallback() {
                            @Override
                            public void onSuccess() {
                                view.getActivity().runOnUiThread(() -> {
                                    view.stopWaiting();
                                    view.openHomeActivity();
                                });
                            }

                            @Override
                            public void onFailure(String error) {
                                view.getActivity().runOnUiThread(() -> {
                                    view.stopWaiting();
                                    view.showGeneralError(error);
                                });
                            }
                        });
            }).start();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@")
                && email.endsWith(".com");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    @Override
    public void loginWithFacebook() {

    }

    @Override
    public void loginWithGoogle() {

    }
}
