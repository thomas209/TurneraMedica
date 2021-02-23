package app.ui.paneles.paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoFechas;
import app.ui.util.CampoLabelField;

public abstract class CrearModificarPaciente extends JPanel {

    protected PanelManager m;
    protected CampoLabelField dni, nombre, apellido, obraSocial;
    protected CampoFechas fecha_nacimiento;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public CrearModificarPaciente(PanelManager m) {
        this.m = m;
        armarCrearModificarPaciente();
    }

    private void armarCrearModificarPaciente() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni = new CampoLabelField(m, "DNI");
        this.add(dni);

        nombre = new CampoLabelField(m, "Nombre");
        this.add(nombre);

        apellido = new CampoLabelField(m, "Apellido");
        this.add(apellido);

        fecha_nacimiento = new CampoFechas(m, "Fecha de Nacimiento");
        this.add(fecha_nacimiento);

        obraSocial = new CampoLabelField(m, "Obra Social");
        this.add(obraSocial);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Aceptar"){

            @Override
            protected void doCancel() {
                m.mostrarPantallaPaciente();
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