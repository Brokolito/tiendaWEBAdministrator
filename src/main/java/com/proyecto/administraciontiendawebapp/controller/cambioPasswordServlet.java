package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cambioPasswordServlet",value = "/cambioPassword")
public class cambioPasswordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/cambioPassword.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        Trabajador trabajador=(Trabajador) request.getSession().getAttribute("usuario");
        String passwordSession=trabajador.getPassword();
        String oldPassword=request.getParameter("oldPassword");
        String confirmOldPassword=request.getParameter("confirmOldPassword");
        String newPassword=request.getParameter("newPassword");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/cambioPassword.jsp");
        if(oldPassword.equals(passwordSession) && oldPassword.equals(confirmOldPassword) && !newPassword.isEmpty()){
            trabajador.setPassword(newPassword);
            if(trabajador.updateInformacion()){
                request.getSession().setAttribute("usuario",trabajador);
                request.setAttribute("status","Se ha cambiado correctamente la contraseña");
            }else {
                request.setAttribute("status","Ha ocurrido un problema");
            }
        }else{
            request.setAttribute("status","Corrobore las contraseñas ingresadas");
        }
        requestDispatcher.forward(request,response);
    }
}
