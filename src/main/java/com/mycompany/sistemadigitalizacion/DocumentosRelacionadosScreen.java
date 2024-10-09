/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadigitalizacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentosRelacionadosScreen extends JFrame {

    public DocumentosRelacionadosScreen() {
        // Configuración del frame
        setTitle("Documentos Relacionados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("DOCUMENTOS RELACIONADOS:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Datos de ejemplo para la tabla (Código, Asunto)
        Object[][] data = {
            {"21200235", "DOCUMENTOS - D.ACADEMICO", "VER", "DESCARGAR"},
            {"22300254", "DOCUMENTOS - D.ACADEMICO", "VER", "DESCARGAR"},
            {"24200912", "RESOL. RECTORIAL", "VER", "DESCARGAR"}
        };

        // Nombres de las columnas
        String[] columnNames = {"CODIGO", "ASUNTO", "", ""};

        // Crear el modelo de tabla
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3; // Solo las columnas de "VER" y "DESCARGAR" son editables (para los botones)
            }
        };

        // Crear la tabla
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // Colorear los botones
        table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer("VER", Color.BLUE));
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("DESCARGAR", Color.RED));

        // Añadir el listener para los botones "VER" y "DESCARGAR"
        table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), "VER"));
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), "DESCARGAR"));

        // Scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel para botones de abajo
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Botón Regresar
        JButton regresarButton = new JButton("REGRESAR");
        regresarButton.setBackground(Color.LIGHT_GRAY);
        regresarButton.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(regresarButton);

        // Botón Volver al Inicio
        JButton volverInicioButton = new JButton("VOLVER AL INICIO");
        volverInicioButton.setBackground(new Color(218, 165, 32)); // Color dorado
        volverInicioButton.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(volverInicioButton);

        // Acción para los botones inferiores
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Regresando a la pantalla anterior.");
                // Implementa la lógica para regresar aquí
            }
        });

        volverInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Volviendo al inicio.");
                // Implementa la lógica para volver al inicio aquí
            }
        });

        // Añadir panel inferior
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Agregar el panel al frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DocumentosRelacionadosScreen());
    }

    // Clase para renderizar los botones en la tabla
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {
        public ButtonRenderer(String text, Color color) {
            setText(text);
            setForeground(color);
            setFont(new Font("Arial", Font.BOLD, 12));
            setBorderPainted(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Clase para manejar los eventos de los botones en la tabla
    class ButtonEditor extends DefaultCellEditor {
        private String label;

        public ButtonEditor(JCheckBox checkBox, String label) {
            super(checkBox);
            this.label = label;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 12));
            button.setForeground(column == 2 ? Color.BLUE : Color.RED);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codigo = (String) table.getValueAt(row, 0);
                    String accion = column == 2 ? "Ver" : "Descargar";
                    JOptionPane.showMessageDialog(null, accion + " archivo del código: " + codigo);
                    // Implementa la lógica para ver o descargar aquí
                }
            });
            return button;
        }
    }
}
