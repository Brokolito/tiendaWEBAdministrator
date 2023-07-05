package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "perfilServlet",value = "/perfil")
public class perfilServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/perfil.jsp");
            Trabajador trabajador= (Trabajador) request.getSession().getAttribute("usuario");
            String nombre=trabajador.getNombre();
            request.setAttribute("nombreTrabajador",nombre);
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
}
