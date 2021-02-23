package modelos;

import java.sql.Date;

public class Turno {

    private int medico_dni, paciente_dni, consultorio_id;
    private Date fecha_turno;
    private String hora_turno;
    private float costo_consulta;

    

    public Turno() {
    }

    public Turno(int medico_dni, int paciente_dni, Date fecha_turno, String hora_turno) {
        this.medico_dni = medico_dni;
        this.paciente_dni = paciente_dni;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
    }

    public Turno(int medico_dni, int paciente_dni, Date fecha_turno, String hora_turno,int consultorio_id) {
        this.medico_dni = medico_dni;
        this.paciente_dni = paciente_dni;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.consultorio_id = consultorio_id;
    }

	public int getMedico_dni() {
		return this.medico_dni;
	}

	public int getPaciente_dni() {
		return this.paciente_dni;
    }
    
    public Date getFecha_turno() {
        return this.fecha_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public String getHora_turno() {
        return this.hora_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public float getCosto_consulta() {
        return this.costo_consulta;
    }

    public void setCosto_consulta(float costo_consulta) {
        this.costo_consulta = costo_consulta;
    }

    public int getConsultorio_id() {
        return this.consultorio_id;
    }
    
}