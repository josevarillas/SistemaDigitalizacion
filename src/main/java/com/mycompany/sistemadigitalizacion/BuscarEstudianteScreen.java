package com.mycompany.sistemadigitalizacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarEstudianteScreen extends JFrame {

    public BuscarEstudianteScreen() {
        // Configuración del frame
        setTitle("Sistema de Digitalización - Buscar Estudiante");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre componentes

        // Título
        JLabel titleLabel = new JLabel("INGRESE EL CÓDIGO DE ESTUDIANTE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Etiqueta de Código
        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(codigoLabel, gbc);

        // Campo de texto para el código
        JTextField codigoField = new JTextField(15);
        codigoField.setHorizontalAlignment(JTextField.CENTER);
        codigoField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(codigoField, gbc);

        // Botón para buscar
        JButton buscarButton = new JButton("BUSCAR");
        buscarButton.setFont(new Font("Arial", Font.BOLD, 12));
        buscarButton.setBackground(new Color(218, 165, 32)); // Color dorado
        buscarButton.setForeground(Color.BLACK);
        buscarButton.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buscarButton, gbc);

        // Acción del botón de buscar
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                // Lógica para buscar el estudiante por código
                JOptionPane.showMessageDialog(null, "Buscando información para el código: " + codigo);
            }
        });

        // Agregar panel al frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuscarEstudianteScreen());
    }
}
