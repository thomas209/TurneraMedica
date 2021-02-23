package app.ui.paneles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import app.ui.PanelManager;

public class PantallaPrincipal extends JPanel {

    private PanelManager m;

    public PantallaPrincipal(PanelManager m) {
        this.m = m;
        armarPantallaPrincipal();
    }

    public void armarPantallaPrincipal() {
        // this.setLayout(new GridLayout(3,1));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JButton medicos = new JButton("Medicos");
        medicos.setPreferredSize(new Dimension(300, 60));
        this.add(medicos);

        JButton pacientes = new JButton("Pacientes");
        pacientes.setPreferredSize(new Dimension(300, 60));
        this.add(pacientes);

        JButton turnos = new JButton("Turnos");
        turnos.setPreferredSize(new Dimension(300, 60));
        this.add(turnos);

        JButton consultorios = new JButton("Consultorios");
        consultorios.setPreferredSize(new Dimension(300, 60));
        this.add(consultorios);

        JButton consultoriosMedico = new JButton("Consultorios por Medico");
        consultoriosMedico.setPreferredSize(new Dimension(300, 60));
        this.add(consultoriosMedico);

        

        medicos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaMedicos();
			}
		});

        pacientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaPaciente();
            }
        });
        
        turnos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaTurno();
            }
		});
        
        consultorios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaConsultorio();
            }
		});
        
        consultoriosMedico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                m.mostrarPantallaConsultorioMedico();
            }
		});

    }

}