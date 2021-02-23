package app.ui.paneles.paciente;


import javax.swing.JOptionPane;

import app.ui.PanelManager;
import exceptions.ServicioException;
import resources.PacienteResource;

public class ModificarPaciente extends CrearModificarPaciente {

    public ModificarPaciente(PanelManager m) {
        super(m);
    }

    @Override
    protected void ejecutar() {
        int dni = 0;
        String nombre = super.nombre.getCampo().getText();
        String apellido = super.apellido.getCampo().getText();
        int ano = 0, mes = 0, dia = 0;
        try {
            dni = Integer.parseInt(super.dni.getCampo().getText());
            ano = Integer.parseInt(super.fecha_nacimiento.getCampo_ano().getText());
            mes = Integer.parseInt(super.fecha_nacimiento.getCampo_mes().getText());
            dia = Integer.parseInt(super.fecha_nacimiento.getCampo_dia().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, verifique que todos los campos nummericos no contengan letras", "Valor invalido",
                    JOptionPane.ERROR_MESSAGE);
        }

        String obraSocial = super.obraSocial.getCampo().getText();

        if (dni > 0 && nombre.length() > 0 && apellido.length() > 0 && ano > 1900 && ano < 2021 && mes > 0 && mes < 13
                && dia > 0 && dia < 32 && obraSocial.length() > 0) {
            String fecha_nacimiento = String.valueOf(ano) + '-' + String.valueOf(mes) + '-' + String.valueOf(dia);
            try {
                String respuesta = PacienteResource.modificarPaciente(dni, nombre, apellido, fecha_nacimiento, obraSocial);
                int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                        "Modificando Paciente", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta_joption == JOptionPane.OK_OPTION) {
                    m.mostrarPantallaPaciente();
                }
            } catch (ServicioException e) {
                JOptionPane.showMessageDialog(this, "Hubo un problema al modificar el paciente",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifica haber puesto bien todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }



    }
    
}