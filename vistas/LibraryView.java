package vistas;

import control.PlaylistController;
import appcore.AppSong;
import database.MockDatabase;
import modulos.AlbumPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryView extends JPanel {
    private JPanel mainPanel;  
    private JPanel mixPanel;  
    private JPanel mixGrid;
    private JPanel cancionesPanel;
    private JTextField buscador;

    private PlaylistController controller;
    private List<AppSong> todasCanciones; // canciones de MockDatabase

    public LibraryView(PlaylistController controller) {
        this.controller = controller;
       this.todasCanciones = MockDatabase.getAvailableSongs();

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getMixPanel() {
        return mixPanel;
    }

    
    public void initMixPanel() {
        // mi Biblioteca
        mainPanel = this;
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(18,18,18)); 

       
        JPanel topBar = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                Color color1 = new Color(18,18,18);
                Color color2 = new Color(40,40,40);
                GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        topBar.setPreferredSize(new Dimension(0, 60));
        topBar.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        topBar.setOpaque(false);

        JLabel titulo = new JLabel("Biblioteca");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        titulo.setForeground(new Color(29,185,84));

        // buscador 
        buscador = new JTextField(" Buscar🔎...");
        buscador.setBackground(new Color(32,32,32));
        buscador.setForeground(Color.WHITE);
        buscador.setCaretColor(Color.WHITE);
        buscador.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        buscador.addActionListener(e -> filtrarCanciones()); 

        // panel de la derecha
        JPanel decoracion = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        decoracion.setOpaque(false);

        JLabel opcion1 = new JLabel("Inicio");
        JLabel opcion2 = new JLabel("Explorar");
       

        for (JLabel lbl : new JLabel[]{opcion1, opcion2}) {
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
            lbl.setForeground(Color.LIGHT_GRAY);
        }

        decoracion.add(opcion1);
        decoracion.add(opcion2);
        

        topBar.add(titulo, BorderLayout.WEST);
        topBar.add(buscador, BorderLayout.CENTER);
        topBar.add(decoracion, BorderLayout.EAST);

        // Panel principal de canciones
        cancionesPanel = new JPanel(new GridLayout(0, 3, 18, 18));
        cancionesPanel.setBackground(new Color(18,18,18));

        JScrollPane scBiblioteca = new JScrollPane(cancionesPanel);
        scBiblioteca.setOpaque(false);
        scBiblioteca.getViewport().setBackground(new Color(18,18,18));
        scBiblioteca.setBorder(null);

        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(scBiblioteca, BorderLayout.CENTER);

        
        mostrarCanciones(todasCanciones);

        // "Mi Mix"
        mixPanel = new JPanel(new BorderLayout());
        mixPanel.setBackground(new Color(18,18,18));

        JLabel tituloMix = new JLabel("Mi Mix");
        tituloMix.setFont(new Font("SansSerif", Font.BOLD, 26));
        tituloMix.setForeground(new Color(29,185,84));
        tituloMix.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        mixGrid = new JPanel(new GridLayout(0, 3, 18, 18));
        mixGrid.setBackground(new Color(18,18,18));

        JScrollPane scMix = new JScrollPane(mixGrid);
        scMix.setOpaque(false);
        scMix.getViewport().setBackground(new Color(18,18,18));
        scMix.setBorder(null);

        mixPanel.add(tituloMix, BorderLayout.NORTH);
        mixPanel.add(scMix, BorderLayout.CENTER);
    }

    // ayuda
    private void filtrarCanciones() {
        String texto = buscador.getText().trim().toLowerCase();
        if (texto.isEmpty() || texto.equals("buscar...")) {
            mostrarCanciones(todasCanciones);
        } else {
            List<AppSong> filtradas = todasCanciones.stream()
                    .filter(s -> s.getTitle().toLowerCase().contains(texto))
                    .collect(Collectors.toList());
            mostrarCanciones(filtradas);
        }
    }

    // con ayuda
    private void mostrarCanciones(List<AppSong> canciones) {
        cancionesPanel.removeAll();
        for (AppSong s : canciones) {
            AlbumPanel p = new AlbumPanel(s, controller); 
            p.setBackground(new Color(25,25,25));
            p.setBorder(BorderFactory.createLineBorder(new Color(32,32,32), 1));
            cancionesPanel.add(p);
        }
        cancionesPanel.revalidate();
        cancionesPanel.repaint();
    }

    // Método para actualizar lo del mix
    public void mostrarMix(List<AppSong> canciones, PlaylistController controller) {
        mixGrid.removeAll();
        for (AppSong s : canciones) {
            AlbumPanel p = new AlbumPanel(s, controller);
            p.setBackground(new Color(25,25,25));
            p.setBorder(BorderFactory.createLineBorder(new Color(32,32,32), 1));
            mixGrid.add(p);
        }
        mixGrid.revalidate();
        mixGrid.repaint();
    }
}
