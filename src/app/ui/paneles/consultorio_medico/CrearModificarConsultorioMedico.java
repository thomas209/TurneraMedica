package app.ui.paneles.consultorio_medico;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoFechas;
import app.ui.util.CampoLabelField;

public abstract class CrearModificarConsultorioMedico extends JPanel {

    protected PanelManager m;
    protected CampoLabelField nombre_consultorio, dni_medico;
    protected CampoFechas fecha_desde, fecha_hasta;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public CrearModificarConsultorioMedico(PanelManager m) {
        this.m = m;
        armarCrearModificarConsultorioMedico();
    }

    private void armarCrearModificarConsultorioMedico() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        nombre_consultorio = new CampoLabelField(m, "Nombre del consultorio");
        this.add(nombre_consultorio);

        dni_medico = new CampoLabelField(m, "DNI del medico");
        this.add(dni_medico);

        fecha_desde = new CampoFechas(m, "Fecha desde");
        this.add(fecha_desde);

        fecha_hasta = new CampoFechas(m, "Fecha hasta");
        this.add(fecha_hasta);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Aceptar"){

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorioMedico();
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