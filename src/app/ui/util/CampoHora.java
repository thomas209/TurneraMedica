package app.ui.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;

public class CampoHora extends JPanel {
    
    private PanelManager m;
    private JTextField campo_hora;
    private JTextField campo_minuto;

    public CampoHora(PanelManager m, String label) {
        this.m = m;
        armarCampoHora(label);
    }

    private void armarCampoHora(String label) {

        this.setLayout(new FlowLayout());

        JLabel nombreDelCampo = new JLabel(label);
        // nombreDelCampo.setPreferredSize(new Dimension(300, 60));
        this.add(nombreDelCampo);

        campo_hora = new JTextField();
        campo_hora.setPreferredSize(new Dimension(30, 25));
        this.add(campo_hora);

        JLabel simbolo = new JLabel(":");
        // simbolo.setPreferredSize(new Dimension(300, 60));
        this.add(simbolo);

        campo_minuto = new JTextField();
        campo_minuto.setPreferredSize(new Dimension(30, 25));
        this.add(campo_minuto);

    }

    public JTextField getCampo_hora() {
        return this.campo_hora;
    }

    public void setCampo_hora(JTextField campo_hora) {
        this.campo_hora = campo_hora;
    }

    public JTextField getCampo_minuto() {
        return this.campo_minuto;
    }

    public void setCampo_minuto(JTextField campo_minuto) {
        this.campo_minuto = campo_minuto;
    }
}