package app.ui.paneles.medico;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelos.Medico;

public class MedicoTableModel extends AbstractTableModel {


    // int dni, String nombre, String apellido, Date fechaNacido, float montoConsulta, String listadoObraSocial

    private static final int COLUMNA_DNI = 0;
	private static final int COLUMNA_NOMBRE = 1;
	private static final int COLUMNA_APELLIDO = 2;
	private static final int COLUMNA_FECHA_NACIDO = 3;
	private static final int COLUMNA_MONTO_CONSULTA = 4;
    private static final int COLUMNA_LISTADO_OBRA_SOCIAL = 5;
    
    private String[] nombresColumnas = {"DNI", "Nombre", "Apellido", "Fecha Nacimiento", "Monto Consulta", "Listado Obra Social"};

    private Class[] tiposColumnas = {Integer.class, String.class, String.class, String.class, Float.class, String.class};

    private List<Object> contenido;

    public MedicoTableModel() {
        contenido = new ArrayList<Object>();
    }

    public MedicoTableModel(List<Object> contenidoInicial) {
        contenido = contenidoInicial;
    }

    @Override
    public int getRowCount() {
        return contenido.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
		super.setValueAt(value, rowIndex, columnIndex);
	}

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        List<Object> m = (List<Object>) contenido.get(rowIndex);

        Object result = null;
        result = m.get(columnIndex);
        return result;
    }

    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }

    public List<Object> getContenido() {
    	return contenido;
    }
    
    public void setContenido(List<Object> contenido) {
    	this.contenido = contenido;
    }
    
}