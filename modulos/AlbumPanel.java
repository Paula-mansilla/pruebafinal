package modulos;

import javax.swing.*;
import java.awt.*;
import appcore.AppSong;
import control.PlaylistController;
import java.io.File;

public class AlbumPanel extends JPanel {
      private AppSong song;
    private PlaylistController controller;
    private JButton pinButton;

    public AlbumPanel(AppSong song, PlaylistController controller) {
        this.song = song;
        this.controller = controller;
        setLayout(new BorderLayout());
        setOpaque(false);

        JLabel coverLabel = new JLabel();
        coverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        coverLabel.setPreferredSize(new Dimension(160,160));
        coverLabel.setIcon(loadCover(song.getCoverPath(), 160, 160));

        JPanel meta = new JPanel();
        meta.setOpaque(false);
        meta.setLayout(new BorderLayout());

        JLabel title = new JLabel(song.getTitle());
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel artist = new JLabel(song.getArtist());
        artist.setForeground(Color.GRAY);
        artist.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        text.add(title);
        text.add(artist);

        pinButton = new JButton(controller.isInPlaylist(song) ? "Quitar" : "Agregar");
        pinButton.setFocusPainted(false);
        pinButton.addActionListener(e -> {
            controller.toggleSong(song);
            pinButton.setText(controller.isInPlaylist(song) ? "Quitar" : "Agregar");
        });

        meta.add(text, BorderLayout.CENTER);
        meta.add(pinButton, BorderLayout.EAST);

        add(coverLabel, BorderLayout.CENTER);
        add(meta, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
    }

    private ImageIcon loadCover(String path, int w, int h) {
        File f = new File(path);
        ImageIcon icon = new ImageIcon(f.getAbsolutePath());
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
}
}
