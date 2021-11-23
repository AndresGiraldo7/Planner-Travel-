package com.andresggiraldo.misiontic.appturismo.presenter;

import com.andresggiraldo.misiontic.appturismo.model.RegistroInteractor;
import com.andresggiraldo.misiontic.appturismo.mvp.RegistroMVP;


public class RegistroPresenter implements RegistroMVP.Presenter {

    private RegistroMVP.View view;
    private RegistroMVP.Model model;

    public RegistroPresenter(RegistroMVP.View view) {
        this.view = view;
        this.model = new RegistroInteractor();
    }

    @Override
    public void registrarse() {
        boolean error = false;

        RegistroMVP.RegistroInfo registroInfo = view.getRegistroInfo();
        if (registroInfo.getNombres().trim().isEmpty()) {
            view.showNombresError("Campo Obligatorio");
            error = true;
        } else if (!isNombreValid(registroInfo.getNombres().trim())) {
            view.showNombresError("Nombre debe contener minimo 3 caracteres");
            error = true;
        }


        if (registroInfo.getApellidos().trim().isEmpty()) {
            view.showApellidosError("Campo Obligatorio");
            error = true;
        } else if (!isApellidosValid(registroInfo.getApellidos().trim())) {
            view.showApellidosError("Apellido debe contener minimo 3 caracteres");
            error = true;
        }


        if (registroInfo.getEdad().trim().isEmpty()) {
            view.showEdadError("Campo Obligatorio");
            error = true;
        } else if (!isEdadValid(registroInfo.getEdad().trim())) {
            view.showEdadError("Edad minima es  18 años");
            error = true;
        }



        if (registroInfo.getCuidad().trim().isEmpty()) {
            view.showCuidadError("Campo Obligatorio");
            error = true;
        }else if (!isCuidadValid(registroInfo.getCuidad().trim())) {
                view.showCuidadError("Cuidad debe contener minimo 3 caracteres");
                error = true;
            }


        if (registroInfo.getEmail().trim().isEmpty()) {
            view.showEmailError("Campo Obligatorio");
            error = true;
        }else if (!isEmailValid(registroInfo.getEmail().trim())) {
            view.showEmailError("Contraseña no cumple criterios de seguridad");
            error = true;
        }

       if (registroInfo.getEmail().trim().isEmpty()) {
            view.showEmailError("Campo Obligatorio");
            error = true;
        }else if (!isContraseñaValid(registroInfo.getEmail().trim())) {
            view.showEmailError("Contraseña no cumple criterios de seguridad");
            error = true;
        }


        if (registroInfo.getContraseña().trim().isEmpty()) {
            view.showContraseñaError("Campo Obligatorio");
            error = true;
        }else if (!isContraseñaValid(registroInfo.getContraseña().trim())) {
            view.showContraseñaError("Contraseña no cumple criterios de seguridad");
            error = true;
        }


        if (registroInfo.getConfirmarContraseña().trim().isEmpty()) {
            view.showConfirmarContraseñaError("Campo Obligatorio");
            error = true;
        }else if (!isConfirmarContraseñaValid(registroInfo.getConfirmarContraseña().trim())) {
            view.showConfirmarContraseñaError("Contraseña no cumple criterios de seguridad");
            error = true;
        }

        if(!error){
            view.openHomeActivity();

        }else{
            view.showGeneralError("Verifique los datos");
        }
    }

    private boolean isNombreValid(String nombre) {
        return nombre.length() >= 3;
    }

    private boolean isApellidosValid(String apellidos) {
        return apellidos.length() >= 3;
    }

    private boolean isEdadValid(String edad) {
        int numEntero = Integer.parseInt(edad);
        return numEntero >= 15;
    }

    private boolean isCuidadValid(String cuidad) {
        return cuidad.length() >= 3;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@")
                && email.endsWith(".com");
    }

    private boolean isContraseñaValid(String contraseña) {
        return contraseña.length() >= 8;
    }


    private boolean isConfirmarContraseñaValid(String confirmarContraseña) {
        return confirmarContraseña.length() >= 8;
    }
}

