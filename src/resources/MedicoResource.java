package resources;

import java.util.List;

import dao.impl.MedicoDaoImpl;
import exceptions.DAOException;
import exceptions.ServicioException;
import modelos.Medico;

public class MedicoResource {

    public static String crearMedico(int dni, String nombre, String apellido, String fechaNacido, float montoConsulta, String listadoObraSocial) throws ServicioException {
        MedicoDaoImpl medicoImpl = new MedicoDaoImpl();
        Medico m = new Medico(dni, nombre, apellido, fechaNacido, montoConsulta, listadoObraSocial);
        try {
            medicoImpl.crearMedico(m);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo crear el Medico", e);
        }
        return "El Medico fue creado con exito!";
    }

    public static String borrarMedico(String medico_dni) throws ServicioException {
        MedicoDaoImpl medicoImpl = new MedicoDaoImpl();
        try {
            medicoImpl.borrarMedico(medico_dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo borrar el Medico", e);
        }
        return "El Medico fue borrado con exito!";
    }

    public static String modificarMedico(int dni, String nombre, String apellido, String fechaNacido, float montoConsulta, String listadoObraSocial) throws ServicioException {
        MedicoDaoImpl medicoImpl = new MedicoDaoImpl();
        Medico m = new Medico(dni, nombre, apellido, fechaNacido, montoConsulta, listadoObraSocial);
        try {
            medicoImpl.modificarMedico(m);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo modificar el Medico", e);
        }
        return "El Medico fue modificado con exito!";
    } // AGREGAR RETURN DE MEDICO MODIFICADO

    public static List<Object> listarMedicos() throws ServicioException {
        MedicoDaoImpl medicoImpl = new MedicoDaoImpl();
        List<Object> medicos;
        try {
            medicos = medicoImpl.listarMedicos();
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los Medicos", e);
        }
        return medicos;
    }

    public static List<Object> consultarMedico(String dni) throws ServicioException {
        MedicoDaoImpl medicoImpl = new MedicoDaoImpl();
        List<Object> medicos;
        try {
            medicos = medicoImpl.consultarMedico(dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo obtener el Medico", e);
        }
        return medicos;
    }

}