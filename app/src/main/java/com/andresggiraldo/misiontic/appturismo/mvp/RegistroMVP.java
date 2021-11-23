package com.andresggiraldo.misiontic.appturismo.mvp;

public interface RegistroMVP {

    interface Model{}

    interface Presenter {
        void registrarse();

    }

    interface View{
        RegistroInfo getRegistroInfo();
        void showNombresError(String error);
        void showApellidosError(String error);
        void showEdadError(String error);
        void showCuidadError(String error);
        void showEmailError(String error);
        void showContraseñaError(String error);
        void showConfirmarContraseñaError(String error);
        void showGeneralError(String error);


        void clearData();

        void openHomeActivity();

    }

    class RegistroInfo{
        private final String nombres;
        private String apellidos;
        private String edad;
        private String cuidad;
        private String email;
        private String contraseña;
        private String confirmarContraseña;

        public RegistroInfo(String nombres, String apellidos, String edad, String cuidad, String email, String contraseña, String confirmarContraseña) {
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.edad = edad;
            this.cuidad = cuidad;
            this.email = email;
            this.contraseña = contraseña;
            this.confirmarContraseña = confirmarContraseña;
        }

        public String getNombres() {
            return nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getEdad() {
            return edad;
        }

        public String getCuidad() {
            return cuidad;
        }

        public String getEmail() {
            return email;
        }

        public String getContraseña() {
            return contraseña;
        }

        public String getConfirmarContraseña() {
            return confirmarContraseña;
        }
    }

}
