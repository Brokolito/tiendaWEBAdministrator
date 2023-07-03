package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Bodega;
import com.proyecto.administraciontiendawebapp.model.Trabajador;
import com.proyecto.administraciontiendawebapp.model.data.dao.TrabajadorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroBodegaServlet",value = "/registroBodega")
public class registroBodegaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/registroBodega.jsp");
            Trabajador trabajador=new Trabajador("","","","","","3","");
            request.setAttribute("trabajadores",trabajador.obtenerTrabajador("cod_cargo"));
        }else{
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String direccionBodega=request.getParameter("direccionBodega");
        String rutEncargado=request.getParameter("trabajadorEncargado");
        if(!direccionBodega.isEmpty() && !rutEncargado.isEmpty()){
            Bodega bodega=new Bodega("",direccionBodega,"",rutEncargado);
            if(bodega.registrarBodega()){
                request.setAttribute("status","Se ha registrado correctamente");
            }else {
                request.setAttribute("status","No se ha podido registrar correctamente");
            }
        }else{
            request.setAttribute("status","Rellene correctamente todos los campos");
        }
    }
}
