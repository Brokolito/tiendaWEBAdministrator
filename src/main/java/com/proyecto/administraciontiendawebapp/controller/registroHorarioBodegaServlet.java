package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Bodega;
import com.proyecto.administraciontiendawebapp.model.data.dao.BodegaDAO;
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
            Bodega bodega=new Bodega("","","","");
            request.setAttribute("bodegas",bodega.obtenerBodegas() );
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String codBodega=request.getParameter("bodega");
        String diaComienzo=request.getParameter("diaComienzo");
        String diaTermino=request.getParameter("diaTermino");
        String horaComienzo=request.getParameter("horaComienzo");
        String horaTermino=request.getParameter("horaTermino");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/registroHorarioBodega.jsp");
        Bodega bodega=new Bodega(
                codBodega,
                "",
                (diaComienzo+"-"+diaTermino+"-"+horaComienzo+"-"+horaTermino),
                "");
        request.setAttribute("bodegas",bodega.obtenerBodegas() );
//        System.out.println(codBodega+" "+diaComienzo+" "+diaTermino+" "+horaComienzo+" "+horaTermino);
        if(!diaComienzo.isEmpty() && !diaTermino.isEmpty() && !horaComienzo.isEmpty() && !horaTermino.isEmpty()){
            System.out.println("a");
            if(bodega.registrarHorario()){
                request.setAttribute("status","Se ha registrado correctamente el horario");
            }else{
                request.setAttribute("status","Ya esta registrado el horario");
            }

        }else{
            request.setAttribute("status","Complete todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}
