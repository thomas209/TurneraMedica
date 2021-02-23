package modelos;


public class Paciente extends Persona {

    private String obraSocial;

    public Paciente() {
    }

    public Paciente(int dni) {
        super(dni);
    }

    public Paciente(int dni, String nombre, String apellido, String fechaNacido) {
        super(dni, nombre, apellido, fechaNacido);
    }

    public Paciente(int dni, String nombre, String apellido, String fechaNacido, String obraSocial) {
        super(dni, nombre, apellido, fechaNacido);
        this.obraSocial = obraSocial;
    }

    public String getObraSocial() {
        return this.obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }


}