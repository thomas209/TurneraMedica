package app.ui.paneles.paciente;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.BotoneraListadoCrud;
import exceptions.ServicioException;

import java.awt.*;
import javax.swing.*;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import resources.MedicoResource;
import resources.PacienteResource;

public class ListarPacientes extends JPanel implements ActionListener, Printable {

    private PanelManager m;
    private PacienteTableModel modelo;

    private JTable tablaMedicos;
    private JScrollPane scrollPaneParaTabla;
    private JButton botonLlenar;
    private BotoneraListadoCrud botoneraListadoCrud;

    public ListarPacientes(PanelManager m) {
        this.m = m;
        armarListarPaciente();
    }

    public void armarListarPaciente() {

        this.setLayout(new FlowLayout());

        modelo = new PacienteTableModel();
        tablaMedicos = new JTable(modelo);
        scrollPaneParaTabla = new JScrollPane(tablaMedicos);
        this.add(scrollPaneParaTabla);

        botonLlenar = new JButton("Cargar Tabla");
        botonLlenar.addActionListener(this);
        this.add(botonLlenar);

        botoneraListadoCrud = new BotoneraListadoCrud(m){
        
            @Override
            protected void goModificar() {
                m.mostrarPantallaMODIFICARPaciente();                
            }
        
            @Override
            protected void goCrear() {
                m.mostrarPantallaCREARPaciente();
            }
        
            @Override
            protected void goBuscar() {
                m.mostrarPantallaBUSCARPaciente();                
            }
        
            @Override
            protected void goBorrar() {
                m.mostrarPantallaBORRARPaciente();                
            }
        
            @Override
            protected void doCancel() {
                m.mostrarPantallaPaciente();                
            }
        };

        this.add(botoneraListadoCrud);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        System.out.println("imprimo");
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            List<Object> listado_pacientes = PacienteResource.listarPacientes();
            modelo.setContenido(listado_pacientes);
            JOptionPane.showMessageDialog(this, "Se listo los Pacientes con exito!",
                    "Listando Pacientes", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServicioException e1) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al listar los Pacientes",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        modelo.fireTableDataChanged();
    }

}