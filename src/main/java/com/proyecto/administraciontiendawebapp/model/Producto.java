package com.proyecto.administraciontiendawebapp.model;

import com.proyecto.administraciontiendawebapp.model.data.DBConnector;
import com.proyecto.administraciontiendawebapp.model.data.dao.ProductoDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.Date;

public class Producto {
	private String codigo;
	private String nombre;
	private int stock;
	private String categoria;
	private Date fechaVencimiento;
	private int precio;

	public Producto(String codigo, String nombre, int stock, String categoria, Date fechaVencimiento, int precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.categoria = categoria;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public boolean registraProducto(String rutTrabajadorRegistra){
		Connection connection= DBConnector.connection("tienda_db","root","");
		DSLContext query= DSL.using(connection);
		return ProductoDAO.registarArticulo(query,this,rutTrabajadorRegistra);
	}

}