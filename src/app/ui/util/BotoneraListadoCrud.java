package app.ui.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;

public abstract class BotoneraListadoCrud extends JPanel {
    
    private PanelManager m;
    JButton crear, borrar, modificar, buscar, cancelar;

    public BotoneraListadoCrud(PanelManager m) {
        this.m = m;
        armarBotoneraListadoCrud();
    }

    protected void armarBotoneraListadoCrud() {

        this.setLayout(new GridLayout(3, 2));

        crear = new JButton("Crear");
        crear.setPreferredSize(new Dimension(150, 30));
        this.add(crear);

        borrar = new JButton("Borrar");
        borrar.setPreferredSize(new Dimension(150, 30));
        this.add(borrar);

        modificar = new JButton("Modificar");
        modificar.setPreferredSize(new Dimension(150, 30));
        this.add(modificar);

        buscar = new JButton("Buscar");
        buscar.setPreferredSize(new Dimension(150, 30));
        this.add(buscar);

        cancelar = new JButton("Cancelar");
        cancelar.setPreferredSize(new Dimension(150, 30));
        this.add(cancelar);

        crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goCrear();
			}
        });

        borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBorrar();
			}
        });

        modificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goModificar();
			}
        });

        buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBuscar();
			}
        });

        cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doCancel();
			}
        });

    }

    protected abstract void goCrear();

    protected abstract void goBorrar();

    protected abstract void goModificar();

    protected abstract void goBuscar();

    protected abstract void doCancel();

    public JButton getCrear() {
        return crear;
    }

    public JButton getBorrar() {
        return borrar;
    }

    public JButton getModificar() {
        return modificar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

}