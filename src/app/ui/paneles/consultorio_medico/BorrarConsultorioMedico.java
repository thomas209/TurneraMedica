package app.ui.paneles.consultorio_medico;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.ConsultorioMedicoResource;

public class BorrarConsultorioMedico extends JPanel {

    private PanelManager m;
    private CampoLabelField id_consultorio, medico_dni;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BorrarConsultorioMedico(PanelManager m) {
        this.m = m;
        armarBorrarConsultorioMedico();
    }

    private void armarBorrarConsultorioMedico() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        id_consultorio = new CampoLabelField(m, "ID del consultorio");
        this.add(id_consultorio);
        
        medico_dni = new CampoLabelField(m, "DNI del medico");
        this.add(medico_dni);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Borrar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorioMedico();
            }

            @Override
            protected void doAccept() {
                int id_consultorio_txt = 0, medico_dni_txt = 0;
                try {
                    id_consultorio_txt = Integer.parseInt(id_consultorio.getCampo().getText());
                    medico_dni_txt = Integer.parseInt(medico_dni.getCampo().getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Por favor ingrese valores numericos",
                        "Valores Incorrectos", JOptionPane.ERROR_MESSAGE);
                }
                    if (id_consultorio_txt == 0 && medico_dni_txt == 0) {
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca un valores en los campos",
                        "Valor invalido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {  
                            String respuesta = ConsultorioMedicoResource.borrarConsultorioMedico(id_consultorio_txt, medico_dni_txt);
                            int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                                    "Borrando reserva del consultorio", JOptionPane.OK_CANCEL_OPTION);
                            if (respuesta_joption == JOptionPane.OK_OPTION) {
                                m.mostrarPantallaConsultorioMedico();
                            }
                        } catch (ServicioException e) {
                            JOptionPane.showMessageDialog(this, "Hubo un problema al borrar la reserva del consultorio.",
                        "Error Interno", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                        }
                    }
                
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}