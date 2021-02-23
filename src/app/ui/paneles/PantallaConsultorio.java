package app.ui.paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraCRUD;

public class PantallaConsultorio extends JPanel{

    private PanelManager m;
    private BotoneraCRUD botoneraCRUD;

    public PantallaConsultorio(PanelManager m) {
        this.m = m;
        armarPantallaConsultorio();
    }

    private void armarPantallaConsultorio() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        botoneraCRUD = new BotoneraCRUD(m, "Consultorio");
        this.add(botoneraCRUD);
        

        this.botoneraCRUD.getListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaLISTARConsultorio();
            }
        });

        this.botoneraCRUD.getBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBUSCARConsultorio();
            }
        });

        this.botoneraCRUD.getCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaCREARConsultorio();
            }
        });

        this.botoneraCRUD.getModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaMODIFICARConsultorio();
            }
        });

        this.botoneraCRUD.getBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBORRARConsultorio();
            }
        });

    }

}