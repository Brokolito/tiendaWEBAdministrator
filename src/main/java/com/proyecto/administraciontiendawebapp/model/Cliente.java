package com.proyecto.administraciontiendawebapp.model;

import com.proyecto.administraciontiendawebapp.model.data.DBConnector;
import com.proyecto.administraciontiendawebapp.model.data.dao.ClienteDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Cliente {
	private String rut;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private ArrayList<Venta> ventas;

	public Cliente(String rut, String nombre, String direccion, String telefono,String correo) {
		this.rut=rut;
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono=telefono;
		this.ventas=new ArrayList<>();
		this.correo=correo;
	}
	public String getRut() {
		return this.rut;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}
	public  boolean registrarCliente(){
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return ClienteDAO.registarCliente(query,this);
	}
}