package Ventanas;

import javax.swing.*;
import paneles.PanelLogin;

public class VentanaLogin extends JFrame {

    public VentanaLogin() {
        setTitle("Spotify - Login");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelLogin panelLogin = new PanelLogin();
        setContentPane(panelLogin.getJPanel());

        setVisible(true);
    }
}
