package dao;

import java.sql.Date;
import java.util.List;

import exceptions.DAOException;
import modelos.Turno;

public interface TurnoDAO {

    public void crearTurno(Turno t) throws DAOException; 
    public void borrarTurno(String medico_dni, String paciente_dni) throws DAOException; 
    public void modificarTurno(Turno t) throws DAOException;
    public List<Object> listarTurnos() throws DAOException;
    public List<Object> consultarTurnoMedico(String medico_dni) throws DAOException;
    public List<Object> consultarTurnoPaciente(String paciente_dni) throws DAOException;
    public List<Object> consultarTurnoMedicoFecha(String medico_dni, Date fecha) throws DAOException;
    public List<Object> consultarHorarioTurnoMedico (int medico_dni, String hora_turno) throws DAOException;
    public List<Object> consultarFacturacionMedico (int medico_dni, String fecha_desde, String fecha_hasta) throws DAOException;

}