package app.ui.paneles.turno;


import javax.swing.JOptionPane;

import app.ui.PanelManager;
import exceptions.ServicioException;
import resources.PacienteResource;
import resources.TurnoResource;

public class CrearTurno extends CrearModificarTurno {

    public CrearTurno(PanelManager m) {
        super(m);
    }

    @Override
    protected void ejecutar() {
        String consultorio = super.consultorio.getCampo().getText();
        int ano = 0, mes = 0, dia = 0, hora = 0, minuto = 0, dni_medico = 0, dni_paciente = 0;
        try {
            dni_medico = Integer.parseInt(super.dni_medico.getCampo().getText());
            dni_paciente = Integer.parseInt(super.dni_paciente.getCampo().getText());
            hora = Integer.parseInt(super.hora_turno.getCampo_hora().getText());
            minuto = Integer.parseInt(super.hora_turno.getCampo_minuto().getText());
            ano = Integer.parseInt(super.fecha_turno.getCampo_ano().getText());
            mes = Integer.parseInt(super.fecha_turno.getCampo_mes().getText());
            dia = Integer.parseInt(super.fecha_turno.getCampo_dia().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, verifique que todos los campos nummericos no contengan letras", "Valor invalido",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (consultorio.length() > 0 && dni_medico > 0 && ano > 1900 && ano < 2021 && mes > 0 && mes < 13
                && dia > 0 && dia < 32 && dni_paciente > 0 && hora >= 0 && hora < 25 && minuto >= 0 && minuto < 60) {
            String fecha_turno = String.valueOf(ano) + '-' + String.valueOf(mes) + '-' + String.valueOf(dia);
            String hora_turno = String.valueOf(hora) + ':' + String.valueOf(minuto);
            try {
                String respuesta = TurnoResource.crearTurno(dni_medico, dni_paciente, fecha_turno, hora_turno, consultorio);
                int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                        "Creando Turno", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta_joption == JOptionPane.OK_OPTION) {
                    m.mostrarPantallaTurno();
                }
            } catch (ServicioException e) {
                JOptionPane.showMessageDialog(this, "Hubo un problema al crear el turno",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifica haber puesto bien todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }



    }
    
}