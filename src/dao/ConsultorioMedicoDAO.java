package dao;

import java.util.List;

import exceptions.DAOException;
import modelos.ConsultorioMedico;

public interface ConsultorioMedicoDAO {

    public void crearConsultorioMedico(ConsultorioMedico cm) throws DAOException; 
    public void borrarConsultorioMedico(int id_consultorio, int medico_dni) throws DAOException;
    public void modificarConsultorioMedico(ConsultorioMedico cm) throws DAOException;
    public List<Object> listarConsultoriosMedicos() throws DAOException;
    public List<Object> consultarConsultorioMedico(int nombre_consultorio, int medico_dni) throws DAOException;
    public List<Object> consultarConsultorioMedicoFecha(int medico_dni, String fecha) throws DAOException;

}