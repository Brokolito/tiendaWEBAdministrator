package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "indexServlet",value = "")
public class indexServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("usuario")!=null){
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("/administrador.jsp");
            requestDispatcher.forward(request,response);
        }else{
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
