package resources;

import java.sql.Date;
import java.util.List;

import dao.impl.ConsultorioMedicoDaoImpl;
import exceptions.DAOException;
import exceptions.ServicioException;
import modelos.ConsultorioMedico;

public class ConsultorioMedicoResource {

    public static String crearConsultorioMedico(String nombre_consultorio, String medico_dni, String fecha_desde, String fecha_hasta) throws ServicioException {
        ConsultorioMedicoDaoImpl consultorioMedicoImpl = new ConsultorioMedicoDaoImpl();
        List<Object> consultorio = (List<Object>) ConsultorioResource.consultarConsultorio(nombre_consultorio);
        if (consultorio.size() > 0) {
            int id_consultorio =  (int) ((List<Object>) consultorio.get(0)).get(0);
            ConsultorioMedico cm = new ConsultorioMedico(id_consultorio, medico_dni, Date.valueOf(fecha_desde), Date.valueOf(fecha_hasta));
            List<Object> medico_encontrado = MedicoResource.consultarMedico(medico_dni);
            if (medico_encontrado.size() == 0) {
                return "No se encuentra el medico especificado";
            }
            try {
                consultorioMedicoImpl.crearConsultorioMedico(cm);
            } catch (DAOException e) {
                throw new ServicioException("No se pudo reservar el consultorio para el medico", e);
            }
            return "El consultorio fue reservado con exito!";
        }
        return "No se pudo encontrar el consultorio especificado."; 
    }

    public static String borrarConsultorioMedico(int id_consultorio, int medico_dni) throws ServicioException {
        ConsultorioMedicoDaoImpl consultorioMedicoImpl = new ConsultorioMedicoDaoImpl();
        try {
            consultorioMedicoImpl.borrarConsultorioMedico(id_consultorio, medico_dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo borrar la reserva del consultorio", e);
        }
        return "La reserva del consultorio fue borrado con exito!";
    }

    public static String modificarConsultorioMedico(String nombre_consultorio, String medico_dni, String fecha_desde, String fecha_hasta) throws ServicioException {
        ConsultorioMedicoDaoImpl consultorioMedicoImpl = new ConsultorioMedicoDaoImpl();
        List<Object> consultorio = (List<Object>) ConsultorioResource.consultarConsultorio(nombre_consultorio);
        if (consultorio.size() > 0) {
            int id_consultorio =  Integer.parseInt((String) ((List<Object>) consultorio.get(0)).get(0));
            ConsultorioMedico cm = new ConsultorioMedico(id_consultorio, medico_dni, Date.valueOf(fecha_desde), Date.valueOf(fecha_hasta));
            try {
                consultorioMedicoImpl.modificarConsultorioMedico(cm);
            } catch (DAOException e) {
                throw new ServicioException("No se pudo modificar la reserva del consultorio", e);
            }
            return "La reserva del consultorio fue modificado con exito!";
        }
        return "No se ha encontrado el consultorio";
    } // AGREGAR RETURN DE ConsultorioMedico MODIFICADO

    public static List<Object> listarConsultorioMedicos() throws ServicioException {
        ConsultorioMedicoDaoImpl consultorioMedicoImpl = new ConsultorioMedicoDaoImpl();
        List<Object> consultorioMedico;
        try {
            consultorioMedico = consultorioMedicoImpl.listarConsultoriosMedicos();
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los consultorios para los medicos", e);
        }
        return consultorioMedico;
    }

    public static List<Object> consultarConsultoriosMedicos(String nombre_consultorio, int medico_dni) throws ServicioException {
        ConsultorioMedicoDaoImpl consultorioMedicoImpl = new ConsultorioMedicoDaoImpl();
        List<Object> consultorioMedico;
        List<Object> consultorio = ConsultorioResource.consultarConsultorio(nombre_consultorio);
        if (consultorio.size() > 0) {
            int id_consultorio = Integer.parseInt((String) ((List<Object>) consultorio.get(0)).get(0));
            try {
                consultorioMedico = consultorioMedicoImpl.consultarConsultorioMedico(id_consultorio, medico_dni);
            } catch (DAOException e) {
                throw new ServicioException("No se pudo obtener el ConsultorioMedico", e);
            }
            return consultorioMedico;
        }
        return null;
    }

    public static List<Object> consultarConsultorioMedicoFecha(int medico_dni, String fecha) throws ServicioException {
        ConsultorioMedicoDaoImpl consultorioMedicoImpl = new ConsultorioMedicoDaoImpl();
        List<Object> consultorioMedico;
        try {
            consultorioMedico = consultorioMedicoImpl.consultarConsultorioMedicoFecha(medico_dni, fecha);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo obtener el ConsultorioMedico", e);
        }
        return consultorioMedico;
    }

}