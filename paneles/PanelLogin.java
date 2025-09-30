package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

import control.LoginController;
import Ventanas.VentanaPrincipal;
import Modelo.Usuario;

public class PanelLogin {

    private JPanel panelLogin;

    public PanelLogin() {
        panelLogin = new JPanel();
        panelLogin.setSize(500, 800);
        panelLogin.setOpaque(true);
        panelLogin.setBackground(new Color(18,18,18));
        panelLogin.setLayout(new GridBagLayout());

        // administrador de diseño
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 80, 10, 80);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // titulo
        JLabel titulo = new JLabel("Spotify Login");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(false);
        titulo.setForeground(new Color(29,185,84)); // verde Spotify
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelLogin.add(titulo, gbc);

        // etiqueta Usuario
        JLabel userLbl = new JLabel("Usuario:");
        userLbl.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelLogin.add(userLbl, gbc);

        // entrada usuario
        JTextField entradaCorreo = new JTextField();
        entradaCorreo.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelLogin.add(entradaCorreo, gbc);

        // etiqueta Contraseña
        JLabel passLbl = new JLabel("Contraseña:");
        passLbl.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelLogin.add(passLbl, gbc);

        // entrada contraseña
        JPasswordField entradaContrasenna = new JPasswordField();
        entradaContrasenna.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelLogin.add(entradaContrasenna, gbc);

        // Botón
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(new Color(29,185,84)); // verde
        btnIngresar.setForeground(Color.BLACK);
   
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        panelLogin.add(btnIngresar, gbc);

        // Acción del botón login 
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entradaUsuario = entradaCorreo.getText();
                String entradaPass = new String(entradaContrasenna.getPassword());

                if (new LoginController().validacionDatos(entradaUsuario, entradaPass)) {
                    new VentanaPrincipal(new Usuario(entradaUsuario, entradaPass));
                    JFrame ventanaPadre = (JFrame) SwingUtilities.getWindowAncestor(panelLogin);
                    ventanaPadre.dispose();
                }
            }
        });
    }

    public JPanel getJPanel() {
        return panelLogin;
    }
}
