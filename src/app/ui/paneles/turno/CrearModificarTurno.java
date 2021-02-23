package app.ui.paneles.turno;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoFechas;
import app.ui.util.CampoHora;
import app.ui.util.CampoLabelField;

public abstract class CrearModificarTurno extends JPanel {

    protected PanelManager m;
    protected CampoLabelField dni_medico, dni_paciente, consultorio;
    protected CampoHora hora_turno;
    protected CampoFechas fecha_turno;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public CrearModificarTurno(PanelManager m) {
        this.m = m;
        armarCrearModificarTurno();
    }

    private void armarCrearModificarTurno() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni_medico = new CampoLabelField(m, "DNI del medico");
        this.add(dni_medico);

        dni_paciente = new CampoLabelField(m, "DNI del paciente");
        this.add(dni_paciente);

        fecha_turno = new CampoFechas(m, "Fecha del turno");
        this.add(fecha_turno);

        hora_turno = new CampoHora(m, "Hora del turno");
        this.add(hora_turno);

        consultorio = new CampoLabelField(m, "Consultorio");
        this.add(consultorio);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Aceptar"){

            @Override
            protected void doCancel() {
                m.mostrarPantallaTurno();
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