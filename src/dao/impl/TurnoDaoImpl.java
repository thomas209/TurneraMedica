package dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.TurnoDAO;
import exceptions.DAOException;
import modelos.Turno;
import util.DBExceptionsHandler;

public class TurnoDaoImpl implements TurnoDAO {

    private static final String SQL_CREAR_TURNO = "INSERT INTO turnos (medico_dni, paciente_dni, fecha_turno, hora_turno, costo_consulta, consultorio_id) VALUES (?,?,?,?,?,?);";
    private static final String SQL_BORRAR_TURNO = "DELETE FROM turnos WHERE medico_dni = ? and paciente_dni = ?";
    private static final String SQL_MODIFICAR_TURNO = "UPDATE turnos set fecha_turno = ?, hora_turno = ?, costo_consulta = ? WHERE medico_dni = ? and paciente_dni = ?";
    private static final String SQL_LISTAR_TURNOS = "SELECT * FROM turnos";
    private static final String SQL_CONSULTAR_TURNO_MEDICO = "SELECT * FROM turnos WHERE medico_dni = ?";
	private static final String SQL_CONSULTAR_TURNO_PACIENTE = "SELECT * FROM turnos WHERE paciente_dni = ?";
	private static final String SQL_CONSULTAR_TURNO_MEDICO_FECHA = "SELECT * FROM turnos WHERE medico_dni = ? and fecha_turno = ?";
	private static final String SQL_CONSULTAR_TURNO_MEDICO_HORARIO = "SELECT * FROM turnos WHERE medico_dni = ? and hora_turno = ?";
	private static final String SQL_CONSULTAR_FACTURACION = "SELECT SUM(costo_consulta) FROM turnos WHERE medico_dni = ? and fecha_turno > ? and fecha_turno < ?";

    private ArrayList<Object> lista_de_datos =  new ArrayList<Object>(Arrays.asList(0, 0, Date.valueOf("1999-12-12"), " ", (float) 0.0));
	
	// ERRORES
    private static final String ERROR = "Ups, hubo un error a la hora de ";


    DBExceptionsHandler dbExceptionsHandler = new DBExceptionsHandler();
	
	@Override
	public void crearTurno(Turno t) throws DAOException {
        ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(t.getMedico_dni());
		turno.add(t.getPaciente_dni());
		turno.add(t.getFecha_turno());
		turno.add(t.getHora_turno());
		turno.add(t.getCosto_consulta());
		turno.add(t.getConsultorio_id());
		dbExceptionsHandler.executeQUERY(SQL_CREAR_TURNO, turno, this.lista_de_datos, false, ERROR + "crear el Turno.");
	}

	@Override
	public void borrarTurno(String medico_dni, String paciente_dni) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(medico_dni);
		turno.add(paciente_dni);
		dbExceptionsHandler.executeQUERY(SQL_BORRAR_TURNO, turno, this.lista_de_datos, false, ERROR + "borrar el Turno.");

	}

	@Override
	public void modificarTurno(Turno t) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(t.getFecha_turno());
		turno.add(t.getHora_turno());
		turno.add(t.getCosto_consulta());
		turno.add(t.getMedico_dni());
		turno.add(t.getPaciente_dni());
		dbExceptionsHandler.executeQUERY(SQL_MODIFICAR_TURNO, turno, this.lista_de_datos, false, ERROR + "modificar el Turno.");
	}

	@Override
	public List<Object> listarTurnos() throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_LISTAR_TURNOS, turno, this.lista_de_datos, true, ERROR + "listar los Turnos.");
		return listado;
	}

	@Override
	public List<Object> consultarTurnoMedico(String medico_dni) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(medico_dni);
		List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_TURNO_MEDICO, turno, this.lista_de_datos, true, ERROR + "consultar los turnos del medico.");
		return listado;
	}

	@Override
	public List<Object> consultarTurnoPaciente(String paciente_dni) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(paciente_dni);
		List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_TURNO_PACIENTE, turno, this.lista_de_datos, true, ERROR + "consultar los turnos del paciente.");
		return listado;
	}

	@Override
	public List<Object> consultarTurnoMedicoFecha(String medico_dni, Date fecha) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(medico_dni);
		turno.add(fecha);
		List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_TURNO_MEDICO_FECHA, turno, lista_de_datos, true, "consultar los turnos del medico");
		return listado;
	}

	@Override
	public List<Object> consultarHorarioTurnoMedico(int medico_dni, String hora_turno) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		turno.add(medico_dni);
		turno.add(hora_turno);
		List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_TURNO_MEDICO_HORARIO, turno, lista_de_datos, true, "consultar el horario del turno del medico");
		return listado;
	}
	
    public List<Object> consultarFacturacionMedico (int medico_dni, String fecha_desde, String fecha_hasta) throws DAOException {
		ArrayList<Object> turno = new ArrayList<Object>();
		lista_de_datos = new ArrayList<Object>(Arrays.asList((float) 0.0));
		turno.add(medico_dni);
		turno.add(fecha_desde);
		turno.add(fecha_hasta);
		List<Object> facturacion = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_FACTURACION, turno, lista_de_datos, true, "consultar la facturacion del medico");
		return facturacion;
	}
	
}