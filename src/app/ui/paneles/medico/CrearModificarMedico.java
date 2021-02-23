package app.ui.paneles.medico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoFechas;
import app.ui.util.CampoLabelField;

public abstract class CrearModificarMedico extends JPanel {

    protected PanelManager m;
    protected CampoLabelField dni, nombre, apellido, montoConsulta, listadoObraSocial;
    protected CampoFechas fecha_nacimiento;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public CrearModificarMedico(PanelManager m) {
        this.m = m;
        armarCrearModificarMedico();
    }

    private void armarCrearModificarMedico() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni = new CampoLabelField(m, "DNI");
        this.add(dni);

        nombre = new CampoLabelField(m, "Nombre");
        this.add(nombre);

        apellido = new CampoLabelField(m, "Apellido");
        this.add(apellido);

        fecha_nacimiento = new CampoFechas(m, "Fecha de Nacimiento");
        this.add(fecha_nacimiento);

        montoConsulta = new CampoLabelField(m, "Monto de la Consulta");
        this.add(montoConsulta);

        listadoObraSocial = new CampoLabelField(m, "listado de Obras Sociales");
        this.add(listadoObraSocial);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Aceptar"){

            @Override
            protected void doCancel() {
                m.mostrarPantallaMedicos();
            }

            @Override
            protected void doAccept() {
                ejecutar();
            }
            
        };
        this.add(botoneraAceptarCancelar);


    }

    protected abstract void ejecutar();


}