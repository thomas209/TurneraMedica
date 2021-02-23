package app.ui.paneles.turno;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoFechas;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.PacienteResource;
import resources.TurnoResource;

public class BuscarTurno extends JPanel {

    private PanelManager m;
    private CampoLabelField dni_medico, dni_paciente;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;
    private CampoFechas fecha_turno;

    public BuscarTurno(PanelManager m) {
        this.m = m;
        armarBuscarTurno();
    }

    private void armarBuscarTurno() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        JLabel nota = new JLabel("Podes buscar los turnos del paciente, del medico y del medico para determinada fecha. \n Recorda que si llenas todos los campos primero busca por medico");
        this.add(nota);

        dni_medico = new CampoLabelField(m, "DNI del medico");
        this.add(dni_medico);

        dni_paciente = new CampoLabelField(m, "DNI del paciente");
        this.add(dni_paciente);

        fecha_turno = new CampoFechas(m, "Fecha del turno");
        this.add(fecha_turno);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Buscar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaTurno();
            }

            @Override
            protected void doAccept() {
                String dni_medico_txt = dni_medico.getCampo().getText();
                String dni_paciente_txt = dni_paciente.getCampo().getText();
                String ano = fecha_turno.getCampo_ano().getText();
                String mes = fecha_turno.getCampo_mes().getText();
                String dia = fecha_turno.getCampo_dia().getText();
                List<Object> listado;

                try {
                    if (dni_medico_txt.length() != 0) {
                        if (ano.length() > 0 && mes.length() > 0 && dia.length() > 0) {
                            String fecha_turno_String = String.valueOf(ano) + '-' + String.valueOf(mes) + '-' + String.valueOf(dia);
                            listado = TurnoResource.consultarTurnoMecioFecha(dni_medico_txt, fecha_turno_String);
                            m.mostrarPantallaLISTARTurno(listado);
                        } else {
                            listado = TurnoResource.consultarTurnoMedico(dni_medico_txt);
                            m.mostrarPantallaLISTARTurno(listado);
                        }
                    } else if (dni_paciente_txt.length() != 0) {
                        listado = TurnoResource.consultarTurnoPaciente(dni_paciente_txt);
                        m.mostrarPantallaLISTARTurno(listado);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se introdujo ningun dni valido",
                        "Turno no encontrado", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ServicioException e) {
                    JOptionPane.showMessageDialog(this, "Hubo un problema al consultar el turno",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}