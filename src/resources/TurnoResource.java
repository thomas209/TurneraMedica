package resources;

import java.sql.Date;
import java.util.List;

import dao.impl.TurnoDaoImpl;
import exceptions.DAOException;
import exceptions.ServicioException;
import modelos.Turno;

public class TurnoResource {

    public static String crearTurno(int medico_dni, int paciente_dni, String fecha_turno, String hora_turno, String consultorio) throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        TurnoDaoImpl verificar_turno = new TurnoDaoImpl(); // creo otra instancia porque la primera es cerrada luego de la consulta
        int consultorio_id;

        List<Object> consultorio_encontrado = ConsultorioResource.consultarConsultorio(consultorio);
        if (consultorio_encontrado.size() > 0) {
            consultorio_id = (int) ((List<Object>) consultorio_encontrado.get(0)).get(0);
        } else {
            return "No se ha encontrado el consultorio con ese nombre, verifique que esta bien escrito";
        }

        List<Object> consultorio_medico = ConsultorioMedicoResource.consultarConsultorioMedicoFecha(medico_dni, fecha_turno);
        System.out.println(consultorio_medico.size());
        if (consultorio_medico.size() == 0) {
            return "El medico no se encuentra en ese consultorio para la fecha";
        }


        Turno t = new Turno(medico_dni, paciente_dni, Date.valueOf(fecha_turno), hora_turno, consultorio_id);

        try {

            List<Object> turno_tomado = verificar_turno.consultarHorarioTurnoMedico(t.getMedico_dni(), t.getHora_turno());
            if (turno_tomado.size() > 0) {
                return "El turno ya ha sido tomado, intente con otro horario";
            }

            String dni_medico = String.valueOf(t.getMedico_dni());
            String dni_paciente = String.valueOf(t.getPaciente_dni());
            List<Object> medico = MedicoResource.consultarMedico(dni_medico);

            if (medico.size() > 0) {
                medico = (List<Object>) medico.get(0);
                Float costo_consulta = (float) medico.get(4);
                String[] obras_sociales_medico = ((String) (medico).get(5)).split(",");
                String obra_social_paciente = (String) ((List<Object>) PacienteResource.consultarPaciente(dni_paciente).get(0)).get(4);
                t.setCosto_consulta(costo_consulta);
                for (String obra_social : obras_sociales_medico) {
                    if (obra_social.equalsIgnoreCase(obra_social_paciente)) {
                        t.setCosto_consulta(costo_consulta / 2);
                    }
                }
                turnoImpl.crearTurno(t);
                return "El Truno ha sido credo con exito!";
                }
                return "No se ha encontrado el medico con ese dni";
            } catch (DAOException e) {
                throw new ServicioException("No se pudo crear el turno", e);
            }
        
    }; 
    
    public static String borrarTurno(String medico_dni, String paciente_dni) throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        try {
            turnoImpl.borrarTurno(medico_dni, paciente_dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo borrar el turno", e);
        }
        return "El Truno ha sido borrado con exito!";
    }; 
    
    public static String modificarTurno(int medico_dni, int paciente_dni, String fecha_turno, String hora_turno) throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        Turno t = new Turno(medico_dni, paciente_dni, Date.valueOf(fecha_turno), hora_turno);
        try {
            turnoImpl.modificarTurno(t);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo modificar el turno", e);
        }
        return "El Truno ha sido modificado con exito!";
    }; 
    
    public static List<Object> listarTurnos() throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        List<Object> turnos;
        try {
            turnos = turnoImpl.listarTurnos();
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los turnos", e);
        }
        return turnos;
    };
    
    public static List<Object> consultarTurnoMedico(String medico_dni) throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        List<Object> turnos;
        try {
            turnos = turnoImpl.consultarTurnoMedico(medico_dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los turnos del Medico", e);
        }
        return turnos;
    };
    
    public static List<Object> consultarTurnoPaciente(String paciente_dni) throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        List<Object> turnos;
        try {
            turnos = turnoImpl.consultarTurnoMedico(paciente_dni);
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los turnos del Paciente", e);
        }
        return turnos;
    };

    public static List<Object> consultarTurnoMecioFecha(String medico_dni, String fecha) throws ServicioException{
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        List<Object> turnos;
        try {
            turnos = turnoImpl.consultarTurnoMedicoFecha(medico_dni, Date.valueOf(fecha));
        } catch (DAOException e) {
            throw new ServicioException("No se pudo listar los turnos del medico para esa fecha.", e);
        }
        return turnos;
    }

    public static float consultarFacturacionMedico (int medico_dni, String fecha_desde, String fecha_hasta) throws ServicioException {
        TurnoDaoImpl turnoImpl = new TurnoDaoImpl();
        float facturacion = 0;
        try {
            List<Object> facturacion_response = turnoImpl.consultarFacturacionMedico(medico_dni, fecha_desde, fecha_hasta);
            if (facturacion_response.size() > 0) {
                facturacion = (float) ((List<Object>) facturacion_response.get(0)).get(0);
            }
        } catch (DAOException e) {
            throw new ServicioException("No se pudo obtener la facturacion del medico para esas fechas.", e);
        }
        return facturacion;
    }
    
}