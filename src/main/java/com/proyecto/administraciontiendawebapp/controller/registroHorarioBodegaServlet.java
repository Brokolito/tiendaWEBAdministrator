package com.proyecto.administraciontiendawebapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroHorarioBodegaServlet",value = "/registroHorarioBodega")
public class registroHorarioBodegaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/registroHorarioBodega.jsp");

        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String diaComienzo=request.getParameter("diaComienzo");
        String diaTermino=request.getParameter("diaComienzo");
    }
}
