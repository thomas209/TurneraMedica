package app.ui.paneles.consultorio;


import javax.swing.JOptionPane;

import app.ui.PanelManager;
import exceptions.ServicioException;
import resources.ConsultorioResource;

public class ModificarConsultorio extends CrearModificarConsultorio {

    public ModificarConsultorio(PanelManager m) {
        super(m);
    }

    @Override
    protected void ejecutar() {
        String nombre = super.nombre.getCampo().getText();
        String direccion = super.direccion.getCampo().getText();

        if (nombre.length() > 0 && direccion.length() > 0) {
            try {
                String respuesta = ConsultorioResource.modificarConsultorio(nombre, direccion);
                int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                        "Modificando Consultorio", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta_joption == JOptionPane.OK_OPTION) {
                    m.mostrarPantallaConsultorio();
                }
            } catch (ServicioException e) {
                JOptionPane.showMessageDialog(this, "Hubo un problema al modificar el Consultorio",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifica haber puesto bien todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }



    }
    
}