package modelos;

import java.sql.Date;

public class ConsultorioMedico {

    int id_consultorio;
    String medico_dni;
    Date fecha_desde;
    Date fecha_hasta;

    public ConsultorioMedico(int id_consultorio, String medico_dni, Date fecha_desde, Date fecha_hasta) {
        this.id_consultorio = id_consultorio;
        this.medico_dni = medico_dni;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
    }

    public int getId_consultorio() {
        return this.id_consultorio;
    }

    public String getMedico_dni() {
        return this.medico_dni;
    }

    public Date getFecha_desde() {
        return this.fecha_desde;
    }

    public void setFecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getFecha_hasta() {
        return this.fecha_hasta;
    }

    public void setFecha_hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }
    
}