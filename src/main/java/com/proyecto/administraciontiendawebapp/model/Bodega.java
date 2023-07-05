package com.proyecto.administraciontiendawebapp.model;

import com.proyecto.administraciontiendawebapp.model.data.DBConnector;
import com.proyecto.administraciontiendawebapp.model.data.dao.BodegaDAO;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Bodega {
	private String codigoBodega;
	private String direccion;
	private String horario;
	private String rutJefeDeBodega;
	private ArrayList<Producto> productos;

	public Bodega(String codigoBodega, String direccion, String horario, String rutJefeDeBodega) {
		this.codigoBodega = codigoBodega;
		this.direccion = direccion;
		this.horario = horario;
		this.rutJefeDeBodega = rutJefeDeBodega;
		this.productos = new ArrayList<>();
	}

	public String getCodigoBodega() {
		return codigoBodega;
	}

	public String getRutJefeDeBodega() {
		return rutJefeDeBodega;
	}

	public void setRutJefeDeBodega(String rutJefeDeBodega) {
		this.rutJefeDeBodega = rutJefeDeBodega;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	public boolean registrarBodega(){
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return BodegaDAO.registarBodega(query,this);
	}
	public boolean registrarHorario(){
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return BodegaDAO.registrarHorario(query,this);
	}
	public Result obtenerBodegas(){
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return  BodegaDAO.obtenerBodega(query);
	}
}