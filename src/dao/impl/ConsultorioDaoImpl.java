package dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.ConsultorioDAO;
import exceptions.DAOException;
import modelos.Consultorio;
import util.DBExceptionsHandler;

public class ConsultorioDaoImpl implements ConsultorioDAO {
    
    private static final String SQL_CREAR_CONSULTORIO = "INSERT INTO consultorios (nombre, direccion) VALUES (?,?);";
    private static final String SQL_BORRAR_CONSULTORIO = "DELETE FROM consultorios WHERE nombre = ?";
    private static final String SQL_MODIFICAR_CONSULTORIO = "UPDATE consultorios set direccion = ? WHERE nombre = ?";
    private static final String SQL_LISTAR_CONSULTORIOS = "SELECT * FROM consultorios";
    private static final String SQL_CONSULTAR_CONSULTORIO = "SELECT * FROM consultorios WHERE nombre = ?";

    private static final String ERROR = "Ups, hubo un error a la hora de ";


    private ArrayList<Object> lista_de_datos =  new ArrayList<Object>(Arrays.asList(0,"",""));

    DBExceptionsHandler dbExceptionsHandler = new DBExceptionsHandler();

    @Override
    public void crearConsultorio(Consultorio c) throws DAOException {
        ArrayList<Object> consultorio = new ArrayList<Object>();
        consultorio.add(c.getNombre());
        consultorio.add(c.getDireccion());
        dbExceptionsHandler.executeQUERY(SQL_CREAR_CONSULTORIO, consultorio, lista_de_datos, false, ERROR + "crear un consultorio.");
    }

    @Override
    public void borrarConsultorio(String nombre) throws DAOException {
        ArrayList<Object> consultorio = new ArrayList<Object>();
        consultorio.add(nombre);
        dbExceptionsHandler.executeQUERY(SQL_BORRAR_CONSULTORIO, consultorio, lista_de_datos, false, ERROR + "borrar un consultorio.");
    }

    @Override
    public void modificarConsultorio(String nombre, String direccion) throws DAOException {
        ArrayList<Object> consultorio = new ArrayList<Object>();
        consultorio.add(nombre);
        consultorio.add(direccion);
        dbExceptionsHandler.executeQUERY(SQL_MODIFICAR_CONSULTORIO, consultorio, lista_de_datos, false, ERROR + "modificar un consultorio.");
    }

    @Override
    public List<Object> listarConsultorios() throws DAOException {
        ArrayList<Object> consultorio = new ArrayList<Object>();
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_LISTAR_CONSULTORIOS, consultorio, lista_de_datos, true, ERROR + "listar los consultorios.");
        return listado;
    }

    @Override
    public List<Object> consultarConsultorio(String nombre) throws DAOException {
        ArrayList<Object> consultorio = new ArrayList<Object>();
        consultorio.add(nombre);
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_CONSULTORIO, consultorio, lista_de_datos, true, ERROR + "consultar el consultorio.");
        return listado;
    }

}