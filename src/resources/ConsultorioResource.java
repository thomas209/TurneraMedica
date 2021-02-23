package resources;

import java.util.List;

import dao.impl.ConsultorioDaoImpl;
import exceptions.DAOException;
import exceptions.ServicioException;
import modelos.Consultorio;

public class ConsultorioResource {
    public static String crearConsultorio(String nombre, String direccion) throws ServicioException {
        ConsultorioDaoImpl consultorioImpl = new ConsultorioDaoImpl();
        Consultorio c = new Consultorio(nombre, direccion);
        List<Object> consultorio_existente = ConsultorioResource.consultarConsultorio(c.getNombre());
        if (consultorio_existente.size() == 0) {
            try {
                consultorioImpl.crearConsultorio(c);
            } catch (DAOException e) {
                throw new ServicioException("No se pudo crear el Consultorio", e);
            }
            return "El Consultorio fue creado con exito!";
        }
        return "No se puede crear el consultorio ya que se repite el nombre";
    }

    public static String borrarConsultorio(String nombre) throws ServicioException {
        ConsultorioDaoImpl consultorioImpl = new ConsultorioDaoImpl();
        try {
            consultorioImpl.borrarConsultorio(nombre);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo borrar el Consultorio", e);
        }
        return "El Consultorio fue borrado con exito!";        
    }

    public static String modificarConsultorio(String nombre, String direccion) throws ServicioException {
        ConsultorioDaoImpl consultorioImpl = new ConsultorioDaoImpl();
        try {
            consultorioImpl.modificarConsultorio(nombre, direccion);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo modificar el Consultorio", e);
        }
        return "El Consultorio fue modificado con exito!";
    } // AGREGAR RETURN DE Consultorio MODIFICADO

    public static List<Object> listarConsultorios() throws ServicioException {
        ConsultorioDaoImpl consultorioImpl = new ConsultorioDaoImpl();
        List<Object> consultorios;
        try {
            consultorios = consultorioImpl.listarConsultorios();
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los Consultorios", e);
        }
        return consultorios;
    }

    public static List<Object> consultarConsultorio(String nombre) throws ServicioException {
        ConsultorioDaoImpl consultorioImpl = new ConsultorioDaoImpl();
        List<Object> consultorios;
        try {
            consultorios = consultorioImpl.consultarConsultorio(nombre);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo consultar el Consultorio", e);
        }
        return consultorios;
    }

}