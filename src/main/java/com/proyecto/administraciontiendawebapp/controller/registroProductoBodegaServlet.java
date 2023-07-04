package com.proyecto.administraciontiendawebapp.controller;


import com.proyecto.administraciontiendawebapp.model.Trabajador;
import com.proyecto.administraciontiendawebapp.model.data.dao.BodegaDAO;
import com.proyecto.administraciontiendawebapp.model.data.dao.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="registroProductoBodegaServlet",value = "/registroProductoBodega")
public class registroProductoBodegaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/registroProductoBodega.jsp");
            request.setAttribute("productos", ProductoDAO.obtenerProductos());
            request.setAttribute("bodegas", BodegaDAO.obtenerBodegas());
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        Trabajador trabajador= (Trabajador) request.getSession().getAttribute("usuario");
        String rut=trabajador.getRut();
        request.setAttribute("productos",ProductoDAO.obtenerProductos());
        request.setAttribute("bodegas", BodegaDAO.obtenerBodegas());
        String codigoProducto = request.getParameter("producto");
        String codigoBodega = request.getParameter("bodega");
        int cantidad= Integer.parseInt(request.getParameter("cantidad"));
        String fechaVencimiento = request.getParameter("fecha_vencimiento");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registroProductoBodega.jsp");
        System.out.println(codigoProducto);
        System.out.println(codigoBodega);
        if(cantidad > 0 && fechaVencimiento.length() == 0) {
            if (BodegaDAO.registrarProductoBodega(codigoBodega, rut, codigoProducto, cantidad, null)) {
                request.setAttribute("status", "Se registro correctamente");
            } else {
                request.setAttribute("status", "Ha ocurrido un error");
            }
        }else if(cantidad>0){
            if(BodegaDAO.registrarProductoBodega(codigoBodega,rut,codigoProducto,cantidad,fechaVencimiento)){
                request.setAttribute("status","Se registro correctamente");
            } else {
                request.setAttribute("status", "Ha ocurrido un error");
            }
        }else {
            request.setAttribute("status","Rellene todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}

