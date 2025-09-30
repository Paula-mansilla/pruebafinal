package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String password;
    private List<Playlist> playlists;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.playlists = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void agregarPlaylist(Playlist p) {
        playlists.add(p);
    }
}
