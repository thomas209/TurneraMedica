package app;

import java.sql.Date;

import modelos.Consultorio;
import modelos.Medico;
import modelos.Paciente;
import resources.ConsultorioMedicoResource;
import resources.ConsultorioResource;
import resources.MedicoResource;
import resources.PacienteResource;
import resources.TurnoResource;;

public class App {
    public static void main(String[] args) throws Exception {
        
        // System.out.println(MedicoResource.crearMedico(123456, "apellido", "nombre", "2019-10-03",(float) 123.98, "a,b,c"));

        // // --------------------------------

        // MedicoResource.borrarMedico("123456");

        // // ---------------------------

        // MedicoResource.crearMedico(123, "apellido", "nombre", "2019-10-03",(float) 123.98, "a,b,c");

        // MedicoResource.modificarMedico(123456, "apelasdlido", "asd", "2019-10-03",(float) 123.98, "a,b,c");

        
        // // ---------------------------

        // MedicoResource.crearMedico(153, "apelasdlido", "asd", "2019-10-03",(float) 123.98, "a,b,c");

        // MedicoResource.listarMedicos();

        // MedicoResource.borrarMedico("153");

        // // ------------------------
        // MedicoResource.consultarMedico("123");


        // MedicoResource.borrarMedico("123");

        // // PACIENTESSSSSSSSSSSSS
        // System.out.println("PACIENTES");
        // Paciente p = new Paciente(123456);

        // p.setApellido("apellido");
        // p.setNombre("nombre");
        // p.setObraSocial("a,b,c");
        // p.setFechaNacido("2019-10-03");
        
        // PacienteResource.crearPaciente(p);

        // // --------------------------------
        // Paciente p1 = new Paciente(123456);

        // PacienteResource.borrarPaciente(p1);

        // // ---------------------------
        // Paciente p2 = new Paciente(123);

        // p2.setApellido("apellido");
        // p2.setNombre("nombre");
        // p2.setFechaNacido("2019-10-03");
        // p2.setObraSocial("a,b,c");

        // PacienteResource.crearPaciente(p2);


        // Paciente p3 = new Paciente(123);

        // p3.setApellido("dasdasd");
        // p3.setNombre("asdasdas");
        // p3.setFechaNacido("2019-10-03");
        // p3.setObraSocial("c");

        // PacienteResource.modificarPaciente(p3);

        
        // // ---------------------------

        // Paciente p5 = new Paciente(153);

        // p5.setApellido("apellido");
        // p5.setNombre("nombre");
        // p5.setFechaNacido("2019-10-03");
        // p5.setObraSocial("c");

        // PacienteResource.crearPaciente(p5);

        // PacienteResource.listarPacientes();

        // Paciente pborrar = new Paciente(153);

        // PacienteResource.borrarPaciente(pborrar);

        // // ------------------------
        // PacienteResource.consultarPaciente("123");

        // Paciente pborrar2 = new Paciente(123);

        // PacienteResource.borrarPaciente(pborrar2);


        // // CONSULTORIOSSSSSSSS

        // System.out.println("CONSULTORIOOSSS");

        // Consultorio c = new Consultorio("Los locos", "Av. Cordoba");

        // ConsultorioResource.crearConsultorio(c);

        // ConsultorioResource.listarConsultorios();

        // c.setDireccion("Av. Sante Fe");
        // ConsultorioResource.modificarConsultorio(c);

        // ConsultorioResource.listarConsultorios();

        // System.out.println(ConsultorioResource.consultarConsultorio("Los locos"));

        


        // // CONSULTORIOS POR MEDICO
        
        // MedicoResource.crearMedico(123456, "apelasdlido", "asd", "2019-10-03",(float) 123.98, "a,b,c");

        // System.out.println("CONSULTORIOS MEDICO");

        // System.out.println(ConsultorioMedicoResource.crearConsultorioMedico("Los locos", "123456", Date.valueOf("2019-12-20"), Date.valueOf("2019-12-25"))); 
        // System.out.println(ConsultorioMedicoResource.listarConsultorioMedicos());

        // System.out.println(ConsultorioMedicoResource.modificarConsultorioMedico(14,"123456",  Date.valueOf("2019-10-10"), Date.valueOf("2019-12-10")));
        // System.out.println(ConsultorioMedicoResource.listarConsultorioMedicos());
        // System.out.println(ConsultorioMedicoResource.consultarConsultoriosMedicos("Los locos", 123456));



        
        // // TURNOSSSSSS
        

        // Paciente pt = new Paciente(123456);

        // pt.setApellido("apellido");
        // pt.setNombre("nombre");
        // pt.setObraSocial("a");
        // pt.setFechaNacido("2019-10-03");
        
        // PacienteResource.crearPaciente(pt);

        // System.out.println("TURNOOOOSSSS");
        
        // System.out.println(TurnoResource.crearTurno(123456,123456, "2019-12-22","10:00:00","Los locos")); 

        // TurnoResource.modificarTurno(123456,123456, Date.valueOf("2019-10-03"),"10:00:00");
        
        // System.out.println(TurnoResource.modificarTurno(123456,123456, Date.valueOf("2019-10-03"),"10:30:00"));

        // System.out.println(TurnoResource.consultarFacturacionMedico(123456, "2019-01-01", "2019-12-18"));

        // TurnoResource.listarTurnos();
        // TurnoResource.consultarTurnoMedico("123456");
        // TurnoResource.consultarTurnoPaciente("123456");
        // TurnoResource.consultarTurnoMecioFecha("123456", "2019-12-12");
        // TurnoResource.consultarTurnoMecioFecha("123456", "2019-12-10");
        
        // TurnoResource.borrarTurno("123456","123456");

        // ConsultorioResource.borrarConsultorio(c);
        // MedicoResource.borrarMedico("123456");
        // PacienteResource.borrarPaciente(pt);
        // System.out.println(ConsultorioMedicoResource.borrarConsultorioMedico(14, 123456));




        
    }
}