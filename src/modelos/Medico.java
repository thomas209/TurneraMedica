package modelos;


public class Medico extends Persona {
    
    private float montoConsulta;
    private String listadoObraSocial;

    public Medico() {
    }

    public Medico(int dni) {
        super(dni);
    }

    public Medico(int dni, String nombre, String apellido, String fechaNacido) {
        super(dni, nombre, apellido, fechaNacido);
    }

    public Medico(int dni, String nombre, String apellido, String fechaNacido, float montoConsulta, String listadoObraSocial) {
        super(dni, nombre, apellido, fechaNacido);
        this.montoConsulta = montoConsulta;
        this.listadoObraSocial = listadoObraSocial;
    }

    // POR SI EL MEDICO AUN NO TIENE OBRAS SOCIALES ASOCIADAS
    public Medico(int dni, String nombre, String apellido, String fechaNacido, float montoConsulta){
        super(dni, nombre, apellido, fechaNacido);
        this.montoConsulta = montoConsulta;
    }

    public float getMontoConsulta() {
        return this.montoConsulta;
    }

    public void setMontoConsulta(float montoConsulta) {
        this.montoConsulta = montoConsulta;
    }

    public String getListadoObraSocial() {
        return this.listadoObraSocial;
    }

    public void setListadoObraSocial(String listadoObraSocial) {
        this.listadoObraSocial = listadoObraSocial;
    }


}