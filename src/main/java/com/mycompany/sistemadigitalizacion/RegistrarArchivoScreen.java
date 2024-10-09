/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadigitalizacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RegistrarArchivoScreen extends JFrame {

    public RegistrarArchivoScreen() {
        // Configuración del frame
        setTitle("Sistema de Digitalización - Registrar Archivo");
        setSize(500, 350);
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
        JLabel titleLabel = new JLabel("REGISTRAR ARCHIVO");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Campo de texto para la ruta del documento
        JLabel rutaLabel = new JLabel("Ruta de documento:");
        rutaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(rutaLabel, gbc);

        JTextField rutaField = new JTextField(20);
        rutaField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(rutaField, gbc);

        JButton examinarButton = new JButton("Examinar documento");
        examinarButton.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(examinarButton, gbc);

        // Acción del botón para examinar archivos
        examinarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    rutaField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        // Campo de texto para el código del alumno
        JLabel codigoLabel = new JLabel("Código de alumno:");
        codigoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(codigoLabel, gbc);

        JTextField codigoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(codigoField, gbc);

        // Campo de texto para el nombre del archivo
        JLabel nombreArchivoLabel = new JLabel("Nombre de archivo:");
        nombreArchivoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(nombreArchivoLabel, gbc);

        JTextField nombreArchivoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(nombreArchivoField, gbc);

        // Botón para registrar archivo
        JButton registrarButton = new JButton("Registrar Archivo");
        registrarButton.setFont(new Font("Arial", Font.BOLD, 12));
        registrarButton.setBackground(new Color(218, 165, 32)); // Color dorado
        registrarButton.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(registrarButton, gbc);

        // Acción del botón para registrar archivo
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = rutaField.getText();
                String codigo = codigoField.getText();
                String nombreArchivo = nombreArchivoField.getText();

                if (ruta.isEmpty() || codigo.isEmpty() || nombreArchivo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Aquí se puede agregar la lógica para registrar el archivo
                    JOptionPane.showMessageDialog(null, "Archivo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Botón para regresar
        JButton regresarButton = new JButton("REGRESAR");
        regresarButton.setFont(new Font("Arial", Font.BOLD, 12));
        regresarButton.setBackground(Color.LIGHT_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(regresarButton, gbc);

        // Acción del botón para regresar
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se puede agregar la lógica para regresar a la pantalla anterior
                dispose(); // Cierra la ventana actual
            }
        });

        // Agregar panel al frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrarArchivoScreen());
    }
}
