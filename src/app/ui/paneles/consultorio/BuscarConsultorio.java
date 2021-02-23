package app.ui.paneles.consultorio;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import app.ui.PanelManager;
import app.ui.util.BotoneraAceptarCancelar;
import app.ui.util.CampoLabelField;
import exceptions.ServicioException;
import resources.ConsultorioResource;

public class BuscarConsultorio extends JPanel {

    private PanelManager m;
    private CampoLabelField nombre_consultorio;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BuscarConsultorio(PanelManager m) {
        this.m = m;
        armarBuscarConsultorio();
    }

    private void armarBuscarConsultorio() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        nombre_consultorio = new CampoLabelField(m, "Nombre del Consultorio");
        this.add(nombre_consultorio);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Buscar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorio();
            }

            @Override
            protected void doAccept() {
                String nombre_consultorio_txt = nombre_consultorio.getCampo().getText();
                try {
                    List<Object> consultorio_consultado = ConsultorioResource.consultarConsultorio(nombre_consultorio_txt);
                    if (consultorio_consultado.size() > 0) {
                        JOptionPane.showMessageDialog(this, 
                        "ID: " + ((List<Object>) consultorio_consultado.get(0)).get(0) + "\n" +
                        "Nombre: " + ((List<Object>) consultorio_consultado.get(0)).get(1) + "\n" +
                        "Direccion: " + ((List<Object>) consultorio_consultado.get(0)).get(2),
                        "Consultorio encontrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontro el consultorio con ese dni",
                        "Consultorio no encontrado", JOptionPane.ERROR_MESSAGE);
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