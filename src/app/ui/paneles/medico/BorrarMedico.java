package app.ui.paneles.medico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.MedicoResource;

public class BorrarMedico extends JPanel {

    private PanelManager m;
    private CampoLabelField dni;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BorrarMedico(PanelManager m) {
        this.m = m;
        armarBorrarMedico();
    }

    private void armarBorrarMedico() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni = new CampoLabelField(m, "* DNI");
        this.add(dni);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Borrar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaMedicos();
            }

            @Override
            protected void doAccept() {
                String dni_txt = dni.getCampo().getText();
                    if (dni_txt.length() == 0) {
                        JOptionPane.showMessageDialog(this, "Por favor, introduzca un valor para el campo dni",
                        "Valor invalido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {  
                            String respuesta = MedicoResource.borrarMedico(dni_txt);
                            int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                                    "Borrando Medico", JOptionPane.OK_CANCEL_OPTION);
                            if (respuesta_joption == JOptionPane.OK_OPTION) {
                                m.mostrarPantallaMedicos();
                            }
                        } catch (ServicioException e) {
                            JOptionPane.showMessageDialog(this, "Hubo un problema al borrar el medico",
                        "Error Interno", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                        }
                    }
                
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}