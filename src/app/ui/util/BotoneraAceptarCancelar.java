package app.ui.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;

public abstract class BotoneraAceptarCancelar extends JPanel {
    
    private PanelManager m;
    JButton aceptar, cancelar;

    public BotoneraAceptarCancelar(PanelManager m, String labelAceptar) {
        this.m = m;
        armarBotoneraAceptarCancelar(labelAceptar);
    }

    protected void armarBotoneraAceptarCancelar(String labelAceptar) {

        this.setLayout(new FlowLayout());

        aceptar = new JButton(labelAceptar);
        aceptar.setPreferredSize(new Dimension(150, 30));
        this.add(aceptar);

        cancelar = new JButton("Cancelar");
        cancelar.setPreferredSize(new Dimension(150, 30));
        this.add(cancelar);

        aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doAccept();
			}
        });

        cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doCancel();
			}
        });

    }

    protected abstract void doCancel();

    protected abstract void doAccept();

    public JButton getAceptar() {
        return aceptar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

}