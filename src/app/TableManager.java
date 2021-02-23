// package app;

// import java.sql.Connection;
// import java.sql.SQLException;
// import java.sql.Statement;

// create table medicos (
// dni integer identity,
// nombre varchar,
// apellido varchar,
// fechaNacido date,
// montoConsulta float,
// listadoObraSocial varchar
// )

// create table pacientes (
// dni integer identity,
// nombre varchar,
// apellido varchar,
// fechaNacido date,
// ObraSocial varchar
// )

// create table turnos (
// medico_dni int NOT NULL ,
// paciente_dni int NOT NULL,
// fecha_turno date,
// hora_turno varchar,
// costo_consulta float,
// consultorio_id int NOT NULL,
// foreign key (medico_dni) references medicos(dni) ON DELETE CASCADE,
// foreign key (paciente_dni) references pacientes(dni) ON DELETE CASCADE,
// foreign key (consultorio_id) references consultorios(consultorio_id) ON DELETE CASCADE,
// PRIMARY KEY (medico_dni, paciente_dni)
// )

// create table consultorios (
//     consultorio_id BIGINT AUTO_INCREMENT,
//     nombre varchar UNIQUE,
//     direccion varchar
// )

// create table consultorio_medico (
// id_consultorio bigint NOT NULL ,
// medico_id int NOT NULL,
// fecha_desde date,
// fecha_hasta date,
// foreign key (id_consultorio) references consultorios(id) ON DELETE CASCADE,
// foreign key (medico_id) references medicos(dni) ON DELETE CASCADE,
// PRIMARY KEY (id_consultorio, medico_id)
// )


// public class TableManager {

// 	public void createUserTable() {

// 		Connection c = DBManager.connect();
		
// 		String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, user VARCHAR(256), email VARCHAR(256), pass VARCHAR(10))";
		
// 		try {
// 			Statement s = c.createStatement();
// 			s.execute(sql);
// 		} catch (SQLException e) {
// 			try {
// 				c.rollback();
// 				e.printStackTrace();
// 			} catch (SQLException e1) {
// 				e1.printStackTrace();
// 			}
// 		} finally {
// 			try {
// 				c.close();
// 			} catch (SQLException e) {
// 				e.printStackTrace();
// 			}
// 		}
// 	}
	
// 	// public void dropUserTable() {

// 	// 	Connection c = DBManager.connect();
		
// 	// 	String sql = "DROP TABLE usuarios";
		
// 	// 	try {
// 	// 		Statement s = c.createStatement();
// 	// 		s.execute(sql);
// 	// 		c.commit();
// 	// 	} catch (SQLException e) {
// 	// 		try {
// 	// 			c.rollback();
// 	// 		} catch (SQLException e1) {
// 	// 			e1.printStackTrace();
// 	// 		}
// 	// 	} finally {
// 	// 		try {
// 	// 			c.close();
// 	// 		} catch (SQLException e) {
// 	// 			e.printStackTrace();
// 	// 		}
// 	// 	}
// 	// }
// }