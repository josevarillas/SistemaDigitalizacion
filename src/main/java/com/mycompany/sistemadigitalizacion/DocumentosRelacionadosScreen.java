package com.mycompany.sistemadigitalizacion;

import com.formdev.flatlaf.FlatLightLaf; // Importar FlatLaf
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.JTableHeader;

public class DocumentosRelacionadosScreen extends JFrame {

    private static void iniStyle() {
        // Configuración para el botón "Ver"
        JButton btnVer = new JButton("VER");
        btnVer.putClientProperty("FlatLaf.style", "font: bold $h2.font; background: #007BFF; foreground: white; arc: 10");
        btnVer.setFocusPainted(false); // Desactiva el borde de enfoque
        btnVer.setIcon(new ImageIcon(JButton.class.getClassLoader().getResource("ojo.png")));
        btnVer.setOpaque(true);

        // Configuración para el botón "Eliminar"
        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.putClientProperty("FlatLaf.style", "font: bold $h2.font; background: #DC3545; foreground: white; arc: 10");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setOpaque(true);

        // Configuración para otros botones (ejemplo: Regresar)
        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.putClientProperty("FlatLaf.style", "font: $h3.font; background: #6C757D; foreground: white; arc: 10");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setOpaque(true);

        // Configuración para botón "Volver al Inicio"
        JButton btnVolverInicio = new JButton("VOLVER AL INICIO");
        btnVolverInicio.putClientProperty("FlatLaf.style", "font: bold $h3.font; background: #FFC107; foreground: black; arc: 10");
        btnVolverInicio.setFocusPainted(false);
        btnVolverInicio.setOpaque(true);

    }

    public DocumentosRelacionadosScreen() {
        // Configuración del frame
        setTitle("Documentos Relacionados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(true); // Permitir redimensionar

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
        table.setRowHeight(40);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        // Personalizar encabezados
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(new Color(230, 230, 230));
        header.setForeground(Color.BLACK);

        // Configurar anchos de columnas según proporciones
        int tableWidth = 800; // Ancho total estimado de la tabla (puedes cambiar esto según el tamaño del frame)
        table.getColumnModel().getColumn(0).setPreferredWidth((int) (tableWidth * 0.15)); // 25% para "Código"
        table.getColumnModel().getColumn(1).setPreferredWidth((int) (tableWidth * 0.6)); // 50% para "Asunto"
        table.getColumnModel().getColumn(2).setPreferredWidth((int) (tableWidth * 0.125)); // 12.5% para "Ver"
        table.getColumnModel().getColumn(3).setPreferredWidth((int) (tableWidth * 0.125)); // 12.5% para "Descargar"

//        // Renderizado personalizado de celdas
//        // Renderizado personalizado de celdas con la imagen "ojo.png" para el botón "VER"
//        table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer("VER", Color.BLUE, "/images/LogoHistorialMedico.png"));
//        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("DESCARGAR", Color.RED));

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
        regresarButton.setForeground(Color.BLACK); // Cambiar texto a negro
        regresarButton.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(regresarButton);

        // Botón Volver al Inicio
        JButton volverInicioButton = new JButton("VOLVER AL INICIO");
        volverInicioButton.setBackground(new Color(218, 165, 32)); // Color dorado
        volverInicioButton.setForeground(Color.BLACK); // Cambiar texto a negro
        volverInicioButton.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(volverInicioButton);

        // Personalización adicional (opcional)
        regresarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        volverInicioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
        // Establecer el Look-and-Feel FlatLightLaf
        try {
            FlatMaterialLighterIJTheme.setup();
            iniStyle();

        } catch (Exception ex) {
            System.err.println("Error al aplicar FlatLaf: " + ex.getMessage());
        }

        // Crear la ventana
        SwingUtilities.invokeLater(() -> new DocumentosRelacionadosScreen());
    }

    // Clase para renderizar los botones en la tabla
    class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

        public ButtonRenderer(String text, Color color, String imagePath) {
            setText(text); // Texto del botón
            setForeground(Color.WHITE); // Color del texto
            setBackground(color); // Color de fondo
            setFont(new Font("Arial", Font.BOLD, 12)); // Fuente del texto
            setFocusPainted(false); // Eliminar borde de enfoque
            setBorderPainted(false); // Sin bordes
            setOpaque(true); // Opacidad del botón

            // Configurar el ícono si se proporciona una imagen
            if (imagePath != null && !imagePath.isEmpty()) {
                try {
                    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
                    setIcon(icon);
                } catch (Exception e) {
                    System.err.println("Error al cargar la imagen: " + e.getMessage());
                }
            }
            setCursor(new Cursor(Cursor.HAND_CURSOR));

        }

        public ButtonRenderer(String text, Color color) {
            setText(text);
            setForeground(Color.WHITE);
            setBackground(color);
            setFont(new Font("Arial", Font.BOLD, 12));
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(true);
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
