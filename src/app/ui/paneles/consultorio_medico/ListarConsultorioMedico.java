package app.ui.paneles.consultorio_medico;

import app.ui.PanelManager;
import app.ui.util.BotoneraListadoCrud;
import exceptions.ServicioException;

import java.awt.*;
import javax.swing.*;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import resources.ConsultorioMedicoResource;

public class ListarConsultorioMedico extends JPanel implements ActionListener, Printable {

    private PanelManager m;
    private ConsultorioMedicoTableModel modelo;

    private JTable tablaConsultorioMedico;
    private JScrollPane scrollPaneParaTabla;
    private JButton botonLlenar;
    private BotoneraListadoCrud botoneraListadoCrud;
    private List<Object> listado = new ArrayList<Object>();

    public void setListado(List<Object> listado) {
        this.listado = listado;
    }

    public ListarConsultorioMedico(PanelManager m) {
        this.m = m;
        armarListarConsultorioMedico();
    }

    public void armarListarConsultorioMedico() {

        this.setLayout(new FlowLayout());

        modelo = new ConsultorioMedicoTableModel(listado);
        tablaConsultorioMedico = new JTable(modelo);
        scrollPaneParaTabla = new JScrollPane(tablaConsultorioMedico);
        this.add(scrollPaneParaTabla);

        botonLlenar = new JButton("Cargar Tabla");
        botonLlenar.addActionListener(this);
        this.add(botonLlenar);

        botoneraListadoCrud = new BotoneraListadoCrud(m){
        
            @Override
            protected void goModificar() {
                m.mostrarPantallaMODIFICARConsultorioMedico();                
            }
        
            @Override
            protected void goCrear() {
                m.mostrarPantallaCREARConsultorioMedico();
            }
        
            @Override
            protected void goBuscar() {
                m.mostrarPantallaBUSCARConsultorioMedico();                
            }
        
            @Override
            protected void goBorrar() {
                m.mostrarPantallaBORRARConsultorioMedico();                
            }
        
            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorioMedico();                
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
            List<Object> listado_consultorio = ConsultorioMedicoResource.listarConsultorioMedicos();
            modelo.setContenido(listado_consultorio);
            JOptionPane.showMessageDialog(this, "Se listaron las reservas con exito!",
                    "Listando Consultorios", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServicioException e1) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al listar las reservas",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        modelo.fireTableDataChanged();
    }



}