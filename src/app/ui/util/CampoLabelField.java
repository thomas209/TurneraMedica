package app.ui.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;

public class CampoLabelField extends JPanel {
    
    private PanelManager m;
    private JTextField campo;

    public CampoLabelField(PanelManager m, String label) {
        this.m = m;
        armarCampoLabelField(label);
    }

    private void armarCampoLabelField(String label) {

        this.setLayout(new FlowLayout());

        JLabel nombreDelCampo = new JLabel(label);
        // nombreDelCampo.setPreferredSize(new Dimension(300, 60));
        this.add(nombreDelCampo);

        campo = new JTextField();
        campo.setPreferredSize(new Dimension(250, 30));
        this.add(campo);

    }

    public JTextField getCampo() {
        return campo;
    }

    public void setCampo(JTextField campo) {
        this.campo = campo;
    }

}