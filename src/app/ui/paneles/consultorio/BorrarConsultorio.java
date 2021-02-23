package app.ui.paneles.consultorio;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.ConsultorioResource;

public class BorrarConsultorio extends JPanel {

    private PanelManager m;
    private CampoLabelField nombre_consultorio;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BorrarConsultorio(PanelManager m) {
        this.m = m;
        armarBorrarConsultorio();
    }

    private void armarBorrarConsultorio() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        nombre_consultorio = new CampoLabelField(m, "Nombre del consultorio");
        this.add(nombre_consultorio);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Borrar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorio();
            }

            @Override
            protected void doAccept() {
                String nombre_consultorio_txt = nombre_consultorio.getCampo().getText();
                    if (nombre_consultorio_txt.length() == 0) {
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor para el campo nombre",
                        "Valor invalido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {  
                            String respuesta = ConsultorioResource.borrarConsultorio(nombre_consultorio_txt);
                            int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                                    "Borrando Consultorio", JOptionPane.OK_CANCEL_OPTION);
                            if (respuesta_joption == JOptionPane.OK_OPTION) {
                                m.mostrarPantallaConsultorio();
                            }
                        } catch (ServicioException e) {
                            JOptionPane.showMessageDialog(this, "Hubo un problema al borrar el Consultorio",
                        "Error Interno", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                        }
                    }
                
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}