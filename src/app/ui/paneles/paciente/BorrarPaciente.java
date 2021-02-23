package app.ui.paneles.paciente;

import javax.swing.*;
import java.awt.*;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.PacienteResource;

public class BorrarPaciente extends JPanel {

    private PanelManager m;
    private CampoLabelField dni;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BorrarPaciente(PanelManager m) {
        this.m = m;
        armarBorrarPaciente();
    }

    private void armarBorrarPaciente() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni = new CampoLabelField(m, "* DNI");
        this.add(dni);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Borrar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaPaciente();
            }

            @Override
            protected void doAccept() {
                String dni_txt = dni.getCampo().getText();
                    if (dni_txt.length() == 0) {
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor para el campo dni",
                        "Valor invalido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {  
                            String respuesta = PacienteResource.borrarPaciente(dni_txt);
                            int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                                    "Borrando Paciente", JOptionPane.OK_CANCEL_OPTION);
                            if (respuesta_joption == JOptionPane.OK_OPTION) {
                                m.mostrarPantallaPaciente();
                            }
                        } catch (ServicioException e) {
                            JOptionPane.showMessageDialog(this, "Hubo un problema al borrar el paciente",
                        "Error Interno", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                        }
                    }
                
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}