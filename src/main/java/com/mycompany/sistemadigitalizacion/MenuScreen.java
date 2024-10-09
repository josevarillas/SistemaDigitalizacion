package com.mycompany.sistemadigitalizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame {

    public MenuScreen() {
        // Configuración del frame
        setTitle("Sistema de Digitalización");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("¿QUÉ DESEA HACER?", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new GridLayout(1, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Botón Buscar
        JButton buscarButton = new JButton();
        buscarButton.setLayout(new BorderLayout());
        buscarButton.setIcon(new ImageIcon("img_buscar.png")); // Asegúrate de que el archivo esté en la ruta correcta
        buscarButton.setBackground(Color.WHITE);
        buscarButton.setFocusPainted(false);
        buscarButton.setBorder(BorderFactory.createEmptyBorder());
        buscarButton.setPreferredSize(new Dimension(150, 150));
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Función de Buscar seleccionada.");
                // Aquí puedes llamar a la pantalla o función de búsqueda.
            }
        });

        JLabel buscarLabel = new JLabel("BUSCAR", JLabel.CENTER);
        buscarLabel.setFont(new Font("Arial", Font.BOLD, 14));
        buscarButton.add(buscarLabel, BorderLayout.SOUTH);

        // Botón Subir Archivo
        JButton subirArchivoButton = new JButton();
        subirArchivoButton.setLayout(new BorderLayout());
        subirArchivoButton.setIcon(new ImageIcon("img_digitalizar.png")); // Asegúrate de que el archivo esté en la ruta correcta
        subirArchivoButton.setBackground(Color.WHITE);
        subirArchivoButton.setFocusPainted(false);
        subirArchivoButton.setBorder(BorderFactory.createEmptyBorder());
        subirArchivoButton.setPreferredSize(new Dimension(150, 150));
        subirArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Función de Subir Archivo seleccionada.");
                // Aquí puedes llamar a la pantalla o función de subida de archivo.
            }
        });

        JLabel subirLabel = new JLabel("SUBIR ARCHIVO", JLabel.CENTER);
        subirLabel.setFont(new Font("Arial", Font.BOLD, 14));
        subirArchivoButton.add(subirLabel, BorderLayout.SOUTH);

        // Añadir los botones al panel
        buttonPanel.add(buscarButton);
        buttonPanel.add(subirArchivoButton);

        // Añadir el panel de botones al centro del panel principal
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Agregar panel principal al frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuScreen());
    }
}
