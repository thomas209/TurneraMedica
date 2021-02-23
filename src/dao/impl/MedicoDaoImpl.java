package dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.MedicoDAO;
import exceptions.DAOException;
import modelos.Medico;
import util.DBExceptionsHandler;

public class MedicoDaoImpl implements MedicoDAO {

    private static final String SQL_CREAR_MEDICO = "INSERT INTO medicos (dni, nombre, apellido, fechaNacido, montoConsulta, listadoObraSocial) VALUES (?,?,?,?,?,?);"; //dni, nombre, apellido, fechaNacido,montoConsulta, listadoObraSocial
    private static final String SQL_BORRAR_MEDICO = "DELETE FROM medicos WHERE dni = ?";
    private static final String SQL_MODIFICAR_MEDICO = "UPDATE medicos set nombre = ?, apellido = ?, fechaNacido = ?, montoConsulta = ?, listadoObraSocial = ? WHERE dni = ?";
    private static final String SQL_LISTAR_MEDICOS = "SELECT * FROM medicos";
    private static final String SQL_CONSULTAR_MEDICO = "SELECT * FROM medicos WHERE dni = ?";
    private ArrayList<Object> lista_de_datos =  new ArrayList<Object>(Arrays.asList(0, " ", " ", Date.valueOf("2019-10-03"), (float) 1.2, " "));

    // ERRORES
    private static final String ERROR = "Ups, hubo un error a la hora de ";

    PreparedStatement ps = null;
    DBExceptionsHandler dbExceptionsHandler = new DBExceptionsHandler();

    @Override
    public void crearMedico(Medico m) throws DAOException {
        ArrayList<Object> medico = new ArrayList<Object>();
        medico.add(m.getDni());
        medico.add(m.getNombre());
        medico.add(m.getApellido());
        medico.add(m.getFechaNacido());
        medico.add(m.getMontoConsulta());
        medico.add(m.getListadoObraSocial());
        dbExceptionsHandler.executeQUERY(SQL_CREAR_MEDICO, medico, this.lista_de_datos, false, ERROR + "crear un medico.");
    }

    @Override
    public void borrarMedico(String medico_dni) throws DAOException {
        ArrayList<Object> medico = new ArrayList<Object>();
        medico.add(medico_dni);
        dbExceptionsHandler.executeQUERY(SQL_BORRAR_MEDICO, medico, this.lista_de_datos, false, ERROR + "borrar un medico.");

    }

    @Override
    public void modificarMedico(Medico m) throws DAOException {
        ArrayList<Object> medico = new ArrayList<Object>();
        medico.add(m.getNombre());
        medico.add(m.getApellido());
        medico.add(m.getFechaNacido());
        medico.add(m.getMontoConsulta());
        medico.add(m.getListadoObraSocial());
        medico.add(m.getDni());
        dbExceptionsHandler.executeQUERY(SQL_MODIFICAR_MEDICO, medico, this.lista_de_datos, false, ERROR + "modificar un medico.");
    }

    @Override
    public List<Object> listarMedicos() throws DAOException {
        ArrayList<Object> medico = new ArrayList<Object>();
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_LISTAR_MEDICOS, medico, this.lista_de_datos, true, ERROR + "listar los medicos.");
        return listado;
    }

    @Override
    public List<Object> consultarMedico(String dni) throws DAOException {
        ArrayList<Object> medico = new ArrayList<Object>();
        medico.add(dni);
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_MEDICO, medico, this.lista_de_datos, true, ERROR + "consultar un medico.");
        return listado;
    }

    

}