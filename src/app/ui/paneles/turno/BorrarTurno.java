package app.ui.paneles.turno;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.TurnoResource;

public class BorrarTurno extends JPanel {

    private PanelManager m;
    private CampoLabelField dni_medico, dni_paciente;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BorrarTurno(PanelManager m) {
        this.m = m;
        armarBorrarTurno();
    }

    private void armarBorrarTurno() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni_medico = new CampoLabelField(m, "DNI del medico");
        this.add(dni_medico);

        dni_paciente = new CampoLabelField(m, "DNI del paciente");
        this.add(dni_paciente);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Borrar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaTurno();
            }

            @Override
            protected void doAccept() {
                String dni_medico_txt = dni_medico.getCampo().getText();
                String dni_paciente_txt = dni_paciente.getCampo().getText();
                    if (dni_medico_txt.length() == 0 && dni_paciente_txt.length() > 0) {
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca valores para los campos dni",
                        "Valor invalido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {  
                            String respuesta = TurnoResource.borrarTurno(dni_medico_txt, dni_paciente_txt);
                            int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                                    "Borrando Turno", JOptionPane.OK_CANCEL_OPTION);
                            if (respuesta_joption == JOptionPane.OK_OPTION) {
                                m.mostrarPantallaTurno();
                            }
                        } catch (ServicioException e) {
                            JOptionPane.showMessageDialog(this, "Hubo un problema al borrar el turno",
                        "Error Interno", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                        }
                    }
                
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}