package control;

import Modelo.Usuario;
import database.UserDatabase;

public class LoginController {
          //valida al usuario
    public boolean validacionDatos(String nombre, String password) {
        Usuario usuario = UserDatabase.getUsuario(nombre, password);
        return usuario != null;
    }
}
