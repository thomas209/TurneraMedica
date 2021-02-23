package app.ui.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import app.ui.PanelManager;

public class BotoneraCRUD extends JPanel {
    
    private PanelManager m;
    private JButton listar;
    private JButton buscar;
    private JButton crear;
    private JButton modificar;
    private JButton borrar;

    public BotoneraCRUD(PanelManager m, String persona) {
        this.m = m;
        armarBotoneraCRUD(persona);
    }

    public void armarBotoneraCRUD(String persona) {

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        listar = new JButton("Mostrar Lista de " + persona + "s");
        listar.setPreferredSize(new Dimension(300, 60));
        this.add(listar);

        buscar = new JButton("Buscar un " + persona);
        buscar.setPreferredSize(new Dimension(300, 60));
        this.add(buscar);

        crear = new JButton("Crear " + persona);
        crear.setPreferredSize(new Dimension(300, 60));
        this.add(crear);

        modificar = new JButton("Modificar " + persona);
        modificar.setPreferredSize(new Dimension(300, 60));
        this.add(modificar);

        borrar = new JButton("Borrar " + persona);
        borrar.setPreferredSize(new Dimension(300, 60));
        this.add(borrar);

        JButton volver = new JButton("Volver al Menu Principal ");
        volver.setPreferredSize(new Dimension(300, 60));
        this.add(volver);

        listar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MODIFICAR POR COMPONENTE
			}
        });
        
        buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MODIFICAR POR COMPONENTE
			}
        });
        
        crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MODIFICAR POR COMPONENTE
			}
        });
        
        modificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MODIFICAR POR COMPONENTE
			}
        });
        
        borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MODIFICAR POR COMPONENTE
			}
        });
        
        volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m.mostrarPantallaPrincipal();
			}
        });
    }

    public JButton getListar() {
        return listar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getCrear() {
        return crear;
    }

    public JButton getModificar() {
        return modificar;
    }

    public JButton getBorrar() {
        return borrar;
    }
}