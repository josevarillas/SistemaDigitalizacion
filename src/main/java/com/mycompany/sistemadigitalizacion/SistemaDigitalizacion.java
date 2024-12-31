/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemadigitalizacion;
import com.formdev.flatlaf.FlatLightLaf; // Importar FlatLaf
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.SwingUtilities;

/**
 *
 * @author INFORMATICA
 */
public class SistemaDigitalizacion {

    public static void main(String[] args) {
                    FlatMaterialLighterIJTheme.setup();
        SwingUtilities.invokeLater(() -> new DocumentosRelacionadosScreen());
    }
}
