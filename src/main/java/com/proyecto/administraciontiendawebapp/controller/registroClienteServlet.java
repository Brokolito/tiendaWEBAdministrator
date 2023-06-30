package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroClienteServlet",value ="/registroCliente")
public class registroClienteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registroCliente.jsp");
        System.out.println("registro");
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String rut=request.getParameter("rut");
        String nombre=request.getParameter("nombre");
        String direccion=request.getParameter("direccion");
        String telefono=request.getParameter("telefono");
        String correo=request.getParameter("correo");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registroCliente.jsp");
        if(!rut.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()){
            Cliente cliente=new Cliente(rut,nombre,direccion,telefono,correo);
            if(cliente.registrarCliente()){
                request.setAttribute("status","Se ha registrado existosamente el nuevo cliente");
            }else{
                request.setAttribute("status","El rut ya ha sido registrado");
            }
        }else{
            request.setAttribute("status","Complete correctamente todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}
