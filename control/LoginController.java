package control;

import Modelo.Usuario;
import database.UserDatabase;

public class LoginController {

    public boolean validacionDatos(String nombre, String password) {
        Usuario usuario = UserDatabase.getUsuario(nombre, password);
        return usuario != null;
    }
}
