package dao;

import java.util.List;

import exceptions.DAOException;
import modelos.Medico;

public interface MedicoDAO {

    public void crearMedico(Medico m) throws DAOException; 
    public void borrarMedico(String medico_dni) throws DAOException; 
    public void modificarMedico(Medico m) throws DAOException; 
    public List<Object> listarMedicos() throws DAOException;
    public List<Object> consultarMedico(String dni) throws DAOException; //POR AHORA SOLO SE VA A PODER BUSCAR POR DNI Y NO POR NOMBRE O/Y APELLIDO

}