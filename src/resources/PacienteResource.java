package resources;

import java.util.List;

import dao.impl.PacienteDaoImpl;
import exceptions.DAOException;
import exceptions.ServicioException;
import modelos.Paciente;

public class PacienteResource {

    public static String crearPaciente(int dni, String nombre, String apellido, String fechaNacido, String obraSocial) throws ServicioException {
        PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();
        Paciente p = new Paciente(dni, nombre, apellido, fechaNacido, obraSocial);
        try {
            pacienteImpl.crearPaciente(p);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo crear el Paciente", e);
        }
        return "El Paciente fue creado con exito!";
    }

    public static String borrarPaciente(String dni) throws ServicioException {
        PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();
        try {
            pacienteImpl.borrarPaciente(dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo borrar el Paciente", e);
        }
        return "El Paciente fue borrado con exito!";
    }

    public static String modificarPaciente(int dni, String nombre, String apellido, String fechaNacido, String obraSocial) throws ServicioException {
        PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();
        Paciente p = new Paciente(dni, nombre, apellido, fechaNacido, obraSocial);
        try {
            pacienteImpl.modificarPaciente(p);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo modificar el Paciente", e);
        }
        return "El Paciente fue modificado con exito!";
    } // AGREGAR RETURN DE Paciente MODIFICADO

    public static List<Object> listarPacientes() throws ServicioException {
        PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();
        List<Object> paciente;
        try {
            paciente = pacienteImpl.listarPacientes();
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los Paciente", e);
        }
        return paciente;
    }

    public static List<Object> consultarPaciente(String dni) throws ServicioException {
        PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();
        List<Object> paciente;
        try {
            paciente = pacienteImpl.consultarPaciente(dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo obtener el Paciente", e);
        }
        return paciente;
    }

}