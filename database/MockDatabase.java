package database;

import appcore.AppSong;
import java.util.ArrayList;
import java.util.List;

public class MockDatabase {

    public static List<AppSong> getAvailableSongs() {
        //lista de canciones
        List<AppSong> l = new ArrayList<>();
        l.add(new AppSong("1","k-pop !","...escucha ya!","assets/images/song1.jpg"));
        l.add(new AppSong("2","sza and frank ocean !","...top 1","assets/images/song2.jpg"));
        l.add(new AppSong("3","wave to earth !","...","assets/images/song3.jpg"));
        l.add(new AppSong("4","clairo-Hello?","...reproducir ","assets/images/song4.jpg"));
        l.add(new AppSong("5","brat x","...","assets/images/song5.jpg"));
        l.add(new AppSong("6","new jeans","...","assets/images/song6.jpg"));
        l.add(new AppSong("7","TV girl","...reproducir","assets/images/song7.jpg"));
        l.add(new AppSong("8","colorful pop","...reproducir","assets/images/song8.jpg"));
        l.add(new AppSong("9","green drive","...","assets/images/song9.jpg"));
        return l;
    }
}
