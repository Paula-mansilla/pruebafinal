package Modelo;

import java.util.ArrayList;
import java.util.List;
//organiza canciones
public class Playlist {
    private String nombre;
    private List<String> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getCanciones() {
        return canciones;
    }

    public void agregarCancion(String cancion) {
        canciones.add(cancion);
    }
}
