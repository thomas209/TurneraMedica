package app.ui.paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import app.ui.PanelManager;
import app.ui.util.BotoneraCRUD;

public class PantallaTurnos extends JPanel{

    private PanelManager m;
    private BotoneraCRUD botoneraCRUD;

    public PantallaTurnos(PanelManager m) {
        this.m = m;
        armarPantallaTurnos();
    }

    private void armarPantallaTurnos() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        botoneraCRUD = new BotoneraCRUD(m, "Turno");
        this.add(botoneraCRUD);
        

        this.botoneraCRUD.getListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object> listado = new ArrayList<Object>();
                m.mostrarPantallaLISTARTurno(listado);
            }
        });

        this.botoneraCRUD.getBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBUSCARTurno();
            }
        });

        this.botoneraCRUD.getCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaCREARTurno();
            }
        });

        this.botoneraCRUD.getModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaMODIFICARTurno();
            }
        });

        this.botoneraCRUD.getBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaBORRARTurno();
            }
        });

    }

}