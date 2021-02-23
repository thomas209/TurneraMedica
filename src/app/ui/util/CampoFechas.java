package app.ui.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;

public class CampoFechas extends JPanel {
    
    private PanelManager m;
    private JTextField campo_ano;
    private JTextField campo_mes;
    private JTextField campo_dia;

    public CampoFechas(PanelManager m, String label) {
        this.m = m;
        armarCampoFecha(label);
    }

    private void armarCampoFecha(String label) {

        this.setLayout(new FlowLayout());

        JLabel nombreDelCampo = new JLabel(label);
        // nombreDelCampo.setPreferredSize(new Dimension(300, 60));
        this.add(nombreDelCampo);

        campo_ano = new JTextField();
        campo_ano.setPreferredSize(new Dimension(80, 25));
        this.add(campo_ano);

        JLabel simbolo = new JLabel("/");
        // simbolo.setPreferredSize(new Dimension(300, 60));
        this.add(simbolo);

        campo_mes = new JTextField();
        campo_mes.setPreferredSize(new Dimension(50, 25));
        this.add(campo_mes);
        
        JLabel simbolo2 = new JLabel("/");

        this.add(simbolo2);

        campo_dia = new JTextField();
        campo_dia.setPreferredSize(new Dimension(50, 25));
        this.add(campo_dia);

    }

    public JTextField getCampo_ano() {
        return this.campo_ano;
    }

    public void setCampo_ano(JTextField campo_ano) {
        this.campo_ano = campo_ano;
    }

    public JTextField getCampo_mes() {
        return this.campo_mes;
    }

    public void setCampo_mes(JTextField campo_mes) {
        this.campo_mes = campo_mes;
    }

    public JTextField getCampo_dia() {
        return this.campo_dia;
    }

    public void setCampo_dia(JTextField campo_dia) {
        this.campo_dia = campo_dia;
    }

}