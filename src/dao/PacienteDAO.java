package dao;

import java.util.List;

import exceptions.DAOException;
import modelos.Paciente;

public interface PacienteDAO {

    public void crearPaciente(Paciente m) throws DAOException; 
    public void borrarPaciente(String dni) throws DAOException; 
    public void modificarPaciente(Paciente m) throws DAOException; 
    public List<Object> listarPacientes() throws DAOException;
    public List<Object> consultarPaciente(String dni) throws DAOException; //POR AHORA SOLO SE VA A PODER BUSCAR POR DNI Y NO POR NOMBRE O/Y APELLIDO

}