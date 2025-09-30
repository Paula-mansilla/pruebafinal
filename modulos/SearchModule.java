package modulos;

import appcore.AppSong;
import java.util.ArrayList;
import java.util.List;

public class SearchModule {

    public static List<AppSong> filter(List<AppSong> all, String query) {
       // esto es la funcion de boton de buscar que fue con ayuda
        if (query == null || query.trim().isEmpty()) return new ArrayList<>(all);
        String q = query.toLowerCase();
        List<AppSong> res = new ArrayList<>();
        for (AppSong s : all) {
            if (s.getTitle().toLowerCase().contains(q) || s.getArtist().toLowerCase().contains(q)) {
                res.add(s);
            }
        }
        return res;
    }
}
