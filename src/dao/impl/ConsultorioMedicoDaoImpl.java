package dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.ConsultorioMedicoDAO;
import exceptions.DAOException;
import modelos.ConsultorioMedico;
import util.DBExceptionsHandler;

public class ConsultorioMedicoDaoImpl implements ConsultorioMedicoDAO {

    private static final String SQL_CREAR_CONSULTORIO_MEDICO = "INSERT INTO consultorio_medico (id_consultorio, medico_id, fecha_desde, fecha_hasta) VALUES (?,?,?,?);";
    private static final String SQL_BORRAR_CONSULTORIO_MEDICO = "DELETE FROM consultorio_medico WHERE id_consultorio = ? and medico_id = ?";
    private static final String SQL_MODIFICAR_CONSULTORIO_MEDICO = "UPDATE consultorio_medico set fecha_desde = ?, fecha_hasta = ? WHERE id_consultorio = ? and medico_id = ?";
    private static final String SQL_LISTAR_CONSULTORIO_MEDICOS = "SELECT * FROM consultorio_medico";
    private static final String SQL_CONSULTAR_CONSULTORIO_MEDICO = "SELECT * FROM consultorio_medico WHERE id_consultorio = ? and medico_id = ?";
    private static final String SQL_CONSULTAR_CONSULTORIO_MEDICO_FECHA = "SELECT * FROM consultorio_medico WHERE medico_id = ? AND fecha_desde <= ? and fecha_hasta >= ?";

    private static final String ERROR = "Ups, hubo un error a la hora de ";


    private ArrayList<Object> lista_de_datos =  new ArrayList<Object>(Arrays.asList(0, 0, Date.valueOf("2010-10-10"), Date.valueOf("2010-10-10")));

    DBExceptionsHandler dbExceptionsHandler = new DBExceptionsHandler();

    @Override
    public void crearConsultorioMedico(ConsultorioMedico cm) throws DAOException {
        ArrayList<Object> consultorio_medico = new ArrayList<Object>();
        consultorio_medico.add(cm.getId_consultorio());
        consultorio_medico.add(cm.getMedico_dni());
        consultorio_medico.add(cm.getFecha_desde());
        consultorio_medico.add(cm.getFecha_hasta());
        dbExceptionsHandler.executeQUERY(SQL_CREAR_CONSULTORIO_MEDICO, consultorio_medico, lista_de_datos, false, ERROR + "asignar un consultorio a un medico.");
    }

    @Override
    public void borrarConsultorioMedico(int id_consultorio, int medico_dni) throws DAOException {
        ArrayList<Object> consultorio_medico = new ArrayList<Object>();
        consultorio_medico.add(id_consultorio);
        consultorio_medico.add(medico_dni);
        dbExceptionsHandler.executeQUERY(SQL_BORRAR_CONSULTORIO_MEDICO, consultorio_medico, lista_de_datos, false, ERROR + "desasignarle un consultorio a un medico.");
    }

    @Override
    public void modificarConsultorioMedico(ConsultorioMedico cm) throws DAOException {
        ArrayList<Object> consultorio_medico = new ArrayList<Object>();
        consultorio_medico.add(cm.getFecha_desde());
        consultorio_medico.add(cm.getFecha_hasta());
        consultorio_medico.add(cm.getId_consultorio());
        consultorio_medico.add(cm.getMedico_dni());
        dbExceptionsHandler.executeQUERY(SQL_MODIFICAR_CONSULTORIO_MEDICO, consultorio_medico, lista_de_datos, false, ERROR + "modificarle un consultorio a un medico.");
    }

    @Override
    public List<Object> listarConsultoriosMedicos() throws DAOException {
        ArrayList<Object> consultorio_medico = new ArrayList<Object>();
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_LISTAR_CONSULTORIO_MEDICOS, consultorio_medico, lista_de_datos, true, ERROR + "consultar los consultorios a los medicos.");
        return listado;
    }

    @Override
    public List<Object> consultarConsultorioMedico(int id_consultorio, int medico_dni) throws DAOException {
        ArrayList<Object> consultorio_medico = new ArrayList<Object>();
        consultorio_medico.add(id_consultorio);
        consultorio_medico.add(medico_dni);
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_CONSULTORIO_MEDICO, consultorio_medico, lista_de_datos, true, ERROR + "consultar un consultorio a un medico.");
        return listado;
    }

    @Override
    public List<Object> consultarConsultorioMedicoFecha(int medico_dni, String fecha) throws DAOException {
        ArrayList<Object> consultorio_medico = new ArrayList<Object>();
        consultorio_medico.add(medico_dni);
        consultorio_medico.add(fecha);
        consultorio_medico.add(fecha);
        List<Object> listado = dbExceptionsHandler.executeQUERY(SQL_CONSULTAR_CONSULTORIO_MEDICO_FECHA, consultorio_medico, lista_de_datos, true, ERROR + "consultar un consultorio a un medico.");
        return listado;
    }

    
}