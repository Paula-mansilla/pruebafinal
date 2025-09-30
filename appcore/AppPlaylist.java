package appcore;

import java.util.ArrayList;
import java.util.List;

public class AppPlaylist {
    private List<AppSong> songs = new ArrayList<>();

    public List<AppSong> getSongs() { return songs; }
    public void add(AppSong s) { if(!songs.contains(s)) songs.add(s); }
    public void remove(AppSong s) { songs.remove(s); }
    public boolean contains(AppSong s) { return songs.contains(s); }
}
