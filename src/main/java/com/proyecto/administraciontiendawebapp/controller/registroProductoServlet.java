package com.proyecto.administraciontiendawebapp.controller;

import com.proyecto.administraciontiendawebapp.model.Producto;
import com.proyecto.administraciontiendawebapp.model.Trabajador;
import com.proyecto.administraciontiendawebapp.model.data.dao.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.Result;

import java.io.IOException;

@WebServlet(name="registroProductoServlet",value = "/registroProducto")
public class registroProductoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher;
        if(request.getSession().getAttribute("usuario")!=null){
            requestDispatcher=request.getRequestDispatcher("/registroProducto.jsp");
            request.setAttribute("categorias",ProductoDAO.obtenerCategorias());
        }else {
            requestDispatcher=request.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse httpServletResponse) throws IOException,ServletException{
        Trabajador trabajador= (Trabajador) request.getSession().getAttribute("usuario");
        String rut=trabajador.getRut();
        request.setAttribute("categorias",ProductoDAO.obtenerCategorias());
        String nombreProducto= request.getParameter("nombreProducto");
        String categoriaProducto=request.getParameter("categoria");
        int precioProducto=Integer.parseInt(
                (!request.getParameter("precio").matches("[0-9]+")
                        || request.getParameter("precio").isEmpty()) ?
                        "0":request.getParameter("precio")
        );
        if(!nombreProducto.isEmpty() && !categoriaProducto.isEmpty() && precioProducto!=0){
            Producto producto=new Producto("",
                    nombreProducto,0,
                    categoriaProducto,
                    null,
                    precioProducto);
            if(producto.registraProducto(rut)){
                request.setAttribute("status","Se registro correctamente");
            }else{
                request.setAttribute("status","Ha ocurrido un error");
            }
        }else {

        }

    }
}
