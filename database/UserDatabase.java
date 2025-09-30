package database;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static List<Usuario> usuarios = new ArrayList<>();
    //funcion de login
    static {
        usuarios.add(new Usuario("paula", "1234"));
       
    }

    public static Usuario getUsuario(String nombre, String password) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
