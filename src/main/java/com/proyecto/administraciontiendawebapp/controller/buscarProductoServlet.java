package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.data.dao.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="buscarProductoServlet",value = "/buscarProducto")
public class buscarProductoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            request.setAttribute("categorias",ProductoDAO.obtenerCategorias());
            System.out.println(1);
            System.out.println(ProductoDAO.obtenerCategorias());
            requestDispatcher=request.getRequestDispatcher("/buscarProducto.jsp");
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String nombreProducto = request.getParameter("nombreProducto");
        String categoriaProducto = request.getParameter("categoria");
        request.setAttribute("categorias",ProductoDAO.obtenerCategorias());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/buscarProducto.jsp");

        if(!categoriaProducto.isEmpty() && nombreProducto.equals("")) {
            if(!ProductoDAO.obtenerProductosParametro("cod_categoria",categoriaProducto).isEmpty()) {
                request.setAttribute("productos", ProductoDAO.obtenerProductosParametro("cod_categoria", categoriaProducto));
                requestDispatcher = request.getRequestDispatcher("/listaProductos.jsp");
            }else{
                request.setAttribute("status","No se han encontrado productos, intente nuevamente");
            }
        }else if (!nombreProducto.isEmpty() && categoriaProducto.equals("0")) {
            if(!ProductoDAO.obtenerProductosParametro("nombre_producto", nombreProducto).isEmpty()) {
                request.setAttribute("productos", ProductoDAO.obtenerProductosParametro("nombre_producto", nombreProducto));
                requestDispatcher = request.getRequestDispatcher("/listaProductos.jsp");
            }else{
                request.setAttribute("status","No se han encontrado productos, intente nuevamente");
            }
        }else if(!categoriaProducto.isEmpty() && !nombreProducto.isEmpty()){
            if(!ProductoDAO.obtenerProductosDosParametro("nombre_producto", nombreProducto,"cod_producto",categoriaProducto).isEmpty()) {
                request.setAttribute("productos", ProductoDAO.obtenerProductosDosParametro("nombre_producto", nombreProducto,"cod_producto",categoriaProducto));
                requestDispatcher = request.getRequestDispatcher("/listaProductos.jsp");
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
