package Ventanas;

import Modelo.Usuario;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import appcore.AppPlaylist;
import control.PlaylistController;
import vistas.LibraryView;
//Es la ventana principal y funcional de la app, que permite navegar entre la biblioteca y el mix del usuario
public class VentanaPrincipal extends JFrame {
    private Usuario usuario;
    private JTabbedPane tabs;
    private LibraryView libraryView;
    private AppPlaylist playlist;
    private PlaylistController controller;

    public VentanaPrincipal(Usuario usuario) {
        super("Spotify - " + usuario.getNombre());
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        playlist = new AppPlaylist();
        controller = new PlaylistController(playlist);

        
      // playlist compartida y el controller
     playlist = new AppPlaylist();
     controller = new PlaylistController(playlist);

     // Aquí pasamos el controller, no la playlist
     libraryView = new LibraryView(controller);
     libraryView.initMixPanel();


     tabs = new JTabbedPane();
     tabs.addTab("Biblioteca", libraryView.getMainPanel());
     tabs.addTab("Mi Mix", libraryView.getMixPanel());

     // para que pueda salir "mi mix"
     tabs.addChangeListener(new ChangeListener() {
     @Override
     public void stateChanged(ChangeEvent e) {
        int idx = tabs.getSelectedIndex();
                // ayuda de chat
         if (idx == 1) {
         actualizarMix();
         }
            }
        });

        add(tabs, BorderLayout.CENTER);


        setVisible(true);
    }

    // refresca la vista Mi Mix con las canciones actualmente en la playlist
    public void actualizarMix() {
        libraryView.mostrarMix(playlist.getSongs(), controller);
    }
}
