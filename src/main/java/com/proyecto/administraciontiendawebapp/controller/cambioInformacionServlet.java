package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "cambioInformacionServlet",value = "/cambioInformacion")
public class cambioInformacionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/cambioInformacion.jsp");
            Trabajador trabajador=(Trabajador) request.getSession().getAttribute("usuario");
            String correoAntiguo=trabajador.getCorreo();
            String telefonoAntiguo=trabajador.getTelefono();
            request.setAttribute("correoAntiguo",correoAntiguo);
            request.setAttribute("telefonoAntiguo",telefonoAntiguo);
        }else{
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String telefonoNuevo=request.getParameter("telefonoNuevo");
        String correoNuevo=request.getParameter("correoNuevo");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/cambioInformacion.jsp");
        if(!telefonoNuevo.isEmpty() && !correoNuevo.isEmpty()){
            Trabajador trabajador=(Trabajador)  request.getSession().getAttribute("usuario");
            trabajador.setCorreo(correoNuevo);
            trabajador.setTelefono(telefonoNuevo);
            if(trabajador.updateInformacion()){
                request.getSession().setAttribute("usuario",trabajador);
                request.setAttribute("status","Se ha hecho los cambios correctamente");
            }else{
                request.setAttribute("status","No se ha podido hacer los cambios");
            }
        }else{
            request.setAttribute("status","Rellene todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}
