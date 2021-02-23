package app.ui.paneles.consultorio;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;

public abstract class CrearModificarConsultorio extends JPanel {

    protected PanelManager m;
    protected CampoLabelField nombre, direccion;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public CrearModificarConsultorio(PanelManager m) {
        this.m = m;
        armarCrearModificarConsultorio();
    }

    private void armarCrearModificarConsultorio() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        nombre = new CampoLabelField(m, "Nombre");
        this.add(nombre);

        direccion = new CampoLabelField(m, "Direccion");
        this.add(direccion);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Aceptar"){

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorio();
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