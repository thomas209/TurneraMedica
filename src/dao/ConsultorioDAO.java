package dao;

import java.util.List;

import exceptions.DAOException;
import modelos.Consultorio;;

public interface ConsultorioDAO {

    public void crearConsultorio(Consultorio c) throws DAOException; 
    public void borrarConsultorio(String nombre) throws DAOException; 
    public void modificarConsultorio(String nombre, String direccion) throws DAOException; 
    public List<Object> listarConsultorios() throws DAOException;
    public List<Object> consultarConsultorio(String nombre) throws DAOException;

}