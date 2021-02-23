package app.ui.paneles.turno;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class TurnoTableModel extends AbstractTableModel {

    
    private String[] nombresColumnas = {"DNI Medico", "DNI Paciente", "Fecha del turno", "Hora del turno", "Consultorio"};

    private Class[] tiposColumnas = {Integer.class, Integer.class, String.class, String.class, String.class};

    private List<Object> contenido;

    public TurnoTableModel() {
        contenido = new ArrayList<Object>();
    }

    public TurnoTableModel(List<Object> contenidoInicial) {
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