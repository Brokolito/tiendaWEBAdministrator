package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroTrabajadorServlet",value = "/registroTrabajador")
public class registroTrabajadorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("usuario")!=null){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registroTrabajador.jsp");
            requestDispatcher.forward(request,response);

        }else{
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rut=request.getAttribute("rut").toString();
        String nombre=request.getAttribute("nombre").toString();
        String fechaNacimiento=request.getAttribute("fechaNacimiento").toString();
        String fechaIngreso=request.getAttribute("fechaIngreso").toString();
        String cargo=request.getAttribute("cargo").toString();
        String correo=request.getAttribute("correo").toString();
        String password=request.getAttribute("password").toString();
        String telefono=(
                (!request.getAttribute("telefono").toString().matches("[0-9+]+")
                || !(request.getAttribute("telefono").toString().length()<=12))?"":request.getAttribute("telefono").toString()
        );
        String tipoContrato=request.getAttribute("tipoContrato").toString();
        if(!rut.isEmpty() && !nombre.isEmpty() && !fechaNacimiento.isEmpty() && !fechaIngreso.isEmpty() && !cargo.isEmpty()
                && !correo.isEmpty() && !password.isEmpty()) {
            Trabajador trabajador=new Trabajador(rut,nombre,tipoContrato,telefono,correo,cargo,password);
            if(trabajador.registrarTrabajador()){
                request.setAttribute("status","Se ha registrado correctamente el trabajador");
            }else{
                request.setAttribute("status","Rut ya ha sido registrado");
            }

        }else{
            request.setAttribute("status","Revise los campos");
        }
    }
}
