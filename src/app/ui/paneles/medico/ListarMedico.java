package app.ui.paneles.medico;

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

public class ListarMedico extends JPanel implements ActionListener, Printable {

    private PanelManager m;
    private MedicoTableModel modelo;

    private JTable tablaMedicos;
    private JScrollPane scrollPaneParaTabla;
    private JButton botonLlenar;
    private BotoneraListadoCrud botoneraListadoCrud;

    public ListarMedico(PanelManager m) {
        this.m = m;
        armarListarMedico();
    }

    public void armarListarMedico() {

        this.setLayout(new FlowLayout());

        modelo = new MedicoTableModel();
        tablaMedicos = new JTable(modelo);
        scrollPaneParaTabla = new JScrollPane(tablaMedicos);
        this.add(scrollPaneParaTabla);

        botonLlenar = new JButton("Cargar Tabla");
        botonLlenar.addActionListener(this);
        this.add(botonLlenar);

        botoneraListadoCrud = new BotoneraListadoCrud(m){
        
            @Override
            protected void goModificar() {
                m.mostrarPantallaMODIFICARMedicos();                
            }
        
            @Override
            protected void goCrear() {
                m.mostrarPantallaCREARMedicos();
            }
        
            @Override
            protected void goBuscar() {
                m.mostrarPantallaBUSCARMedico();                
            }
        
            @Override
            protected void goBorrar() {
                m.mostrarPantallaBORRARMedicos();               
            }
        
            @Override
            protected void doCancel() {
                m.mostrarPantallaMedicos();                
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
            List<Object> listado_medicos = MedicoResource.listarMedicos();
            modelo.setContenido(listado_medicos);
            JOptionPane.showMessageDialog(this, "Se listo los medicos con exito!",
                    "Listando Medicos", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServicioException e1) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al listar los medicos",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        modelo.fireTableDataChanged();
    }

}