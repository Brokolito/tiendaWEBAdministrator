package com.proyecto.administraciontiendawebapp.model;

import com.proyecto.administraciontiendawebapp.model.data.DBConnector;
import com.proyecto.administraciontiendawebapp.model.data.dao.TrabajadorDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class Trabajador {
	private String rut;
	private String nombre;
	private String horario;
	private String telefono;
	private String correo;
	private String cargo;
	private String password;
	public Trabajador(String rut, String nombre, String horario, String telefono, String correo, String cargo,String password) {
		this.rut = rut;
		this.nombre = nombre;
		this.horario = horario;
		this.telefono = telefono;
		this.correo = correo;
		this.cargo = cargo;
		this.password=password;
	}

	public String getRut() {
		return this.rut;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public String getPassword() {
		return password;
	}
	public Trabajador login(){
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return new TrabajadorDAO().login(query,this);
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean registrarTrabajador() {
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return new TrabajadorDAO().registarTrabajador(query,this);
	}
}