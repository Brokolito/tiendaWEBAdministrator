package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Trabajador;
import com.proyecto.administraciontiendawebapp.model.data.dao.TrabajadorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginServlet",value = "/login")
public class loginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rut=request.getParameter("rut");
        String password=request.getParameter("password");
        RequestDispatcher requestDispatcher;
        if(!rut.isEmpty() && !password.isEmpty()){
            Trabajador trabajador=new Trabajador(rut,"","","","","",password);
            Trabajador trabajador1=trabajador.login();
            if(trabajador1!=null){
                requestDispatcher=request.getRequestDispatcher("/administrador.jsp");
                request.getSession().setAttribute("usuario",trabajador1);
                requestDispatcher.forward(request,response);
            }else{
                requestDispatcher=request.getRequestDispatcher("/index.jsp");
                request.setAttribute("status","Los datos no coinciden con los registros");
            }
        }
        else{
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
            request.setAttribute("status","Ingrese todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}
