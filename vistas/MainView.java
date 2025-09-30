package vistas;

import javax.swing.*;
import appcore.AppPlaylist;
import control.PlaylistController;
//Ventana simple con biblioteca
public class MainView {
    private JFrame frame;

    public MainView(AppPlaylist playlist) {
        frame = new JFrame("mix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 720);
        frame.setLocationRelativeTo(null);

        // Creamos el controller y se lo pasamos al LibraryView
        PlaylistController controller = new PlaylistController(playlist);
        frame.setContentPane(new LibraryView(controller));

        frame.setVisible(true);
    }
}
