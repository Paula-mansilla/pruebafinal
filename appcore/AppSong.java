package appcore;

public class AppSong {
    private String id;
    private String title;
    private String artist;
    private String coverPath;
//funcion: bloque con el que se construyen listas, se llenan ventanas y se comunican los modulos
    public AppSong(String id, String title, String artist, String coverPath) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.coverPath = coverPath;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getCoverPath() { return coverPath; }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}
