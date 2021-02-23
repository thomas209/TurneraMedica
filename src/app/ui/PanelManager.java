package app.ui;

import java.util.List;

import javax.swing.*;

import app.ui.paneles.PantallaMedicos;
import app.ui.paneles.PantallaPacientes;
import app.ui.paneles.PantallaPrincipal;
import app.ui.paneles.medico.*;
import app.ui.paneles.paciente.*;
import app.ui.paneles.PantallaTurnos;
import app.ui.paneles.turno.*;
import app.ui.paneles.consultorio.*;
import app.ui.paneles.PantallaConsultorio;
import app.ui.paneles.consultorio_medico.*;
import app.ui.paneles.PantallaConsultorioMedico;

public class PanelManager {

	private JFrame frame;
    private PantallaPrincipal pantallaPrincipal;
    private PantallaMedicos pantallaMedicos;
	private CrearMedico pantallaCrearMedico;
	private ModificarMedico pantallaModificarMedico;
    private BorrarMedico pantallaBORRARMedicos;
	private BuscarMedico pantallaBUSCARMedicos;
	private ListarMedico pantallaLISTARMedico;
	
	private PantallaPacientes pantallaPacientes;
	private CrearPaciente pantallaCREARPaciente;
	private ModificarPaciente pantallaMODIFICARPaciente;
	private BuscarPaciente pantallaBUSCARPaciente;
	private BorrarPaciente pantallaBORRARPaciente;
	private ListarPacientes pantallaLISTARPaciente;

	private PantallaTurnos pantallaTurnos;
	private CrearTurno pantallaCREARTurno;
	private ModificarTurno pantallaMODIFICARTurno;
	private BuscarTurno pantallaBUSCARTurno;
	private BorrarTurno pantallaBORRARTurno;
	private ListarTurnos pantallaLISTARTurno;

	private PantallaConsultorio pantallaConsultorios;
	private CrearConsultorio pantallaCREARConsultorio;
	private ModificarConsultorio pantallaMODIFICARConsultorio;
	private BuscarConsultorio pantallaBUSCARConsultorio;
	private BorrarConsultorio pantallaBORRARConsultorio;
	private ListarConsultorio pantallaLISTARConsultorio;

	private PantallaConsultorioMedico pantallaConsultorioMedico;
	private CrearConsultorioMedico pantallaCREARConsultorioMedico;
	private ModificarConsultorioMedico pantallaMODIFICARConsultorioMedico;
	private BuscarConsultorioMedico pantallaBUSCARConsultorioMedico;
	private BorrarConsultorioMedico pantallaBORRARConsultorioMedico;
	private ListarConsultorioMedico pantallaLISTARConsultorioMedico;

	public PanelManager() {
		// TODO Auto-generated constructor stub
	}

	public void armarManager() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 600);

        pantallaPrincipal = new PantallaPrincipal(this);
        pantallaMedicos = new PantallaMedicos(this);
        pantallaCrearMedico = new CrearMedico(this);
        pantallaModificarMedico = new ModificarMedico(this);
        pantallaBORRARMedicos = new BorrarMedico(this);
		pantallaBUSCARMedicos = new BuscarMedico(this);
		pantallaLISTARMedico = new ListarMedico(this);
		
		pantallaPacientes = new PantallaPacientes(this);
		pantallaCREARPaciente = new CrearPaciente(this);
		pantallaMODIFICARPaciente = new ModificarPaciente(this);
		pantallaBUSCARPaciente = new BuscarPaciente(this);
		pantallaBORRARPaciente = new BorrarPaciente(this);
		pantallaLISTARPaciente = new ListarPacientes(this);
		
		pantallaTurnos = new PantallaTurnos(this);
		pantallaCREARTurno = new CrearTurno(this);
		pantallaMODIFICARTurno = new ModificarTurno(this);
		pantallaBUSCARTurno = new BuscarTurno(this);
		pantallaBORRARTurno = new BorrarTurno(this);
		pantallaLISTARTurno = new ListarTurnos(this);
		
		pantallaConsultorios = new PantallaConsultorio(this);
		pantallaCREARConsultorio = new CrearConsultorio(this);
		pantallaMODIFICARConsultorio = new ModificarConsultorio(this);
		pantallaBUSCARConsultorio = new BuscarConsultorio(this);
		pantallaBORRARConsultorio = new BorrarConsultorio(this);
		pantallaLISTARConsultorio = new ListarConsultorio(this);
		
		pantallaConsultorioMedico = new PantallaConsultorioMedico(this);
		pantallaCREARConsultorioMedico = new CrearConsultorioMedico(this);
		pantallaMODIFICARConsultorioMedico = new ModificarConsultorioMedico(this);
		pantallaBUSCARConsultorioMedico = new BuscarConsultorioMedico(this);
		pantallaBORRARConsultorioMedico = new BorrarConsultorioMedico(this);
		pantallaLISTARConsultorioMedico = new ListarConsultorioMedico(this);

		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}

	public void showFrame() {
		frame.setVisible(true);
	}

	public void mostrarPantallaPrincipal() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaPrincipal);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }
    
    public void mostrarPantallaMedicos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaMedicos);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaCREARMedicos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaCrearMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaMODIFICARMedicos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaModificarMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBORRARMedicos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBORRARMedicos);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBUSCARMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBUSCARMedicos);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaLISTARMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaLISTARMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}
	
	//PACIENTES

    public void mostrarPantallaPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaPacientes);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaCREARPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaCREARPaciente);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaMODIFICARPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaMODIFICARPaciente);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBUSCARPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBUSCARPaciente);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBORRARPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBORRARPaciente);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaLISTARPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaLISTARPaciente);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}
	
	// CONSULTORIOS

    public void mostrarPantallaConsultorio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaConsultorios);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaCREARConsultorio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaCREARConsultorio);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaMODIFICARConsultorio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaMODIFICARConsultorio);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBUSCARConsultorio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBUSCARConsultorio);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBORRARConsultorio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBORRARConsultorio);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaLISTARConsultorio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaLISTARConsultorio);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }
	
	// TURNOS

    public void mostrarPantallaTurno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaTurnos);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaCREARTurno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaCREARTurno);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaMODIFICARTurno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaMODIFICARTurno);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBUSCARTurno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBUSCARTurno);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBORRARTurno() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBORRARTurno);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaLISTARTurno(List<Object> listado) {
		pantallaLISTARTurno.setListado(listado);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaLISTARTurno);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}
	
	// CONSULTORIO MEDICO

    public void mostrarPantallaConsultorioMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaConsultorioMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaCREARConsultorioMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaCREARConsultorioMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaMODIFICARConsultorioMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaMODIFICARConsultorioMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBUSCARConsultorioMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBUSCARConsultorioMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaBORRARConsultorioMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaBORRARConsultorioMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void mostrarPantallaLISTARConsultorioMedico() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaLISTARConsultorioMedico);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

}
