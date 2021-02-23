package app.ui.paneles.consultorio_medico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoFechas;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.ConsultorioMedicoResource;

public class BuscarConsultorioMedico extends JPanel {

    private PanelManager m;
    private CampoLabelField nombre_consultorio, medico_dni;
    private CampoFechas fecha_reserva;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BuscarConsultorioMedico(PanelManager m) {
        this.m = m;
        armarBuscarConsultorioMedico();
    }

    private void armarBuscarConsultorioMedico() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        nombre_consultorio = new CampoLabelField(m, "Nombre del Consultorio");
        this.add(nombre_consultorio);

        medico_dni = new CampoLabelField(m, "DNI del Medico");
        this.add(medico_dni);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Buscar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorioMedico();
            }

            @Override
            protected void doAccept() {
                int medico_dni_txt = 0, ano = 0, mes = 0, dia = 0;
                String nombre_consultorio_txt = nombre_consultorio.getCampo().getText();
                try {
                    medico_dni_txt = Integer.parseInt(medico_dni.getCampo().getText());
                    ano = Integer.parseInt(fecha_reserva.getCampo_ano().getText());
                    mes = Integer.parseInt(fecha_reserva.getCampo_mes().getText());
                    dia = Integer.parseInt(fecha_reserva.getCampo_dia().getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Por favor ingrese valores numericos",
                        "Valores Incorrectos", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    if (nombre_consultorio_txt.length() > 0 && medico_dni_txt > 0) {
                        List<Object> consultorio_consultado = ConsultorioMedicoResource.consultarConsultoriosMedicos(nombre_consultorio_txt, medico_dni_txt);

                    } else if (medico_dni_txt > 0 && ano > 0 && mes > 0 && dia > 0) {
                        String fecha_reserva_txt = String.valueOf(ano) + '-' + String.valueOf(mes) + '-' + String.valueOf(dia);
                        List<Object> consultorio_consultado = ConsultorioMedicoResource.consultarConsultorioMedicoFecha(medico_dni_txt, fecha_reserva_txt);

                    } else {
                        JOptionPane.showMessageDialog(this, "Por favor ingrese valores",
                        "Valores Incorrectos", JOptionPane.ERROR_MESSAGE);   
                    }
                } catch (ServicioException e) {
                    JOptionPane.showMessageDialog(this, "Hubo un problema al consultar el consultorio",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
            
        };
        this.add(botoneraAceptarCancelar);

    }

}