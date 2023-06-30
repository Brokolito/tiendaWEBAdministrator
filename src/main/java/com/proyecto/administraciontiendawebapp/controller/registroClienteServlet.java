package com.proyecto.administraciontiendawebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroClienteServlet",value ="/registroCliente")
public class registroClienteServlet extends HttpServlet {
    public void doGet(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {

    }
}
