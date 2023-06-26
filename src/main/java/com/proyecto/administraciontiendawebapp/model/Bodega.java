package com.proyecto.administraciontiendawebapp.model;

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
}