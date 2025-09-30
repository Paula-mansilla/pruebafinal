package control;

import appcore.AppPlaylist;
import appcore.AppSong;
import java.util.List;
//maneja canciones
public class PlaylistController {
    private AppPlaylist playlist;

    public PlaylistController(AppPlaylist playlist) {
        this.playlist = playlist;
    }

    public void toggleSong(AppSong s) {
        if (playlist.contains(s)) playlist.remove(s); else playlist.add(s);
    }

    public boolean isInPlaylist(AppSong s) {
        return playlist.contains(s);
    }

    public List<AppSong> getPlaylistSongs() {
        return playlist.getSongs();
    }
}
