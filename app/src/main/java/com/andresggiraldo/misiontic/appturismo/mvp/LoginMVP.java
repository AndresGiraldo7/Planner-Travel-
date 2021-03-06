package com.andresggiraldo.misiontic.appturismo.mvp;

import android.app.Activity;

public interface LoginMVP {

    interface Model{
        void validateCredentials(String email, String password, ValidateCredentialsCallback callback);

        interface ValidateCredentialsCallback {
            void onSuccess();

            void onFailure(String error);
        }
    }

    interface Presenter{
        void loginWithEmail();

        void loginWithFacebook();

        void loginWithGoogle();

    }

    interface View {
        Activity getActivity();

        LoginInfo getLoginInfo();

        void showEmailError(String error);

        void showPasswordError(String error);

        void showGeneralError(String error);


        void clearData();

        void openHomeActivity();

        void startWaiting();

        void stopWaiting();
    }

    class LoginInfo {
        private String email;
        private String password;

        public LoginInfo(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
