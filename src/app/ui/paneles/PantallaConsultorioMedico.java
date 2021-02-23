package app.ui.paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraCRUD;

public class PantallaConsultorioMedico extends JPanel{

    private PanelManager m;
    private BotoneraCRUD botoneraCRUD;

    public PantallaConsultorioMedico(PanelManager m) {
        this.m = m;
        armarPantallaConsultorioMedico();
    }

    private void armarPantallaConsultorioMedico() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        botoneraCRUD = new BotoneraCRUD(m, "Reserva de consultorio");
        this.add(botoneraCRUD);
        

        this.botoneraCRUD.getListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaLISTARConsultorioMedico();
            }
        });

        this.botoneraCRUD.getBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBUSCARConsultorioMedico();
            }
        });

        this.botoneraCRUD.getCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaCREARConsultorioMedico();
            }
        });

        this.botoneraCRUD.getModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaMODIFICARConsultorioMedico();
            }
        });

        this.botoneraCRUD.getBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBORRARConsultorioMedico();
            }
        });

    }

}