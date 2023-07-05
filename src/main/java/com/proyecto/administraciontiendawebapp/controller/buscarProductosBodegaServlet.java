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

@WebServlet(name="buscarProductosBodegaServlet",value = "/buscarProductosBodega")
public class buscarProductosBodegaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            request.setAttribute("bodegas", BodegaDAO.obtenerBodegas());
            requestDispatcher=request.getRequestDispatcher("/buscarProductosBodega.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String codigoBodega = request.getParameter("bodega");
        request.setAttribute("bodegas", BodegaDAO.obtenerBodegas());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/buscarProductosBodega.jsp");

        if(!codigoBodega.isEmpty()) {
            if(!BodegaDAO.obtenerProductosAlmacenados("cod_bodega",codigoBodega).isEmpty()) {
                request.setAttribute("productos", BodegaDAO.obtenerProductosAlmacenados("cod_bodega", codigoBodega));
                System.out.println(BodegaDAO.obtenerProductosAlmacenados("cod_bodega", codigoBodega));
                requestDispatcher = request.getRequestDispatcher("/listaProductosBodegas.jsp");
            }else{
                request.setAttribute("status","No se han encontrado productos, intente nuevamente");
            }
        }
        else {
            request.setAttribute("status","Rellene todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}
