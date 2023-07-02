package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.data.dao.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroCategoriaServlet",value = "/registroCategoria")
public class registroCategoriaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/registroCategoria.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        String nombreCategoria=request.getParameter("categoria").toString();
        if(!nombreCategoria.isEmpty()){
            if(ProductoDAO.registrarCategoria(nombreCategoria)){
                request.setAttribute("status","Se ha registrado correctamente la categoria");
            }else{
                request.setAttribute("status","Ha ocurrido un error");
            }
        }else{
            request.setAttribute("status","Rellene todos los campos");
        }
        RequestDispatcher requestDispatche=request.getRequestDispatcher("/registroCategoria.jsp");
        requestDispatche.forward(request,response);
    }
}
