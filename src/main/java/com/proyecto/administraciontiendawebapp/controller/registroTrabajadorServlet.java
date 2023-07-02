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
        String rut=request.getParameter("rut").toString();
        System.out.println(rut);
        String nombre=request.getParameter("nombre").toString();
        String fechaNacimiento=request.getParameter("fechaNacimiento").toString();
        String fechaIngreso=request.getParameter("fechaIngreso").toString();
        String cargo=request.getParameter("cargo").toString();
        String correo=request.getParameter("correo").toString();
        String password=request.getParameter("password").toString();
        String telefono=(
                (!request.getParameter("telefono").toString().matches("[+0-9]+")
                || !(request.getParameter("telefono").toString().length()<=12))?"":request.getParameter("telefono").toString()
        );
        String tipoContrato=request.getParameter("tipoContrato").toString();
        if(!rut.isEmpty() && !nombre.isEmpty() && !fechaNacimiento.isEmpty() && !fechaIngreso.isEmpty() && !cargo.isEmpty()
                && !correo.isEmpty() && !password.isEmpty()) {
            Trabajador trabajador=new Trabajador(rut,nombre,tipoContrato,telefono,correo,cargo,password);
            trabajador.setFechaEntrada(fechaIngreso);
            trabajador.setFechaNacimiento(fechaNacimiento);
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
