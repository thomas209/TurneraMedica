package dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.PacienteDAO;
import exceptions.DAOException;
import modelos.Paciente;
import util.DBExceptionsHandler;

public class PacienteDaoImpl implements PacienteDAO {

    private static final String SQL_CREAR_PACIENTE = "INSERT INTO pacientes (dni, nombre, apellido, fechaNacido, ObraSocial) VALUES (?,?,?,?,?);";
    private static final String SQL_BORRAR_PACIENTE = "DELETE FROM pacientes WHERE dni = ?";
    private static final String SQL_MODIFICAR_PACIENTE = "UPDATE pacientes set nombre = ?, apellido = ?, fechaNacido = ?, ObraSocial = ? WHERE dni = ?";
    private static final String SQL_LISTAR_PACIENTE = "SELECT * FROM pacientes";
    private static final String SQL_CONSULTAR_PACIENTE = "SELECT * FROM pacientes WHERE dni = ?";

    private ArrayList<Object> lista_de_datos =  new ArrayList<Object>(Arrays.asList(0, " ", " ", Date.valueOf("2019-10-03"), " "));


    // ERRORES
    private static final String ERROR = "Ups, hubo un error a la hora de ";

    PreparedStatement ps = null;
    DBExceptionsHandler dbExceptionsHandler = new DBExceptionsHandler();

    @Override
    public void crearPaciente(Paciente p) throws DAOException {
        ArrayList<Object> paciente = new ArrayList<Object>();
        paciente.add(p.getDni());
        paciente.add(p.getNombre());
        paciente.add(p.getApellido());
        paciente.add(p.getFechaNacido());
        paciente.add(p.getObraSocial());
        dbExceptionsHandler.executeQUERY(SQL_CREAR_PACIENTE, paciente, this.lista_de_datos, false, ERROR + "crear un medico.");
    }

    @Override
    public void borrarPaciente(String dni) throws DAOException {
        ArrayList<Object> paciente = new ArrayList<Object>();
        paciente.add(dni);
        dbExceptionsHandler.executeQUERY(SQL_BORRAR_PACIENTE, paciente, this.lista_de_datos, false, ERROR + "borrar un medico.");

    }

    @Override
    public void modificarPaciente(Paciente p) throws DAOException {
        ArrayList<Object> paciente = new ArrayList<Object>();
        paciente.add(p.getNombre());
        paciente.add(p.getApellido());
        paciente.add(p.getFechaNacido());
        paciente.add(p.getObraSocial());
        paciente.add(p.getDni());
        dbExceptionsHandler.executeQUERY(SQL_MODIFICAR_PACIENTE, paciente, this.lista_de_datos, false, ERROR + "modificar un medico.");
    }

    @Override
    public List<Object> listarPacientes() throws DAOException {
        ArrayList<Object> paciente = new ArrayList<Object>();
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_LISTAR_PACIENTE, paciente, this.lista_de_datos, true, ERROR + "listar los medicos.");
        return listado;
    }

    @Override
    public List<Object> consultarPaciente(String dni) throws DAOException {
        ArrayList<Object> paciente = new ArrayList<Object>();
        paciente.add(dni);
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_PACIENTE, paciente, this.lista_de_datos, true, ERROR + "consultar un medico.");
        return listado;
    }

}