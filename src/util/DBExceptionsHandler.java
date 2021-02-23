package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import app.DBManager;
import exceptions.DAOException;

public class DBExceptionsHandler {

    
    Connection c = DBManager.connect();

    public DBExceptionsHandler(){

    }

    public List<Object> executeQUERY(String sql, ArrayList<Object> data, ArrayList<Object> clases_data, boolean listar, String mensajeError) throws DAOException{
        List<Object> listado = new ArrayList<Object>();


        try {
            // PreparedStatement ps = null;
            PreparedStatement ps = c.prepareStatement(sql);

            int index = 1;
            for (Object value : data) {
                if (value instanceof Integer) {
                    ps.setInt((int) index++, (int) value);
                } else if (value instanceof String) {
                    ps.setString((int) index++, (String) value);
                } else if (value instanceof Date) {
                    ps.setDate((int) index++, (Date) value);
                } else if (value instanceof Float) {
                    ps.setFloat((int) index++, (Float) value);
                } else if (value instanceof LocalTime) {
                    ps.setTime((int) index++, Time.valueOf((LocalTime) value));
                } else {
                    ps.setString((int) index++, null);
                }
            };

            if (listar) { //LISTAR SIRVE PARA RELIZAR GET A LA BBDD

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ArrayList<Object> fila = new ArrayList<Object>();
                    index = 1;
                    for (Object value : clases_data) {
                        if (value instanceof Integer) {
                            fila.add(rs.getInt(index++));
                        } else if (value instanceof String) {
                            fila.add(rs.getString(index++));
                        } else if (value instanceof Date) {
                            fila.add(rs.getDate(index++));
                        } else if (value instanceof Float) {
                            fila.add(rs.getFloat(index++));
                        } else if (value instanceof LocalTime) {
                            fila.add(rs.getTime(index++));
                        }
                    };
                    listado.add(fila);
                }
            } else {
                listado = null;
                ps.executeUpdate();
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                throw new DAOException(mensajeError, e);
            } catch (SQLException e1) {
                throw new DAOException("Interal Server Error",e);
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                System.out.println("ERROR CERRANDO BBDD");
                throw new DAOException("Internal Server Error", e1);
            }
        }
        return listado;
    }

}