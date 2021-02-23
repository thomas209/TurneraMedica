package app.ui.paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraCRUD;

public class PantallaPacientes extends JPanel{

    private PanelManager m;
    private BotoneraCRUD botoneraCRUD;

    public PantallaPacientes(PanelManager m) {
        this.m = m;
        armarPantallaPacientes();
    }

    private void armarPantallaPacientes() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        botoneraCRUD = new BotoneraCRUD(m, "Paciente");
        this.add(botoneraCRUD);
        

        this.botoneraCRUD.getListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaLISTARPaciente();
            }
        });

        this.botoneraCRUD.getBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBUSCARPaciente();
            }
        });

        this.botoneraCRUD.getCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaCREARPaciente();
            }
        });

        this.botoneraCRUD.getModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaMODIFICARPaciente();
            }
        });

        this.botoneraCRUD.getBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBORRARPaciente();
            }
        });

    }

}