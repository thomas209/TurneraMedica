package app.ui.paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraCRUD;

public class PantallaMedicos extends JPanel{

    private PanelManager m;
    private BotoneraCRUD botoneraCRUD;

    public PantallaMedicos(PanelManager m) {
        this.m = m;
        armarPantallaMedicos();
    }

    private void armarPantallaMedicos() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        botoneraCRUD = new BotoneraCRUD(m, "Medico");
        this.add(botoneraCRUD);
        

        this.botoneraCRUD.getListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaLISTARMedico();
            }
        });

        this.botoneraCRUD.getBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBUSCARMedico();
            }
        });

        this.botoneraCRUD.getCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaCREARMedicos();
            }
        });

        this.botoneraCRUD.getModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaMODIFICARMedicos();
            }
        });

        this.botoneraCRUD.getBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBORRARMedicos();
            }
        });

    }

}