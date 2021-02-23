package app.ui.paneles.consultorio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class ConsultorioTableModel extends AbstractTableModel {

    
    private String[] nombresColumnas = {"ID", "Nombre", "Direccion"};

    private Class[] tiposColumnas = {Integer.class, String.class, String.class};

    private List<Object> contenido;

    public ConsultorioTableModel() {
        contenido = new ArrayList<Object>();
    }

    public ConsultorioTableModel(List<Object> contenidoInicial) {
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

        System.out.println(m);

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