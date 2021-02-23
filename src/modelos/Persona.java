package modelos;

public class Persona {

    private int dni;
    private String nombre, apellido;
    private String fechaNacido;

    public Persona() {
    }

    public Persona(int dni) {
        this.dni = dni;
    }

    public Persona(int dni, String nombre, String apellido, String fechaNacido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacido = fechaNacido;
    }

    public int getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacido() {
        return this.fechaNacido;
    }

    public void setFechaNacido(String fechaNacido) {
        this.fechaNacido = fechaNacido;
    }

    
}