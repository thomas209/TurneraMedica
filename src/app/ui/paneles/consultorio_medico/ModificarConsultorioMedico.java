package app.ui.paneles.consultorio_medico;


import javax.swing.JOptionPane;

import app.ui.PanelManager;
import exceptions.ServicioException;
import resources.ConsultorioMedicoResource;

public class ModificarConsultorioMedico extends CrearModificarConsultorioMedico {

    public ModificarConsultorioMedico(PanelManager m) {
        super(m);
    }

    @Override
    protected void ejecutar() {
        int ano_desde = 0, mes_desde = 0, dia_desde = 0, ano_hasta = 0, mes_hasta = 0, dia_hasta = 0;
        String nombre_consultorio_txt = nombre_consultorio.getCampo().getText();
        String medico_dni_txt = dni_medico.getCampo().getText();

        try {
            ano_desde = Integer.parseInt(fecha_desde.getCampo_ano().getText());
            mes_desde = Integer.parseInt(fecha_desde.getCampo_mes().getText());
            dia_desde = Integer.parseInt(fecha_desde.getCampo_dia().getText());
            ano_hasta = Integer.parseInt(fecha_hasta.getCampo_ano().getText());
            mes_hasta = Integer.parseInt(fecha_hasta.getCampo_mes().getText());
            dia_hasta = Integer.parseInt(fecha_hasta.getCampo_dia().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numericos",
                "Valores Incorrectos", JOptionPane.ERROR_MESSAGE);
        }

        if (nombre_consultorio_txt.length() > 0 && ano_desde > 0 && mes_desde > 0 && dia_desde > 0 && ano_hasta > 1900 && mes_hasta > 0
        && dia_hasta > 0) {
            try {
                String fecha_desde = String.valueOf(ano_desde) + '-' + String.valueOf(mes_desde) + '-' + String.valueOf(dia_desde);
                String fecha_hasta = String.valueOf(ano_hasta) + '-' + String.valueOf(mes_hasta) + '-' + String.valueOf(dia_hasta);

                String respuesta = ConsultorioMedicoResource.modificarConsultorioMedico(nombre_consultorio_txt, medico_dni_txt, fecha_desde, fecha_hasta);
                int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                        "Modificando Consultorio Medico", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta_joption == JOptionPane.OK_OPTION) {
                    m.mostrarPantallaConsultorioMedico();
                }
            } catch (ServicioException e) {
                JOptionPane.showMessageDialog(this, "Hubo un problema al modificar el Consultorio Medico",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifica haber puesto bien todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }



    }
    
}