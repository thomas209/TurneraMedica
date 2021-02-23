package app.ui.paneles.consultorio;

import app.ui.PanelManager;
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

import resources.ConsultorioResource;

public class ListarConsultorio extends JPanel implements ActionListener, Printable {

    private PanelManager m;
    private ConsultorioTableModel modelo;

    private JTable tablaConsultorio;
    private JScrollPane scrollPaneParaTabla;
    private JButton botonLlenar;
    private BotoneraListadoCrud botoneraListadoCrud;

    public ListarConsultorio(PanelManager m) {
        this.m = m;
        armarListarConsultorio();
    }

    public void armarListarConsultorio() {

        this.setLayout(new FlowLayout());

        modelo = new ConsultorioTableModel();
        tablaConsultorio = new JTable(modelo);
        scrollPaneParaTabla = new JScrollPane(tablaConsultorio);
        this.add(scrollPaneParaTabla);

        botonLlenar = new JButton("Cargar Tabla");
        botonLlenar.addActionListener(this);
        this.add(botonLlenar);

        botoneraListadoCrud = new BotoneraListadoCrud(m){
        
            @Override
            protected void goModificar() {
                m.mostrarPantallaMODIFICARConsultorio();                
            }
        
            @Override
            protected void goCrear() {
                m.mostrarPantallaCREARConsultorio();
            }
        
            @Override
            protected void goBuscar() {
                m.mostrarPantallaBUSCARConsultorio();                
            }
        
            @Override
            protected void goBorrar() {
                m.mostrarPantallaBORRARConsultorio();                
            }
        
            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorio();                
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
            List<Object> listado_consultorio = ConsultorioResource.listarConsultorios();
            modelo.setContenido(listado_consultorio);
            JOptionPane.showMessageDialog(this, "Se listo los Consultorios con exito!",
                    "Listando Consultorios", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServicioException e1) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al listar los Consultorios",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        modelo.fireTableDataChanged();
    }

}